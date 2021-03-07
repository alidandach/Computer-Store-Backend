package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.processor.ChipsetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChipsetTypeRepository extends JpaRepository<ChipsetType, Integer> {
}
