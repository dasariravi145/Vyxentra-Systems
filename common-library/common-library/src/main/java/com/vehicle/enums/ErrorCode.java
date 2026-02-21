package com.vehicle.enums;

public enum ErrorCode {

    RESOURCE_NOT_FOUND("ERR-404"),
    BUSINESS_ERROR("ERR-400"),
    UNAUTHORIZED("ERR-401"),
    VALIDATION_FAILED("ERR-422"),
    INTERNAL_ERROR("ERR-500");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
