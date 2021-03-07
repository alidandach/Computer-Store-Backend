package com.example.computerstorebackend.services.harddisk;

import com.example.computerstorebackend.dto.entities.HardDiskDto;
import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.harddisk.HardDiskType;
import com.example.computerstorebackend.repositories.harddisk.HardDiskPaginationRepository;
import com.example.computerstorebackend.repositories.harddisk.HardDiskTypePaginationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * The type Hard disk pagination service.
 */
@Service
@AllArgsConstructor
public class HardDiskPaginationService {
    private final HardDiskPaginationRepository hardDiskPaginationRepository;
    private final HardDiskTypePaginationRepository hardDiskTypePaginationRepository;

    /**
     * View hard disk type page hard disk dto . view list hard disk type.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the hard disk dto . view list hard disk type
     */
    public HardDiskDto.ViewListHardDiskType viewHardDiskTypePage(int pageNumber, int pageSize) {
        Page<HardDiskType> diskTypePage = hardDiskTypePaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("key")));
        return new HardDiskDto.ViewListHardDiskType(diskTypePage.stream()
                                                                .map(HardDiskType::view)
                                                                .collect(Collectors.toList()));
    }

    /**
     * View hard disk page hard disk dto . view lis hard disk.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the hard disk dto . view lis hard disk
     */
    public HardDiskDto.ViewLisHardDisk viewHardDiskPage(int pageNumber, int pageSize) {
        Page<HardDisk> diskTypePage = hardDiskPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("amount")));
        return new HardDiskDto.ViewLisHardDisk(diskTypePage.stream()
                                                           .map(HardDisk::view)
                                                           .collect(Collectors.toList()));
    }
}
