package com.vehicle.exception;

import com.vehicle.constant.ErrorConstants;

import com.vehicle.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends com.vehicle.common.exception.BaseException {

    public UnauthorizedException(String message) {
        super(message,
                ErrorCode.UNAUTHORIZED.getCode(),
                HttpStatus.UNAUTHORIZED);
    }
}