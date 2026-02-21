package com.vehicle.constant;

public class SecurityConstants {

    private SecurityConstants() {}

    // JWT Claims
    public static final String CLAIM_USER_ID = "userId";
    public static final String CLAIM_USER_ROLE = "role";
    public static final String CLAIM_USER_EMAIL = "email";
    public static final String CLAIM_USER_MOBILE = "mobile";
    public static final String CLAIM_USER_NAME = "name";

    // Roles
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    public static final String ROLE_PROVIDER = "ROLE_PROVIDER";
    public static final String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

    // Headers
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_BEARER = "Bearer ";
    public static final String HEADER_USER_ID = "X-User-Id";
    public static final String HEADER_USER_ROLE = "X-User-Role";
    public static final String HEADER_REQUEST_ID = "X-Request-Id";
    public static final String HEADER_CORRELATION_ID = "X-Correlation-Id";

    // Public paths that don't require authentication
    public static final String[] PUBLIC_PATHS = {
            "/api/v1/auth/**",
            "/api/v1/health/**",
            "/actuator/health",
            "/actuator/info",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/ws-tracking/**"
    };

    // Token
    public static final int TOKEN_EXPIRY_HOURS = 24;
    public static final int REFRESH_TOKEN_EXPIRY_DAYS = 7;
    public static final int OTP_EXPIRY_MINUTES = 5;
}
