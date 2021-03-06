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

/**
 * The type Memory service.
 */
@Service
@AllArgsConstructor
public class MemoryService {
    private final MemoryRepository memoryRepository;
    private final MemoryTypeRepository memoryTypeRepository;
    private final MemoryPaginationService memoryPaginationService;

    /**
     * Add memory type.
     *
     * @param key the key
     */
    public void addMemoryType(String key) {
        memoryTypeRepository.findByKey(key)
                            .ifPresent(i -> {
                                throw new ApplicationException(DUPLICATE_RECORD, "duplicate in memory type {}", key);
                            });

        memoryTypeRepository.save(new MemoryType(key));

    }

    /**
     * View memory type memory dto . view memory type.
     *
     * @param type the type
     * @return the memory dto . view memory type
     */
    public MemoryDto.ViewMemoryType viewMemoryType(String type) {
        return getMemoryType(type).view();
    }

    /**
     * View memory type page memory dto . view list memory type.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the memory dto . view list memory type
     */
    public MemoryDto.ViewListMemoryType viewMemoryTypePage(int pageNumber, int pageSize) {
        return memoryPaginationService.viewMemoryTypePage(pageNumber, pageSize);
    }

    /**
     * Add memory.
     *
     * @param key    the key
     * @param amount the amount
     * @param type   the type
     */
    public void addMemory(String key, int amount, String type) {
        MemoryType memoryType = getMemoryType(type);
        memoryRepository.save(new Memory(key, amount, memoryType));

    }

    /**
     * View memory memory dto . view memory.
     *
     * @param key the key
     * @return the memory dto . view memory
     */
    public MemoryDto.ViewMemory viewMemory(String key) {
        return getMemory(key).view();
    }

    /**
     * View memory page memory dto . view lis memory.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the memory dto . view lis memory
     */
    public MemoryDto.ViewLisMemory viewMemoryPage(int pageNumber, int pageSize) {
        return memoryPaginationService.viewMemoryPage(pageNumber, pageSize);
    }

    /**
     * Gets memory type.
     *
     * @param type the type
     * @return the memory type
     */
    public MemoryType getMemoryType(String type) {
        return memoryTypeRepository.findByKey(type)
                                   .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found memory type {}", type));
    }

    /**
     * Gets memory.
     *
     * @param key the key
     * @return the memory
     */
    public Memory getMemory(String key) {
        return memoryRepository.findByKey(key)
                               .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found memory {}", key));
    }
}
