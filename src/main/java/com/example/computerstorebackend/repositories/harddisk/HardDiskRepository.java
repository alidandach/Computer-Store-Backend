package com.example.computerstorebackend.repositories.harddisk;

import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Hard disk repository.
 */
@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<HardDisk> findByKey(String key);

    /**
     * Find by amount and hard disk type optional.
     *
     * @param amount       the amount
     * @param hardDiskType the hard disk type
     * @return the optional
     */
    Optional<HardDisk> findByAmountAndHardDiskType(int amount, HardDiskType hardDiskType);
}
