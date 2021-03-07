package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.Computer;
import com.example.computerstorebackend.entities.memory.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    Optional<Computer> findByKey(String key);
}
