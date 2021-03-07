package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Processor repository.
 */
@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<Processor> findByKey(String key);
}
