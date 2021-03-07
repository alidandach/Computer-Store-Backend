package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.processor.SocketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketTypeRepository extends JpaRepository<SocketType, Integer> {
}
