package com.example.computerstorebackend.controllers;

import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.dto.ClientResponse;
import com.example.computerstorebackend.dto.entities.ProcessorDto;
import com.example.computerstorebackend.enums.StatusCode;
import com.example.computerstorebackend.services.processor.ProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Processor controller.
 */
@Validated
@RestController
@AllArgsConstructor
public class ProcessorController {
    private final ProcessorService processorService;

    /**
     * Add chipset type client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/chipset-type")
    public ClientResponse<ClientData> addChipsetType(@RequestBody @Valid ProcessorDto.AddChipsetType request) {
        processorService.addChipsetType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View chipset type client response.
     *
     * @param type the type
     * @return the client response
     */
    @GetMapping("/chipset-type/{type}")
    public ClientResponse<ProcessorDto.ViewChipsetType> viewChipsetType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewChipsetType(type));
    }

    /**
     * View chipset type page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/chipset-type")
    public ClientResponse<ProcessorDto.ViewListChipsetType> viewChipsetTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                                @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewChipsetTypePage(pageNumber, pageSize));
    }

    /**
     * Add socket type client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/socket-type")
    public ClientResponse<ClientData> addSocketType(@RequestBody @Valid ProcessorDto.AddSocketType request) {
        processorService.addSocketType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View socket type client response.
     *
     * @param type the type
     * @return the client response
     */
    @GetMapping("/socket-type/{type}")
    public ClientResponse<ProcessorDto.ViewSocketType> viewSocketType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewSocketType(type));
    }

    /**
     * View socket type page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/socket-type")
    public ClientResponse<ProcessorDto.ViewListSocketType> viewSocketTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                              @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewSocketPage(pageNumber, pageSize));
    }

    /**
     * Add processor client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/processor")
    public ClientResponse<ClientData> addProcessor(@RequestBody @Valid ProcessorDto.AddProcessor request) {
        processorService.addProcessor(request);
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View processor client response.
     *
     * @param key the key
     * @return the client response
     */
    @GetMapping("/processor/{key}")
    public ClientResponse<ProcessorDto.ViewProcessor> viewProcessor(@PathVariable String key) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewProcessor(key));
    }

    /**
     * View processor page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/processor")
    public ClientResponse<ProcessorDto.ViewListProcessor> viewProcessorPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                            @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewProcessorPage(pageNumber, pageSize));
    }
}