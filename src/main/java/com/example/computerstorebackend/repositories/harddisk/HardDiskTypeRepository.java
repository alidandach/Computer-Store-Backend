package com.example.computerstorebackend.repositories.harddisk;

import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Hard disk type repository.
 */
@Repository
public interface HardDiskTypeRepository extends JpaRepository<HardDiskType, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<HardDiskType> findByKey(String key);
}
