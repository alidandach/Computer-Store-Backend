package com.example.computerstorebackend.dto.entities;

import com.example.computerstorebackend.annotations.BooleanValue;
import com.example.computerstorebackend.annotations.IntegerValue;
import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

public class ProcessorDto {
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class AddChipsetType {
        @StringValue(isRequired = true)
        private String key;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewChipsetType extends ClientData {
        private String key;
        private String createdDate;
        private String updatedDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewListChipsetType extends ClientData {
        private List<ViewChipsetType> types;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class AddSocketType {
        @StringValue(isRequired = true)
        private String key;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewSocketType extends ClientData {
        private String key;
        private String createdDate;
        private String updatedDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewListSocketType extends ClientData {
        private List<ViewSocketType> types;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class AddProcessor {
        @StringValue(isRequired = true)
        private String key;

        @IntegerValue(isRequired = true)
        private Integer baseClockSpeed;

        @IntegerValue(isRequired = true)
        private Integer maxTurboSpeed;

        @StringValue(isRequired = true)
        private String overclocking;

        @IntegerValue(isRequired = true)
        private Integer coreCount;

        @IntegerValue(isRequired = true)
        private Integer threadCount;

        @IntegerValue(isRequired = true)
        private Integer l1CacheAmount;

        @IntegerValue(isRequired = true)
        private Integer l2CacheAmount;

        @IntegerValue(isRequired = true)
        private Integer l3CacheAmount;

        @StringValue(isRequired = true)
        private String memorySupport;

        private Integer numberOfChannel;

        @StringValue(isRequired = true)
        private String thermalDesignPower;

        @StringValue(isRequired = true)
        private String fabricationProcess;

        @StringValue(isRequired = true)
        private String socketType;

        @StringValue(isRequired = true)
        private String chipsetType;

        @BooleanValue(isRequired = true)
        private Boolean integratedGraphics;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewProcessor extends ClientData {
        private int baseClockSpeed;

        private int maxTurboSpeed;

        private String overclocking;

        private int coreCount;

        private int threadCount;

        private int l1CacheAmount;

        private int l2CacheAmount;

        private int l3CacheAmount;

        private String memorySupport;

        private int numberOfChannel;

        private String thermalDesignPower;

        private String fabricationProcess;

        private String socketType;

        private String chipsetType;

        private boolean integratedGraphics;

        private String createdDate;

        private String updatedDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewListProcessor extends ClientData {
        private List<ViewProcessor> types;
    }
}
