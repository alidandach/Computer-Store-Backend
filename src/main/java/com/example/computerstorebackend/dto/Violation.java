package com.example.computerstorebackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Violation.
 */
@Getter
@Setter
@ToString
public class Violation {
    private String fieldName;
    private String message;

    /**
     * Instantiates a new Violation.
     *
     * @param fieldName the field name
     * @param message   the message
     */
    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}