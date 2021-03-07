package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.Computer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerPaginationRepository extends PagingAndSortingRepository<Computer, Integer> {
}
