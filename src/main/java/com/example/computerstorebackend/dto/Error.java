package com.example.computerstorebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Error.
 */
@Getter
@Setter
@AllArgsConstructor
public class Error extends ClientData {
    private String details;
}
