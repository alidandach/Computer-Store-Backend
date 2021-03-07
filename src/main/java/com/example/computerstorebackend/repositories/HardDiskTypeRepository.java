package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskTypeRepository extends JpaRepository<HardDiskType, Integer> {
}
