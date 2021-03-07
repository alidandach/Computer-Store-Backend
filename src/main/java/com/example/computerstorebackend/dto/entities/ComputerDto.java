package com.example.computerstorebackend.dto.entities;

import com.example.computerstorebackend.annotations.DoubleValue;
import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import com.example.computerstorebackend.entities.Brand;
import com.example.computerstorebackend.entities.harddisk.HardDisk;
import com.example.computerstorebackend.entities.memory.Memory;
import com.example.computerstorebackend.entities.processor.Processor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import java.util.List;

public class ComputerDto {
    @Getter
    @Setter
    public static class AddComputer {
        @StringValue(isRequired = true)
        private String key;

        @StringValue(isRequired = true)
        private String name;

        @StringValue(isRequired = true)
        private String modelNumber;

        @StringValue(isRequired = true)
        private String brandKey;

        @StringValue(isRequired = true)
        private String processorKey;

        @StringValue(isRequired = true)
        private String memoryKey;

        @StringValue(isRequired = true)
        private String hardDiskKey;

        @DoubleValue(isRequired = true)
        private Double price;

        @Valid
        private List<AddPicture> pictures;
    }

    @Getter
    @Setter
    public static class AddPicture {
        @StringValue(isRequired = true)
        private String name;

        @StringValue(isRequired = true)
        private String value;
    }

    @Getter
    @Builder
    public static class ComputerBuilder {
        private final String key;
        private final String name;
        private final String modelNumber;
        private final double price;
        private final Brand brand;
        private final Processor processor;
        private final Memory memory;
        private final HardDisk hardDisk;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewComputer extends ClientData {
        private String key;
        private String name;
        private String modelNumber;
        private String brand;
        private String processorKey;
        private int processorCore;
        private int processorThread;
        private String socketType;
        private String chipsetType;
        private int memoryAmount;
        private String memoryType;
        private int hardDiskAmount;
        private String hardDiskType;
        private double price;
        private String createdDate;
        private String updatedDate;
        private List<ViewPicture> pictures;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewPicture {
        private String name;
        private String value;
        private String createdDate;
        private String updatedDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ViewListComputer extends ClientData {
        private List<ViewComputer> computers;
    }
}
