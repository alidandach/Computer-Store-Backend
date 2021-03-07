package com.example.computerstorebackend.repositories.brand;

import com.example.computerstorebackend.entities.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandPaginationRepository extends PagingAndSortingRepository<Brand, Integer> {
}
