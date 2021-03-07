package com.example.computerstorebackend.entities.harddisk;

import com.example.computerstorebackend.dto.entities.HardDiskDto;
import com.example.computerstorebackend.entities.AuditMetadata;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "hard_disk", uniqueConstraints = {@UniqueConstraint(columnNames = {"hard_disk_amout", "hard_disk_type_id"})})
public class HardDisk extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private Integer id;

    @Getter
    @Column(name = "key", unique = true, nullable = false)
    private String key;

    @Getter
    @Column(name = "hard_disk_amount", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "hard_disk_type_id")
    private HardDiskType hardDiskType;

    public HardDisk(String key,int amount, HardDiskType hardDiskType) {
        this.key = key;
        this.amount = amount;
        this.hardDiskType = hardDiskType;
        this.createdDate = new Date();
        log.debug("save new hard disk with amount {} and type {}", amount, hardDiskType.getKey());
    }

    public HardDiskDto.ViewHardDisk view() {
        return new HardDiskDto.ViewHardDisk().setAmount(amount)
                                             .setType(hardDiskType.getKey())
                                             .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                             .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
    }

    public String getType(){
        return hardDiskType.getKey();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardDisk)) return false;
        HardDisk hardDisk = (HardDisk) o;
        return getAmount() == hardDisk.getAmount() && hardDiskType.equals(hardDisk.hardDiskType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), hardDiskType);
    }
}