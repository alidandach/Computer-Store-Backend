package com.example.computerstorebackend.services.memory;

import com.example.computerstorebackend.dto.entities.MemoryDto;
import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.memory.MemoryType;
import com.example.computerstorebackend.repositories.memory.MemoryPaginationRepository;
import com.example.computerstorebackend.repositories.memory.MemoryTypePaginationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemoryPaginationService {
    private final MemoryPaginationRepository memoryPaginationRepository;
    private final MemoryTypePaginationRepository memoryTypePaginationRepository;

    public MemoryDto.ViewListMemoryType viewMemoryTypePage(int pageNumber, int pageSize) {
        Page<MemoryType> all = memoryTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new MemoryDto.ViewListMemoryType(all.stream()
                                                   .map(MemoryType::view)
                                                   .collect(Collectors.toList()));
    }

    public MemoryDto.ViewLisMemory viewMemoryPage(int pageNumber, int pageSize) {
        Page<Memory> all = memoryPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("amount")));
        return new MemoryDto.ViewLisMemory(all.stream()
                                              .map(Memory::view)
                                              .collect(Collectors.toList()));
    }
}
