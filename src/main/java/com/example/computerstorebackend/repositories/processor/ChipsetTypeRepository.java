package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.ChipsetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Chipset type repository.
 */
@Repository
public interface ChipsetTypeRepository extends JpaRepository<ChipsetType, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<ChipsetType> findByKey(String key);
}
