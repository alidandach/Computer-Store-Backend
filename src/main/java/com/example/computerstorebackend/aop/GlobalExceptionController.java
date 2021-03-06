package com.example.computerstorebackend.aop;

import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.dto.ClientResponse;
import com.example.computerstorebackend.dto.Error;
import com.example.computerstorebackend.dto.Violation;
import com.example.computerstorebackend.enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * The type Global exception controller.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionController {
    /**
     * On constraint validation exception client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ClientResponse<ClientData> onConstraintValidationException(ConstraintViolationException exception) {
        log.warn(exception.getMessage());

        ClientResponse<ClientData> response = new ClientResponse<>(StatusCode.INVALID_PARAMETERS);

        for (ConstraintViolation<?> violation : exception.getConstraintViolations())
            response.addViolation(new Violation(violation.getPropertyPath()
                                                         .toString(), violation.getMessage()));

        return response;
    }

    /**
     * Bad requests client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ClientResponse<ClientData> badRequests(MethodArgumentNotValidException exception) {
        log.warn(exception.getMessage());

        ClientResponse<ClientData> response = new ClientResponse<>(StatusCode.INVALID_PARAMETERS);

        for (FieldError error : exception.getBindingResult()
                                         .getFieldErrors())
            response.addViolation(new Violation(error.getField(), error.getDefaultMessage()));

        return response;
    }

    /**
     * Parameters not found client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public ClientResponse<ClientData> parametersNotFound(MissingServletRequestParameterException exception) {
        log.warn(exception.getMessage());
        return new ClientResponse<>(StatusCode.HTTP_METHOD_NOT_SUPPORTED);
    }

    /**
     * Bad http parsing client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpMessageConversionException.class})
    public ClientResponse<ClientData> badHttpParsing(HttpMessageConversionException exception) {
        log.warn(exception.getMessage());
        return new ClientResponse<>(StatusCode.INVALID_METHOD_ARGUMENTS);
    }

    /**
     * Http method not supported client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ClientResponse<ClientData> httpMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        log.warn(exception.getMessage());
        return new ClientResponse<>(StatusCode.HTTP_METHOD_NOT_SUPPORTED);
    }

    /**
     * Exception client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ClientResponse<ClientData> exception(Exception exception) {
        log.error(ExceptionUtils.getFullStackTrace(exception));
        return new ClientResponse<>(StatusCode.INTERNAL_SERVER_ERROR);
    }

    /**
     * Exception client response.
     *
     * @param exception the exception
     * @return the client response
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = ApplicationException.class)
    public ClientResponse<ClientData> exception(ApplicationException exception) {
        log.warn(exception.getLogMessage(), (Object) exception.getParameters());
        return new ClientResponse<>(exception.getStatusCode(), new Error(exception.getMessage()));
    }
}