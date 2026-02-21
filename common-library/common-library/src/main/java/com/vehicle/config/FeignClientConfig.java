package com.vehicle.config;

import feign.RequestInterceptor;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate ->
                requestTemplate.header("X-Service-Name", "vehicle-service");
    }

    @Bean
    public Resilience4jFeign.Builder feignBuilder() {

        // -------------------------
        // Circuit Breaker
        // -------------------------
        CircuitBreakerConfig cbConfig = CircuitBreakerConfig.custom()
                .slidingWindowSize(10)
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .build();

        CircuitBreaker circuitBreaker =
                CircuitBreaker.of("vehicleServiceCB", cbConfig);

        // -------------------------
        // Retry
        // -------------------------
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(1000))
                .retryExceptions(Exception.class)
                .build();

        Retry retry = Retry.of("vehicleServiceRetry", retryConfig);

        // -------------------------
        // Rate Limiter
        // -------------------------
        RateLimiterConfig rateLimiterConfig = RateLimiterConfig.custom()
                .limitForPeriod(10)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        RateLimiter rateLimiter =
                RateLimiter.of("vehicleServiceRateLimiter", rateLimiterConfig);

        // -------------------------
        // Decorators
        // -------------------------
        FeignDecorators decorators = FeignDecorators.builder()
                .withCircuitBreaker(circuitBreaker)
                .withRetry(retry)
                .withRateLimiter(rateLimiter)
                .build();
        return Resilience4jFeign.builder(decorators);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    static class CustomErrorDecoder implements ErrorDecoder {

        private final ErrorDecoder defaultDecoder = new Default();

        @Override
        public Exception decode(String methodKey, feign.Response response) {
            if (response.status() >= 500) {
                return new RetryableException(
                        response.status(),
                        "Server error: " + response.reason(),
                        response.request().httpMethod(),
                        (Long) null,
                        response.request()
                );
            }
            return defaultDecoder.decode(methodKey, response);
        }
    }
}