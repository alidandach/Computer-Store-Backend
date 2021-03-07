package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.memory.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Integer> {
}
