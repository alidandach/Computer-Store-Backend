package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.Processor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Processor pagination repository.
 */
@Repository
public interface ProcessorPaginationRepository extends PagingAndSortingRepository<Processor, Integer> {
}
