package com.example.computerstorebackend.repositories.harddisk;

import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Hard disk type pagination repository.
 */
@Repository
public interface HardDiskTypePaginationRepository extends PagingAndSortingRepository<HardDiskType, Integer> {
}
