package com.vehicle.exception;

import com.vehicle.constant.ErrorConstants;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ValidationException extends com.vehicle.common.exception.BaseException {

    private final Map<String, String> errors;

    public ValidationException(String message, Map<String, String> errors) {
        super(message, ErrorConstants.ERR_VALIDATION, HttpStatus.BAD_REQUEST);
        this.errors = errors;
    }
}