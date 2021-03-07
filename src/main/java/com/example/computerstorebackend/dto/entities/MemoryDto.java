package com.example.computerstorebackend.dto.entities;

import com.example.computerstorebackend.annotations.IntegerValue;
import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

public class MemoryDto {
    @Getter
    @Setter
    public static class AddMemoryType {
        @StringValue(isRequired = true)
        private String key;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewMemoryType extends ClientData {
        private String key;
        private String createdDate;
        private String updatedDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewListMemoryType extends ClientData {
        private List<MemoryDto.ViewMemoryType> types;
    }


    @Getter
    @Setter
    public static class AddMemory {
        @StringValue(isRequired = true)
        private String key;

        @IntegerValue(isRequired = true)
        private Integer amount;

        @StringValue(isRequired = true)
        private String type;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewMemory extends ClientData{
        private int amount;
        private String type;
        private String createdDate;
        private String updatedDate;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewLisMemory extends ClientData {
        private List<MemoryDto.ViewMemory> hardDisks;
    }
}
