package com.example.computerstorebackend.dto;

import com.example.computerstorebackend.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Client response.
 *
 * @param <T> the type parameter
 */
@Getter
@Setter
public class ClientResponse<T extends ClientData> {
    private String status;
    private Integer code;
    private T data;
    private List<Violation> violations;

    /**
     * Instantiates a new Client response.
     *
     * @param code the code
     */
    public ClientResponse(StatusCode code) {
        this.code = code.getCode();
        this.status = code.getMessage();
    }

    /**
     * Instantiates a new Client response.
     *
     * @param code the code
     * @param data the data
     */
    public ClientResponse(StatusCode code, T data) {
        this.data = data;
        this.code = code.getCode();
        this.status = code.getMessage();
    }

    /**
     * Add violation.
     *
     * @param violation the violation
     */
    public void addViolation(Violation violation) {
        if (violations == null)
            violations = new ArrayList<>();
        violations.add(violation);
    }
}
