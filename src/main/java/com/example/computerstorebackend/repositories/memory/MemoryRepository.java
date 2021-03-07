package com.example.computerstorebackend.repositories.memory;

import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.memory.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Integer> {
    Optional<Memory> findByKey(String key);

    Optional<Memory> findByAmountAndMemoryType(int amount, MemoryType memoryType);
}