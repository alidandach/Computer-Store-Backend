package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.SocketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Socket type repository.
 */
@Repository
public interface SocketTypeRepository extends JpaRepository<SocketType, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<SocketType> findByKey(String key);
}
