package com.example.computerstorebackend.entities;

import com.example.computerstorebackend.dto.entities.BrandDto;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Slf4j
@Entity
@NoArgsConstructor
@Table(name = "brand")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Brand extends AuditMetadata{
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "brand_key", unique = true, nullable = false)
    private String key;

    @Getter
    @Column(name = "brand_name", nullable = false)
    private String name;

    public Brand(String key, String name) {
        this.key = key;
        this.name = name;
        this.createdDate = new Date();
        log.debug("save new brand with key {} and name {}", key, name);
    }

    public BrandDto.ViewBrand view (){
        return new BrandDto.ViewBrand().setKey(key)
                                       .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                       .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
    }

    public void update(String key, String name) {
        if (key != null)
            setKey(key);
        if (name != null)
            setName(name);
    }

    private void setKey(String key) {
        log.debug("change brand key from {} to {}", this.key, key);
        this.key = key;
        this.updatedDate = new Date();
    }

    private void setName(String name) {
        log.debug("change brand name from {} to {}", this.name, name);
        this.name = name;
        this.updatedDate = new Date();
    }
}
