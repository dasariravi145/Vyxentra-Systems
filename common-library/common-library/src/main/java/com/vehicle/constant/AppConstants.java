package com.vehicle.constant;

public class AppConstants {

    private AppConstants() {}

    // API Versions
    public static final String API_VERSION_1 = "/api/v1";

    // Service Names
    public static final String SERVICE_AUTH = "auth-service";
    public static final String SERVICE_USER = "user-service";
    public static final String SERVICE_PROVIDER = "provider-service";
    public static final String SERVICE_BOOKING = "booking-service";
    public static final String SERVICE_EMERGENCY = "emergency-dispatch-service";
    public static final String SERVICE_TRACKING = "tracking-service";
    public static final String SERVICE_PAYMENT = "payment-service";
    public static final String SERVICE_NOTIFICATION = "notification-service";
    public static final String SERVICE_ADMIN = "admin-service";

    // Redis Keys
    public static final String REDIS_KEY_OTP_PREFIX = "otp:";
    public static final String REDIS_KEY_TOKEN_PREFIX = "token:";
    public static final String REDIS_KEY_BOOKING_PREFIX = "booking:";
    public static final String REDIS_KEY_PROVIDER_PREFIX = "provider:";
    public static final String REDIS_KEY_TRACKING_PREFIX = "tracking:";
    public static final String REDIS_KEY_LOCK_PREFIX = "lock:";
    public static final String REDIS_KEY_GEO_PROVIDER = "providers:geo";
    public static final String REDIS_KEY_GEO_EMERGENCY = "emergency:providers:geo";

    // Kafka Topics
    public static final String KAFKA_TOPIC_BOOKING_CREATED = "booking-created";
    public static final String KAFKA_TOPIC_BOOKING_ASSIGNED = "booking-assigned";
    public static final String KAFKA_TOPIC_BOOKING_COMPLETED = "booking-completed";
    public static final String KAFKA_TOPIC_BOOKING_CANCELLED = "booking-cancelled";
    public static final String KAFKA_TOPIC_EMERGENCY_TRIGGERED = "emergency-triggered";
    public static final String KAFKA_TOPIC_DAMAGE_REPORTED = "damage-reported";
    public static final String KAFKA_TOPIC_DAMAGE_APPROVED = "damage-approved";
    public static final String KAFKA_TOPIC_PAYMENT_SUCCESS = "payment-success";
    public static final String KAFKA_TOPIC_PAYMENT_FAILED = "payment-failed";
    public static final String KAFKA_TOPIC_PROVIDER_APPROVED = "provider-approved";
    public static final String KAFKA_TOPIC_PROVIDER_SUSPENDED = "provider-suspended";
    public static final String KAFKA_TOPIC_USER_REGISTERED = "user-registered";

    // Date Formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_ZONE_UTC = "UTC";

    // Pagination
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;

    // Cache Names
    public static final String CACHE_PROVIDERS = "providers";
    public static final String CACHE_USERS = "users";
    public static final String CACHE_BOOKINGS = "bookings";
    public static final String CACHE_PRICING = "pricing";
}
