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

@Validated
@RestController
@AllArgsConstructor
public class HardDiskController {
    private final HardDiskService hardDiskService;

    @PostMapping("/hard-disk-type")
    public ClientResponse<ClientData> addHardDiskType(@RequestBody @Valid HardDiskDto.AddHardDiskType request) {
        hardDiskService.addHardDiskType(request.getKey());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    @GetMapping("/hard-disk-type/{type}")
    public ClientResponse<HardDiskDto.ViewHardDiskType> viewHardDiskType(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDiskType(type));
    }

    @GetMapping("/hard-disk-type")
    public ClientResponse<HardDiskDto.ViewListHardDiskType> viewHardDiskTypePage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                                 @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDiskTypePage(pageNumber, pageSize));
    }

    @PostMapping("/hard-disk")
    public ClientResponse<ClientData> addHardDisk(@RequestBody @Valid HardDiskDto.AddHardDisk request) {
        hardDiskService.addHardDisk(request.getKey(), request.getAmount(), request.getType());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    @GetMapping("/hard-disk/{key}")
    public ClientResponse<HardDiskDto.ViewHardDisk> viewHardDisk(@PathVariable String key) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDisk(key));
    }

    @GetMapping("/hard-disk")
    public ClientResponse<HardDiskDto.ViewLisHardDisk> viewHardDiskPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                        @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, hardDiskService.viewHardDiskPage(pageNumber, pageSize));
    }
}