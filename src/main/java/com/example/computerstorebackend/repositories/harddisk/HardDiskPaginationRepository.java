package com.example.computerstorebackend.repositories.harddisk;

import com.example.computerstorebackend.entities.harddisk.HardDisk;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Hard disk pagination repository.
 */
@Repository
public interface HardDiskPaginationRepository extends PagingAndSortingRepository<HardDisk, Integer> {
}
