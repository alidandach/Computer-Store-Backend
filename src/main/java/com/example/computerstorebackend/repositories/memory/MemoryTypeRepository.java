package com.example.computerstorebackend.repositories.memory;

import com.example.computerstorebackend.entities.memory.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Memory type repository.
 */
@Repository
public interface MemoryTypeRepository extends JpaRepository<MemoryType, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<MemoryType> findByKey(String key);
}
