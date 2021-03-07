package com.example.computerstorebackend.enums;

import lombok.Getter;

/**
 * The enum Status code.
 */
@Getter
public enum StatusCode {
    /**
     * The Success.
     */
    /*
     * Entry For Success Scenario
     */
    SUCCESS(1000, "Success"),

    /**
     * The Invalid parameters.
     */
    /*
     * Entry For Application Error
     */
    INVALID_PARAMETERS(2000, "Validation Failure"),
    /**
     * The Invalid method arguments.
     */
    INVALID_METHOD_ARGUMENTS(2001, "Invalid Method Argument"),
    /**
     * The Http method not supported.
     */
    HTTP_METHOD_NOT_SUPPORTED(2002, "HTTP Method Not Supported"),
    /**
     * The Record not found.
     */
    RECORD_NOT_FOUND(2003, "Record Not Found"),
    /**
     * The Duplicate record.
     */
    DUPLICATE_RECORD(2004, "Duplicate in record"),
    /**
     * The Internal server error.
     */
    /*
     * Entry For UN_HANDLED Exceptions
     */
    INTERNAL_SERVER_ERROR(5000, "Internal Server Error");

    private final int code;
    private final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}