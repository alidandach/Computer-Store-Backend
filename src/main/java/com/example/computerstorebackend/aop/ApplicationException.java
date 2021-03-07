package com.example.computerstorebackend.aop;

import com.example.computerstorebackend.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Application exception.
 */
@Getter
@Setter
public class ApplicationException extends RuntimeException {
    /**
     * The Status code.
     */
    protected StatusCode statusCode;
    /**
     * The Log message.
     */
    protected String logMessage;
    /**
     * The Client message.
     */
    protected String clientMessage;
    /**
     * The Parameters.
     */
    protected Object[] parameters;

    /**
     * Instantiates a new Application exception.
     *
     * @param statusCode the status code
     * @param logMessage the log message
     * @param param      the param
     */
    public ApplicationException(StatusCode statusCode, String logMessage, Object... param) {
        super(statusCode.getMessage());
        this.statusCode = statusCode;
        this.logMessage = logMessage;
        this.clientMessage = statusCode.getMessage();
        this.parameters = param;
    }
}
