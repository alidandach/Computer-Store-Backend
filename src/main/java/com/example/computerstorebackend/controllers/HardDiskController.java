package com.example.computerstorebackend.controllers;

import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.dto.ClientResponse;
import com.example.computerstorebackend.dto.entities.HardDiskDto;
import com.example.computerstorebackend.enums.StatusCode;
import com.example.computerstorebackend.services.harddisk.HardDiskService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Hard disk controller.
 */
@Validated
@RestController
@AllArgsConstructor
public class HardDiskController {
    private final HardDiskService hardDiskService;

    /**
     * Add hard disk type client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/hard-disk-type")
    public ClientResponse<ClientData> addHardDiskType(@RequestBody @Valid HardDiskDto.AddHardDiskType request) {
        hardDiskService.addHardDiskType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View hard disk type client response.
     *
     * @param type the type
     * @return the client response
     */
    @GetMapping("/hard-disk-type/{type}")
    public ClientResponse<HardDiskDto.ViewHardDiskType> viewHardDiskType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDiskType(type));
    }

    /**
     * View hard disk type page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/hard-disk-type")
    public ClientResponse<HardDiskDto.ViewListHardDiskType> viewHardDiskTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                                 @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDiskTypePage(pageNumber, pageSize));
    }

    /**
     * Add hard disk client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping("/hard-disk")
    public ClientResponse<ClientData> addHardDisk(@RequestBody @Valid HardDiskDto.AddHardDisk request) {
        hardDiskService.addHardDisk(request.getKey(), request.getAmount(), request.getType());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View hard disk client response.
     *
     * @param key the key
     * @return the client response
     */
    @GetMapping("/hard-disk/{key}")
    public ClientResponse<HardDiskDto.ViewHardDisk> viewHardDisk(@PathVariable String key) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDisk(key));
    }

    /**
     * View hard disk page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping("/hard-disk")
    public ClientResponse<HardDiskDto.ViewLisHardDisk> viewHardDiskPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                        @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDiskPage(pageNumber, pageSize));
    }
}