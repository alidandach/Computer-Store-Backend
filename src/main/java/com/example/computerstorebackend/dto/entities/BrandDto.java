package com.example.computerstorebackend.dto.entities;

import com.example.computerstorebackend.annotations.StringValue;
import com.example.computerstorebackend.dto.ClientData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * The type Brand dto.
 */
public class BrandDto {
    /**
     * The type Add brand.
     */
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class AddBrand {
        @StringValue(isRequired = true)
        private String key;

        @StringValue(isRequired = true)
        private String name;
    }

    /**
     * The type View brand.
     */
    @Getter
    @Setter
    @Accessors(chain = true)
    public static class ViewBrand extends ClientData {
        private String key;
        private String createdDate;
        private String updatedDate;
    }

    /**
     * The type View list brand.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class ViewListBrand extends ClientData {
        private List<ViewBrand> types;
    }
}
