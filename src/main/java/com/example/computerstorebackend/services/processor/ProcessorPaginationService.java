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

@Service
@AllArgsConstructor
public class ProcessorPaginationService {
    private final ProcessorPaginationRepository processorPaginationRepository;
    private final SocketTypePaginationRepository socketTypePaginationRepository;
    private final ChipsetTypePaginationRepository chipsetTypePaginationRepository;

    public ProcessorDto.ViewListChipsetType viewChipsetPage(int pageNumber, int pageSize) {
        Page<ChipsetType> all = chipsetTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new ProcessorDto.ViewListChipsetType(all.stream()
                                                                .map(ChipsetType::view)
                                                                .collect(Collectors.toList()));
    }

    public ProcessorDto.ViewListSocketType viewSocketPage(int pageNumber, int pageSize) {
        Page<SocketType> all = socketTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("amount")));
        return new ProcessorDto.ViewListSocketType(all.stream()
                                                               .map(SocketType::view)
                                                               .collect(Collectors.toList()));
    }

    public ProcessorDto.ViewListProcessor viewProcessorPage(int pageNumber, int pageSize) {
        Page<Processor> all = processorPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("amount")));
        return new ProcessorDto.ViewListProcessor(all.stream()
                                                              .map(Processor::view)
                                                              .collect(Collectors.toList()));
    }
}
