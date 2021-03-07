package com.example.computerstorebackend.services.brand;

import com.example.computerstorebackend.aop.ApplicationException;
import com.example.computerstorebackend.dto.entities.BrandDto;
import com.example.computerstorebackend.entities.Brand;
import com.example.computerstorebackend.repositories.brand.BrandPaginationRepository;
import com.example.computerstorebackend.repositories.brand.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.example.computerstorebackend.enums.StatusCode.DUPLICATE_RECORD;
import static com.example.computerstorebackend.enums.StatusCode.RECORD_NOT_FOUND;

@Service
@AllArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandPaginationRepository brandPaginationRepository;

    public void addBrand(String key, String name) {
        brandRepository.findByKey(key)
                       .ifPresent(i -> {
                           throw new ApplicationException(DUPLICATE_RECORD, "duplicate in brand type {}", key);
                       });

        brandRepository.save(new Brand(key, name));

    }

    public BrandDto.ViewBrand viewBrand(String type) {
        return getBrand(type).view();
    }

    public BrandDto.ViewListBrand viewBrandPage(int pageNumber, int pageSize) {
        Page<Brand> all = brandPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new BrandDto.ViewListBrand(all.stream()
                                             .map(Brand::view)
                                             .collect(Collectors.toList()));
    }

    public Brand getBrand(String key) {
        return brandRepository.findByKey(key)
                              .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found hard disk type {}", key));
    }
}
