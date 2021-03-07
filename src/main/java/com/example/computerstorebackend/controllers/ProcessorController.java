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

@Validated
@RestController
@AllArgsConstructor
public class ProcessorController {
    private final ProcessorService processorService;

    @PostMapping("/chipset-type")
    public ClientResponse<ClientData> addChipsetType(@RequestBody @Valid ProcessorDto.AddChipsetType request) {
        processorService.addChipsetType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    @GetMapping("/chipset-type/{type}")
    public ClientResponse<ProcessorDto.ViewChipsetType> viewChipsetType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewChipsetType(type));
    }

    @GetMapping("/chipset-type")
    public ClientResponse<ProcessorDto.ViewListChipsetType> viewChipsetTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                                @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewChipsetTypePage(pageNumber, pageSize));
    }

    @PostMapping("/socket-type")
    public ClientResponse<ClientData> addSocketType(@RequestBody @Valid ProcessorDto.AddSocketType request) {
        processorService.addSocketType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    @GetMapping("/socket-type/{type}")
    public ClientResponse<ProcessorDto.ViewSocketType> viewSocketType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewSocketType(type));
    }

    @GetMapping("/socket-type")
    public ClientResponse<ProcessorDto.ViewListSocketType> viewSocketTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                              @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewSocketPage(pageNumber, pageSize));
    }

    @PostMapping("/processor")
    public ClientResponse<ClientData> addProcessor(@RequestBody @Valid ProcessorDto.AddProcessor request) {
        processorService.addProcessor(request);
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    @GetMapping("/processor/{key}")
    public ClientResponse<ProcessorDto.ViewProcessor> viewProcessor(@PathVariable String key) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewProcessor(key));
    }

    @GetMapping("/processor")
    public ClientResponse<ProcessorDto.ViewListProcessor> viewProcessorPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                            @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, processorService.viewProcessorPage(pageNumber, pageSize));
    }
}