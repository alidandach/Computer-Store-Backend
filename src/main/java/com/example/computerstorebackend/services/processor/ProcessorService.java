package com.example.computerstorebackend.services.processor;

import com.example.computerstorebackend.aop.ApplicationException;
import com.example.computerstorebackend.dto.entities.ProcessorDto;
import com.example.computerstorebackend.entities.processor.ChipsetType;
import com.example.computerstorebackend.entities.processor.Processor;
import com.example.computerstorebackend.entities.processor.SocketType;
import com.example.computerstorebackend.repositories.processor.ChipsetTypeRepository;
import com.example.computerstorebackend.repositories.processor.ProcessorRepository;
import com.example.computerstorebackend.repositories.processor.SocketTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.computerstorebackend.enums.StatusCode.DUPLICATE_RECORD;
import static com.example.computerstorebackend.enums.StatusCode.RECORD_NOT_FOUND;

@Service
@AllArgsConstructor
public class ProcessorService {
    private final ProcessorRepository processorRepository;
    private final SocketTypeRepository socketTypeRepository;
    private final ChipsetTypeRepository chipsetTypeRepository;
    private final ProcessorPaginationService processorPaginationService;

    public void addChipsetType(String key) {
        chipsetTypeRepository.findByKey(key)
                             .ifPresent(i -> {
                                 throw new ApplicationException(DUPLICATE_RECORD, "duplicate in chipset type {}", key);
                             });

        chipsetTypeRepository.save(new ChipsetType(key));

    }

    public ProcessorDto.ViewChipsetType viewChipsetType(String type) {
        ChipsetType chipsetType = getChipsetType(type);
        return chipsetType.view();
    }

    public ProcessorDto.ViewListChipsetType viewChipsetTypePage(int pageNumber, int pageSize) {
        return processorPaginationService.viewChipsetPage(pageNumber, pageSize);
    }

    public void addSocketType(String key) {
        socketTypeRepository.findByKey(key)
                            .ifPresent(user1 -> {
                                throw new ApplicationException(DUPLICATE_RECORD, "duplicate in socket type {}", key);
                            });

        socketTypeRepository.save(new SocketType(key));

    }

    public ProcessorDto.ViewSocketType viewSocketType(String type) {
        SocketType socketType = getSocketType(type);
        return socketType.view();
    }

    public ProcessorDto.ViewListSocketType viewSocketPage(int pageNumber, int pageSize) {
        return processorPaginationService.viewSocketPage(pageNumber, pageSize);
    }

    public void addProcessor(ProcessorDto.AddProcessor addProcessor) {
        SocketType socketType = getSocketType(addProcessor.getSocketType());

        ChipsetType chipsetType = getChipsetType(addProcessor.getChipsetType());

        processorRepository.save(new Processor(addProcessor, socketType, chipsetType));
    }

    public ProcessorDto.ViewProcessor viewProcessor(String key) {
        return getProcessor(key).view();
    }

    public ProcessorDto.ViewListProcessor viewProcessorPage(int pageNumber, int pageSize) {
        return processorPaginationService.viewProcessorPage(pageNumber, pageSize);
    }

    public ChipsetType getChipsetType(String type) {
        return chipsetTypeRepository.findByKey(type)
                                    .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found chipset type {}", type));
    }

    public SocketType getSocketType(String type) {
        return socketTypeRepository.findByKey(type)
                                   .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found chipset type {}", type));
    }

    public Processor getProcessor(String type) {
        return processorRepository.findByKey(type)
                                  .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found processor type {}", type));
    }
}
