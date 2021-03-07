package com.example.computerstorebackend.entities.processor;

import com.example.computerstorebackend.dto.entities.ProcessorDto;
import com.example.computerstorebackend.entities.AuditMetadata;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@NoArgsConstructor
@Table(name = "processor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Processor extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "key", unique = true, nullable = false)
    private String key;

    @Getter
    @Column(name = "base_clock_speed", nullable = false)
    private int baseClockSpeed;

    @Getter
    @Column(name = "max_turbo_speed", nullable = false)
    private int maxTurboSpeed;

    @Getter
    @Column(name = "overclocking", nullable = false)
    private String overclocking;

    @Getter
    @Column(name = "core_count", nullable = false)
    private int coreCount;

    @Getter
    @Column(name = "thread_count", nullable = false)
    private int threadCount;

    @Getter
    @Column(name = "l1_cache_amount", nullable = false)
    private int l1CacheAmount;

    @Getter
    @Column(name = "l2_cache_amount", nullable = false)
    private int l2CacheAmount;

    @Getter
    @Column(name = "l3_cache_amount", nullable = false)
    private int l3CacheAmount;

    @Getter
    @Column(name = "memory_support", nullable = false)
    private String memorySupport;

    @Getter
    @Column(name = "number_of_channel", nullable = false)
    private int numberOfChannel;

    @Getter
    @Column(name = "thermal_design_power", nullable = false)
    private String thermalDesignPower;

    @Column(name = "fabrication_process", nullable = false)
    private String fabricationProcess;

    @ManyToOne
    @JoinColumn(name = "socket_type_id")
    private SocketType socketType;


    @ManyToOne
    @JoinColumn(name = "chipset_type_id")
    private ChipsetType chipsetType;

    @Getter
    @Column(name = "integrated_graphics", nullable = false)
    private boolean integratedGraphics;

    public Processor(ProcessorDto.AddProcessor dto, SocketType socketType, ChipsetType chipsetType) {
        this.key = dto.getKey();
        this.baseClockSpeed = dto.getBaseClockSpeed();
        this.maxTurboSpeed = dto.getMaxTurboSpeed();
        this.overclocking = dto.getOverclocking();
        this.coreCount = dto.getCoreCount();
        this.threadCount = dto.getThreadCount();
        this.l1CacheAmount = dto.getL1CacheAmount();
        this.l2CacheAmount = dto.getL2CacheAmount();
        this.l3CacheAmount = dto.getL3CacheAmount();
        this.memorySupport = dto.getMemorySupport();
        this.numberOfChannel = dto.getNumberOfChannel();
        this.thermalDesignPower = dto.getThermalDesignPower();
        this.fabricationProcess = dto.getFabricationProcess();
        this.socketType = socketType;
        this.chipsetType = chipsetType;
        this.integratedGraphics = dto.getIntegratedGraphics();
        this.createdDate = new Date();
    }

    public ProcessorDto.ViewProcessor view() {
        return new ProcessorDto.ViewProcessor().setBaseClockSpeed(baseClockSpeed)
                                               .setMaxTurboSpeed(maxTurboSpeed)
                                               .setOverclocking(overclocking)
                                               .setCoreCount(coreCount)
                                               .setThreadCount(threadCount)
                                               .setL1CacheAmount(l1CacheAmount)
                                               .setL2CacheAmount(l2CacheAmount)
                                               .setL3CacheAmount(l3CacheAmount)
                                               .setMemorySupport(memorySupport)
                                               .setNumberOfChannel(numberOfChannel)
                                               .setThermalDesignPower(thermalDesignPower)
                                               .setFabricationProcess(fabricationProcess)
                                               .setSocketType(socketType.getKey())
                                               .setChipsetType(chipsetType.getKey())
                                               .setIntegratedGraphics(integratedGraphics)
                                               .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                               .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
    }

    public String getSocketType() {
        return socketType.getKey();
    }

    public String getChipsetType() {
        return chipsetType.getKey();
    }
}