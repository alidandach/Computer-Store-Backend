package com.example.computerstorebackend.repositories.processor;

import com.example.computerstorebackend.entities.processor.SocketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocketTypeRepository extends JpaRepository<SocketType, Integer> {
    Optional<SocketType> findByKey(String key);
}
