package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.SocketType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Socket type pagination repository.
 */
@Repository
public interface SocketTypePaginationRepository extends PagingAndSortingRepository<SocketType, Integer> {
}
