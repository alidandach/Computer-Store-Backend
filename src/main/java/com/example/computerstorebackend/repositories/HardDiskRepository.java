package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.harddisk.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Integer> {
}
