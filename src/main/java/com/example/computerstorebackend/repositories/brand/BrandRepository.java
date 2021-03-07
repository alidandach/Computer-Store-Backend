package com.example.computerstorebackend.repositories.brand;

import com.example.computerstorebackend.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Brand repository.
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<Brand> findByKey(String key);
}
