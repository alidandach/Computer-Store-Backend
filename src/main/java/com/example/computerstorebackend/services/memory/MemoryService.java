package com.example.computerstorebackend.services.memory;

import com.example.computerstorebackend.aop.ApplicationException;
import com.example.computerstorebackend.dto.entities.MemoryDto;
import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.memory.MemoryType;
import com.example.computerstorebackend.repositories.memory.MemoryRepository;
import com.example.computerstorebackend.repositories.memory.MemoryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.computerstorebackend.enums.StatusCode.DUPLICATE_RECORD;
import static com.example.computerstorebackend.enums.StatusCode.RECORD_NOT_FOUND;

@Service
@AllArgsConstructor
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final MemoryTypeRepository memoryTypeRepository;
    private final MemoryPaginationService memoryPaginationService;

    public void addMemoryType(String key) {
        memoryTypeRepository.findByKey(key)
                            .ifPresent(i -> {
                                throw new ApplicationException(DUPLICATE_RECORD, "duplicate in memory type {}", key);
                            });

        memoryTypeRepository.save(new MemoryType(key));

    }

    public MemoryDto.ViewMemoryType viewMemoryType(String type) {
        return getMemoryType(type).view();
    }

    public MemoryDto.ViewListMemoryType viewMemoryTypePage(int pageNumber, int pageSize) {
        return memoryPaginationService.viewMemoryTypePage(pageNumber, pageSize);
    }

    public void addMemory(String key, int amount, String type) {
        MemoryType memoryType = getMemoryType(type);
        memoryRepository.save(new Memory(key, amount, memoryType));

    }

    public MemoryDto.ViewMemory viewMemory(int amount, String type) {
        MemoryType memoryType = getMemoryType(type);

        return memoryRepository.findByAmountAndMemoryType(amount, memoryType)
                               .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found memory with type {}", type))
                               .view();
    }

    public MemoryDto.ViewLisMemory viewMemoryPage(int pageNumber, int pageSize) {
        return memoryPaginationService.viewMemoryPage(pageNumber, pageSize);
    }

    public MemoryType getMemoryType(String type) {
        return memoryTypeRepository.findByKey(type)
                                   .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found memory type {}", type));
    }

    public Memory getMemory(String key) {
        return memoryRepository.findByKey(key)
                               .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found memory {}", key));
    }
}
