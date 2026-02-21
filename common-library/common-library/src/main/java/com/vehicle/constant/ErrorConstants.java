package com.vehicle.constant;

public final class ErrorConstants {
     private ErrorConstants(){

     }

    // Error Codes
    public static final String ERR_VALIDATION = "ERR-001";
    public static final String ERR_UNAUTHORIZED = "ERR-002";
    public static final String ERR_FORBIDDEN = "ERR-003";
    public static final String ERR_NOT_FOUND = "ERR-004";
    public static final String ERR_CONFLICT = "ERR-005";
    public static final String ERR_INTERNAL = "ERR-006";
    public static final String ERR_BUSINESS = "ERR-007";
    public static final String ERR_SERVICE_UNAVAILABLE = "ERR-008";
    public static final String ERR_TIMEOUT = "ERR-009";
    public static final String ERR_RATE_LIMIT = "ERR-010";

    // Error Messages
    public static final String MSG_VALIDATION_FAILED = "Validation failed";
    public static final String MSG_UNAUTHORIZED = "Unauthorized access";
    public static final String MSG_FORBIDDEN = "Access denied";
    public static final String MSG_RESOURCE_NOT_FOUND = "Resource not found";
    public static final String MSG_INTERNAL_ERROR = "Internal server error";
    public static final String MSG_BUSINESS_ERROR = "Business rule violation";
    public static final String MSG_SERVICE_UNAVAILABLE = "Service temporarily unavailable";
    public static final String MSG_TIMEOUT = "Request timeout";
    public static final String MSG_RATE_LIMIT = "Too many requests";
}
