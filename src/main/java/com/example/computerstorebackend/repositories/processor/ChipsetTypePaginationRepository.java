package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.ChipsetType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Chipset type pagination repository.
 */
@Repository
public interface ChipsetTypePaginationRepository extends PagingAndSortingRepository<ChipsetType, Integer> {
}
