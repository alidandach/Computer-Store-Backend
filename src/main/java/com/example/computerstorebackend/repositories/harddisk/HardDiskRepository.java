package com.example.computerstorebackend.repositories.harddisk;

import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Integer> {
    Optional<HardDisk> findByKey(String key);

    Optional<HardDisk> findByAmountAndHardDiskType(int amount, HardDiskType hardDiskType);
}
