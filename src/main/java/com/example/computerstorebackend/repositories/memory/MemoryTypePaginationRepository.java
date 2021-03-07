package com.example.computerstorebackend.repositories.memory;

import com.example.computerstorebackend.entities.memory.MemoryType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryTypePaginationRepository extends PagingAndSortingRepository<MemoryType, Integer> {
}
