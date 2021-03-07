package com.example.computerstorebackend.repositories.memory;

import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.memory.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Memory repository.
 */
@Repository
public interface MemoryRepository extends JpaRepository<Memory, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<Memory> findByKey(String key);

    /**
     * Find by amount and memory type optional.
     *
     * @param amount     the amount
     * @param memoryType the memory type
     * @return the optional
     */
    Optional<Memory> findByAmountAndMemoryType(int amount, MemoryType memoryType);
}