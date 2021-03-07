package com.example.computerstorebackend.services.harddisk;

import com.example.computerstorebackend.aop.ApplicationException;
import com.example.computerstorebackend.dto.entities.HardDiskDto;
import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import com.example.computerstorebackend.repositories.harddisk.HardDiskRepository;
import com.example.computerstorebackend.repositories.harddisk.HardDiskTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.computerstorebackend.enums.StatusCode.DUPLICATE_RECORD;
import static com.example.computerstorebackend.enums.StatusCode.RECORD_NOT_FOUND;

@Service
@AllArgsConstructor
public class HardDiskService {
    private final HardDiskRepository hardDiskRepository;
    private final HardDiskTypeRepository hardDiskTypeRepository;
    private final HardDiskPaginationService hardDiskPaginationService;


    public void addHardDiskType(String key) {
        hardDiskTypeRepository.findByKey(key)
                              .ifPresent(user1 -> {
                                  throw new ApplicationException(DUPLICATE_RECORD, "duplicate in hard disk type {}", key);
                              });

        hardDiskTypeRepository.save(new HardDiskType(key));

    }

    public HardDiskDto.ViewHardDiskType viewHardDiskType(String type) {
        HardDiskType hardDiskType = getHardDiskType(type);
        return hardDiskType.view();
    }

    public HardDiskDto.ViewListHardDiskType viewHardDiskTypePage(int pageNumber, int pageSize) {
        return hardDiskPaginationService.viewHardDiskTypePage(pageNumber, pageSize);
    }

    public void addHardDisk(String key, int amount, String type) {
        HardDiskType hardDiskType = getHardDiskType(type);

        hardDiskRepository.save(new HardDisk(key, amount, hardDiskType));

    }

    public HardDiskDto.ViewHardDisk viewHardDisk(int amount, String type) {
        HardDiskType hardDiskType = getHardDiskType(type);

        HardDisk hardDisk = hardDiskRepository.findByAmountAndHardDiskType(amount, hardDiskType)
                                              .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found hard disk with type {}", type));

        return hardDisk.view();
    }

    public HardDiskDto.ViewLisHardDisk viewHardDiskPage(int pageNumber, int pageSize) {
        return hardDiskPaginationService.viewHardDiskPage(pageNumber, pageSize);
    }

    public HardDiskType getHardDiskType(String type) {
        return hardDiskTypeRepository.findByKey(type)
                                     .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found hard disk type {}", type));
    }

    public HardDisk getHardDisk(String key) {
        return hardDiskRepository.findByKey(key)
                                     .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found hard disk {}", key));
    }
}
