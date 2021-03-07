package com.example.computerstorebackend.dto;

import lombok.Getter;
import lombok.Setter;

public class ProcessorDto {

    @Getter
    @Setter
    public static class AddProcessor {
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
    }
}
