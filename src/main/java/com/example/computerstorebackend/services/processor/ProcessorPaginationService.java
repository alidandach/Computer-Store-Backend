package com.example.computerstorebackend.services.processor;

import com.example.computerstorebackend.dto.entities.ProcessorDto;
import com.example.computerstorebackend.entities.processor.ChipsetType;
import com.example.computerstorebackend.entities.processor.Processor;
import com.example.computerstorebackend.entities.processor.SocketType;
import com.example.computerstorebackend.repositories.processor.ChipsetTypePaginationRepository;
import com.example.computerstorebackend.repositories.processor.ProcessorPaginationRepository;
import com.example.computerstorebackend.repositories.processor.SocketTypePaginationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * The type Processor pagination service.
 */
@Service
@AllArgsConstructor
public class ProcessorPaginationService {
    private final ProcessorPaginationRepository processorPaginationRepository;
    private final SocketTypePaginationRepository socketTypePaginationRepository;
    private final ChipsetTypePaginationRepository chipsetTypePaginationRepository;

    /**
     * View chipset page processor dto . view list chipset type.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the processor dto . view list chipset type
     */
    public ProcessorDto.ViewListChipsetType viewChipsetPage(int pageNumber, int pageSize) {
        Page<ChipsetType> all = chipsetTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new ProcessorDto.ViewListChipsetType(all.stream()
                                                       .map(ChipsetType::view)
                                                       .collect(Collectors.toList()));
    }

    /**
     * View socket page processor dto . view list socket type.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the processor dto . view list socket type
     */
    public ProcessorDto.ViewListSocketType viewSocketPage(int pageNumber, int pageSize) {
        Page<SocketType> all = socketTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new ProcessorDto.ViewListSocketType(all.stream()
                                                      .map(SocketType::view)
                                                      .collect(Collectors.toList()));
    }

    /**
     * View processor page processor dto . view list processor.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the processor dto . view list processor
     */
    public ProcessorDto.ViewListProcessor viewProcessorPage(int pageNumber, int pageSize) {
        Page<Processor> all = processorPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new ProcessorDto.ViewListProcessor(all.stream()
                                                     .map(Processor::view)
                                                     .collect(Collectors.toList()));
    }
}
