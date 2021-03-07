package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Computer repository.
 */
@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    /**
     * Find by key optional.
     *
     * @param key the key
     * @return the optional
     */
    Optional<Computer> findByKey(String key);
}
