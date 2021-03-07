package com.example.computerstorebackend.entities;

import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.processor.Processor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Entity
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
    @Column(name = "device_name", nullable = false)
    private String name;

    @Getter
    @Column(name = "model_number", nullable = false)
    private String modelNumber;

    @ManyToOne
    @JoinColumn(name = "processor_id")
    private Processor processor;

    @ManyToOne
    @JoinColumn(name = "memory_id")
    private Memory memory;

    @ManyToOne
    @JoinColumn(name = "hard_disk_id")
    private HardDisk hardDisk;

    @MapKey(name = "id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "computer")
    private Map<Integer, Picture> pictures;

    public Computer(ComputerBuilder computerBuilder) {
        this.name = computerBuilder.getName();
        this.modelNumber = computerBuilder.getModelNumber();
        this.processor = computerBuilder.getProcessor();
        this.memory = computerBuilder.getMemory();
        this.hardDisk = computerBuilder.getHardDisk();
        this.createdDate = new Date();
        pictures = new HashMap<>();
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ComputerBuilder {
        private String name;
        private String modelNumber;
        private Processor processor;
        private Memory memory;
        private HardDisk hardDisk;
    }
}
