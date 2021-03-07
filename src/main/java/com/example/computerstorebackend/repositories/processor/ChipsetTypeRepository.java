package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.ChipsetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChipsetTypeRepository extends JpaRepository<ChipsetType, Integer> {
    Optional<ChipsetType> findByKey(String key);
}
