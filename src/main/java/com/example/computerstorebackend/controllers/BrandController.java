package com.example.computerstorebackend.controllers;

import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.dto.ClientResponse;
import com.example.computerstorebackend.dto.entities.BrandDto;
import com.example.computerstorebackend.enums.StatusCode;
import com.example.computerstorebackend.services.brand.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Brand controller.
 */
@Validated
@RestController
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {
    private final BrandService brandService;

    /**
     * Add brand client response.
     *
     * @param request the request
     * @return the client response
     */
    @PostMapping
    public ClientResponse<ClientData> addBrand(@RequestBody @Valid BrandDto.AddBrand request) {
        brandService.addBrand(request.getKey(), request.getName());
        return new ClientResponse<>(StatusCode.SUCCESS);
    }

    /**
     * View brand client response.
     *
     * @param type the type
     * @return the client response
     */
    @GetMapping("/{type}")
    public ClientResponse<BrandDto.ViewBrand> viewBrand(@PathVariable @StringValue(isRequired = true) String type) {
        return new ClientResponse<>(StatusCode.SUCCESS, brandService.viewBrand(type));
    }

    /**
     * View brand page client response.
     *
     * @param pageSize   the page size
     * @param pageNumber the page number
     * @return the client response
     */
    @GetMapping
    public ClientResponse<BrandDto.ViewListBrand> viewBrandPage(@RequestParam(name = "pageSize") Integer pageSize,
                                                                @RequestParam(name = "pageNumber") Integer pageNumber) {
        return new ClientResponse<>(StatusCode.SUCCESS, brandService.viewBrandPage(pageNumber, pageSize));
    }
}
