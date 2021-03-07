package com.example.computerstorebackend.services.computer;

import com.example.computerstorebackend.aop.ApplicationException;
import com.example.computerstorebackend.dto.entities.ComputerDto;
import com.example.computerstorebackend.entities.Computer;
import com.example.computerstorebackend.entities.Picture;
import com.example.computerstorebackend.repositories.ComputerPaginationRepository;
import com.example.computerstorebackend.repositories.ComputerRepository;
import com.example.computerstorebackend.repositories.PictureRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static com.example.computerstorebackend.enums.StatusCode.DUPLICATE_RECORD;
import static com.example.computerstorebackend.enums.StatusCode.RECORD_NOT_FOUND;

@Service
@AllArgsConstructor
public class ComputerService {
    private final DeviceService deviceService;
    private final PictureRepository pictureRepository;
    private final ComputerRepository computerRepository;
    private final ComputerPaginationRepository computerPaginationRepository;

    public void addComputer(ComputerDto.AddComputer request) {
        computerRepository.findByKey(request.getKey())
                          .ifPresent(i -> {
                              throw new ApplicationException(DUPLICATE_RECORD, "duplicate in computer type {}", request.getKey());
                          });

        Computer computer = new Computer(ComputerDto.ComputerBuilder.builder()
                                                                    .key(request.getKey())
                                                                    .name(request.getName())
                                                                    .modelNumber(request.getModelNumber())
                                                                    .price(request.getPrice())
                                                                    .brand(deviceService.getBrand(request.getBrandKey()))
                                                                    .processor(deviceService.getProcessor(request.getProcessorKey()))
                                                                    .memory(deviceService.getMemory(request.getMemoryKey()))
                                                                    .hardDisk(deviceService.getHardDisk(request.getHardDiskKey()))
                                                                    .build());

        computerRepository.save(computer);

        for (ComputerDto.AddPicture picture : request.getPictures())
            pictureRepository.save(new Picture(picture.getName(), picture.getValue(), computer));
    }


    public ComputerDto.ViewComputer viewComputer(String key) {
        return getComputer(key).view();
    }

    public ComputerDto.ViewListComputer viewComputerPage(int pageNumber, int pageSize) {
        Page<Computer> diskTypePage = computerPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new ComputerDto.ViewListComputer(diskTypePage.stream()
                                                            .map(Computer::view)
                                                            .collect(Collectors.toList()));
    }

    public Computer getComputer(String key) {
        return computerRepository.findByKey(key)
                                 .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found computer {}", key));
    }

}