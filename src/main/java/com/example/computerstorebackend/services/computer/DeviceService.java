package com.example.computerstorebackend.services.computer;

import com.example.computerstorebackend.entities.Brand;
import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.processor.Processor;
import com.example.computerstorebackend.services.brand.BrandService;
import com.example.computerstorebackend.services.harddisk.HardDiskService;
import com.example.computerstorebackend.services.memory.MemoryService;
import com.example.computerstorebackend.services.processor.ProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceService {
    private final BrandService brandService;
    private final MemoryService memoryService;
    private final HardDiskService hardDiskService;
    private final ProcessorService processorService;

    @Cacheable(value = "processor", key = "{#key}")
    public Brand getBrand(String key) {
        return brandService.getBrand(key);
    }

    @Cacheable(value = "processor", key = "{#key}")
    public Processor getProcessor(String key) {
        return processorService.getProcessor(key);
    }

    @Cacheable(value = "memory", key = "{#key}")
    public Memory getMemory(String key) {
        return memoryService.getMemory(key);
    }

    @Cacheable(value = "hardDisk", key = "{#key}")
    public HardDisk getHardDisk(String key) {
        return hardDiskService.getHardDisk(key);
    }
}
