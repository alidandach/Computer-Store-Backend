package com.example.computerstorebackend.repositories.memory;

import com.example.computerstorebackend.entities.memory.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemoryTypeRepository extends JpaRepository<MemoryType, Integer> {
    Optional<MemoryType> findByKey(String key);
}
