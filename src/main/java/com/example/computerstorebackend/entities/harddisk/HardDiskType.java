package com.example.computerstorebackend.entities.harddisk;

import com.example.computerstorebackend.dto.entities.HardDiskDto;
import com.example.computerstorebackend.entities.AuditMetadata;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The type Hard disk type.
 */
@Slf4j
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "hard_disk_type")
public class HardDiskType extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "hard_disk_key", unique = true, nullable = false)
    private String key;

    /**
     * Instantiates a new Hard disk type.
     *
     * @param key the key
     */
    public HardDiskType(String key) {
        this.key = key;
        this.createdDate = new Date();
        log.debug("save new hard disk type with key {}", key);
    }

    /**
     * View hard disk dto . view hard disk type.
     *
     * @return the hard disk dto . view hard disk type
     */
    public HardDiskDto.ViewHardDiskType view() {
        return new HardDiskDto.ViewHardDiskType().setKey(key)
                                                 .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                                 .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
    }

    /**
     * Update.
     *
     * @param key the key
     */
    public void update(String key) {
        log.debug("change hard disk type key from {} to {}", this.key, key);
        this.key = key;
        updatedDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardDiskType)) return false;
        HardDiskType that = (HardDiskType) o;
        return getKey().equals(that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }
}
