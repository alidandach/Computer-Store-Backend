package com.example.computerstorebackend.entities;

import com.example.computerstorebackend.dto.entities.ComputerDto;
import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.processor.Processor;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Entity
@NoArgsConstructor
@Table(name = "computer")
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Computer extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "key", unique = true, nullable = false)
    private String key;

    @Getter
    @Column(name = "device_name", nullable = false)
    private String name;

    @Getter
    @Column(name = "model_number", nullable = false)
    private String modelNumber;

    @Getter
    @Column(name = "computer_price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "processor_id", nullable = false)
    private Processor processor;

    @ManyToOne
    @JoinColumn(name = "memory_id", nullable = false)
    private Memory memory;

    @ManyToOne
    @JoinColumn(name = "hard_disk_id", nullable = false)
    private HardDisk hardDisk;

    @MapKey(name = "id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "computer")
    private Map<Integer, Picture> pictures;

    public Computer(ComputerDto.ComputerBuilder computerBuilder) {
        this.key = computerBuilder.getKey();
        this.name = computerBuilder.getName();
        this.modelNumber = computerBuilder.getModelNumber();
        this.price = computerBuilder.getPrice();
        this.brand = computerBuilder.getBrand();
        this.processor = computerBuilder.getProcessor();
        this.memory = computerBuilder.getMemory();
        this.hardDisk = computerBuilder.getHardDisk();
        this.createdDate = new Date();
        pictures = new HashMap<>();
    }

    public ComputerDto.ViewComputer view() {
        return new ComputerDto.ViewComputer().setKey(key)
                                             .setName(name)
                                             .setModelNumber(modelNumber)
                                             .setBrand(brand.getName())
                                             .setProcessorKey(processor.getKey())
                                             .setProcessorCore(processor.getCoreCount())
                                             .setProcessorThread(processor.getThreadCount())
                                             .setSocketType(processor.getSocketType())
                                             .setChipsetType(processor.getChipsetType())
                                             .setMemoryAmount(memory.getAmount())
                                             .setMemoryType(memory.getType())
                                             .setHardDiskAmount(hardDisk.getAmount())
                                             .setHardDiskType(hardDisk.getType())
                                             .setPrice(price)
                                             .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                             .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null)
                                             .setPictures(pictures.values()
                                                                  .stream()
                                                                  .map(Picture::view)
                                                                  .collect(Collectors.toList()));
    }
}
