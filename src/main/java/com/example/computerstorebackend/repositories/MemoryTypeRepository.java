package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.memory.MemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryTypeRepository extends JpaRepository<MemoryType, Integer> {
}
