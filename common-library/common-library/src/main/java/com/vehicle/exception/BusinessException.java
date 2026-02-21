package com.vehicle.exception;

import com.vehicle.constant.ErrorConstants;

import com.vehicle.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class BusinessException extends com.vehicle.common.exception.BaseException {

    public BusinessException(String message) {
        super(message,
                ErrorCode.BUSINESS_ERROR.getCode(),
                HttpStatus.BAD_REQUEST);
    }
}
