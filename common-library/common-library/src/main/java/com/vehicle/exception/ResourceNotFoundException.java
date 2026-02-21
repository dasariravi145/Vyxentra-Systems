package com.vehicle.exception;

import com.vehicle.constant.ErrorConstants;


import com.vehicle.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends com.vehicle.common.exception.BaseException {

    public ResourceNotFoundException(String message) {
        super(message,
                ErrorCode.RESOURCE_NOT_FOUND.getCode(),
                HttpStatus.NOT_FOUND);
    }
}
