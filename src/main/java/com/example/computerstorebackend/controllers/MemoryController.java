package com.example.computerstorebackend.controllers;

import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.dto.ClientResponse;
import com.example.computerstorebackend.dto.entities.MemoryDto;
import com.example.computerstorebackend.enums.StatusCode;
import com.example.computerstorebackend.services.memory.MemoryService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Memory controller.
 */
@Validated
@RestController
@AllArgsConstructor
public class MemoryController {
    private final MemoryService memoryService;

    /**
     * Add memory type client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/memory-type")
    public ClientResponse<ClientData> addMemoryType(@RequestBody @Valid MemoryDto.AddMemoryType request) {
        memoryService.addMemoryType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View memory type client response.
     *
     * @param type the type
     * @return the client response
     */
    @GetMapping("/memory-type/{type}")
    public ClientResponse<MemoryDto.ViewMemoryType> viewMemoryType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, memoryService.viewMemoryType(type));
    }

    /**
     * View memory type page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/memory-type")
    public ClientResponse<MemoryDto.ViewListMemoryType> viewMemoryTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                           @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, memoryService.viewMemoryTypePage(pageNumber, pageSize));
    }

    /**
     * Add memory client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/memory")
    public ClientResponse<ClientData> addMemory(@RequestBody @Valid MemoryDto.AddMemory request) {
        memoryService.addMemory(request.getKey(), request.getAmount(), request.getType());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View memory client response.
     *
     * @param key the key
     * @return the client response
     */
    @GetMapping("/memory/{key}")
    public ClientResponse<MemoryDto.ViewMemory> viewMemory(@PathVariable String key) {
        return new ClientResponse<>(StatusCode.SUCCESS, memoryService.viewMemory(key));
    }

    /**
     * View memory page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/memory")
    public ClientResponse<MemoryDto.ViewLisMemory> viewMemoryPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                  @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, memoryService.viewMemoryPage(pageNumber, pageSize));
    }
}
