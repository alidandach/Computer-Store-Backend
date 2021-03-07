package com.example.computerstorebackend.repositories.harddisk;

import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardDiskTypeRepository extends JpaRepository<HardDiskType, Integer> {
    Optional<HardDiskType> findByKey(String key);
}