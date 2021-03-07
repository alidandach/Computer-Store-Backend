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

/**
 * The type Memory pagination service.
 */
@Service
@AllArgsConstructor
public class MemoryPaginationService {
    private final MemoryPaginationRepository memoryPaginationRepository;
    private final MemoryTypePaginationRepository memoryTypePaginationRepository;

    /**
     * View memory type page memory dto . view list memory type.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the memory dto . view list memory type
     */
    public MemoryDto.ViewListMemoryType viewMemoryTypePage(int pageNumber, int pageSize) {
        Page<MemoryType> all = memoryTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new MemoryDto.ViewListMemoryType(all.stream()
                                                   .map(MemoryType::view)
                                                   .collect(Collectors.toList()));
    }

    /**
     * View memory page memory dto . view lis memory.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the memory dto . view lis memory
     */
    public MemoryDto.ViewLisMemory viewMemoryPage(int pageNumber, int pageSize) {
        Page<Memory> all = memoryPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("amount")));
        return new MemoryDto.ViewLisMemory(all.stream()
                                              .map(Memory::view)
                                              .collect(Collectors.toList()));
    }
}
