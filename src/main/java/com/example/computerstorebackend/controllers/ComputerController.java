package com.example.computerstorebackend.controllers;

import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.dto.ClientResponse;
import com.example.computerstorebackend.dto.entities.ComputerDto;
import com.example.computerstorebackend.enums.StatusCode;
import com.example.computerstorebackend.services.computer.ComputerService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Computer controller.
 */
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/computer")
public class ComputerController {
    private final ComputerService computerService;


    /**
     * Add computer client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping
    public ClientResponse<ClientData> addComputer(@RequestBody @Valid ComputerDto.AddComputer request) {
        computerService.addComputer(request);
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View computer client response.
     *
     * @param key the key
     * @return the client response
     */
    @GetMapping("/{key}")
    public ClientResponse<ComputerDto.ViewComputer> viewComputer(@PathVariable @StringValue(isRequired = true) String key) {
        return new ClientResponse<>(StatusCode.SUCCESS, computerService.viewComputer(key));
    }

    /**
     * View computer page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping
    public ClientResponse<ComputerDto.ViewListComputer> viewComputerPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                         @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, computerService.viewComputerPage(pageNumber, pageSize));
    }

}
