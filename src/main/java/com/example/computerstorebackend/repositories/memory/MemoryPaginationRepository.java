package com.example.computerstorebackend.repositories.memory;

import com.example.computerstorebackend.entities.memory.Memory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Memory pagination repository.
 */
@Repository
public interface MemoryPaginationRepository extends PagingAndSortingRepository<Memory, Integer> {
}
