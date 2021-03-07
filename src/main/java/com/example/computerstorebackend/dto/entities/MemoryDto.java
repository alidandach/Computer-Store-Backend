package com.example.computerstorebackend.dto.entities;

import com.example.computerstorebackend.annotations.IntegerValue;
import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * The type Memory dto.
 */
public class MemoryDto {
    /**
     * The type Add memory type.
     */
    @Getter
    @Setter
    public static class AddMemoryType {
        @StringValue(isRequired = true)
        private String key;
    }

    /**
     * The type View memory type.
     */
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewMemoryType extends ClientData {
        private String key;
        private String createdDate;
        private String updatedDate;
    }

    /**
     * The type View list memory type.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewListMemoryType extends ClientData {
        private List<MemoryDto.ViewMemoryType> types;
    }


    /**
     * The type Add memory.
     */
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

    /**
     * The type View memory.
     */
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewMemory extends ClientData {
        private int amount;
        private String type;
        private String createdDate;
        private String updatedDate;
    }

    /**
     * The type View lis memory.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewLisMemory extends ClientData {
        private List<MemoryDto.ViewMemory> hardDisks;
    }
}
