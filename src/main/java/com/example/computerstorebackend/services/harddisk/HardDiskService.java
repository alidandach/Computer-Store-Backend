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

/**
 * The type Hard disk service.
 */
@Service
@AllArgsConstructor
public class HardDiskService {
    private final HardDiskRepository hardDiskRepository;
    private final HardDiskTypeRepository hardDiskTypeRepository;
    private final HardDiskPaginationService hardDiskPaginationService;


    /**
     * Add hard disk type.
     *
     * @param key the key
     */
    public void addHardDiskType(String key) {
        hardDiskTypeRepository.findByKey(key)
                              .ifPresent(user1 -> {
                                  throw new ApplicationException(DUPLICATE_RECORD, "duplicate in hard disk type {}", key);
                              });

        hardDiskTypeRepository.save(new HardDiskType(key));

    }

    /**
     * View hard disk type hard disk dto . view hard disk type.
     *
     * @param type the type
     * @return the hard disk dto . view hard disk type
     */
    public HardDiskDto.ViewHardDiskType viewHardDiskType(String type) {
        HardDiskType hardDiskType = getHardDiskType(type);
        return hardDiskType.view();
    }

    /**
     * View hard disk type page hard disk dto . view list hard disk type.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the hard disk dto . view list hard disk type
     */
    public HardDiskDto.ViewListHardDiskType viewHardDiskTypePage(int pageNumber, int pageSize) {
        return hardDiskPaginationService.viewHardDiskTypePage(pageNumber, pageSize);
    }

    /**
     * Add hard disk.
     *
     * @param key    the key
     * @param amount the amount
     * @param type   the type
     */
    public void addHardDisk(String key, int amount, String type) {
        HardDiskType hardDiskType = getHardDiskType(type);

        hardDiskRepository.save(new HardDisk(key, amount, hardDiskType));

    }

    /**
     * View hard disk hard disk dto . view hard disk.
     *
     * @param key the key
     * @return the hard disk dto . view hard disk
     */
    public HardDiskDto.ViewHardDisk viewHardDisk(String key) {
        return getHardDisk(key).view();
    }

    /**
     * View hard disk page hard disk dto . view lis hard disk.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the hard disk dto . view lis hard disk
     */
    public HardDiskDto.ViewLisHardDisk viewHardDiskPage(int pageNumber, int pageSize) {
        return hardDiskPaginationService.viewHardDiskPage(pageNumber, pageSize);
    }

    /**
     * Gets hard disk type.
     *
     * @param type the type
     * @return the hard disk type
     */
    public HardDiskType getHardDiskType(String type) {
        return hardDiskTypeRepository.findByKey(type)
                                     .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found hard disk type {}", type));
    }

    /**
     * Gets hard disk.
     *
     * @param key the key
     * @return the hard disk
     */
    public HardDisk getHardDisk(String key) {
        return hardDiskRepository.findByKey(key)
                                 .orElseThrow(() -> new ApplicationException(RECORD_NOT_FOUND, "not found hard disk {}", key));
    }
}
