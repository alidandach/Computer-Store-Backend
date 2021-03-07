package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Integer> {
    Optional<Processor> findByKey(String key);
}
