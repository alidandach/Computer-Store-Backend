package com.example.computerstorebackend.entities.memory;

import com.example.computerstorebackend.dto.entities.MemoryDto;
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
@Table(name = "memory", uniqueConstraints = {@UniqueConstraint(columnNames = {"memory_amount", "memory_type_id"})})
public class Memory extends AuditMetadata {
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
    @Column(name = "memory_amount", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "memory_type_id")
    private MemoryType memoryType;

    public Memory(String key, int amount, MemoryType memoryType) {
        this.key = key;
        this.amount = amount;
        this.memoryType = memoryType;
        this.createdDate = new Date();
        log.debug("save new memory with amount {} and type {}", amount, memoryType.getKey());
    }

    public MemoryDto.ViewMemory view() {
        return new MemoryDto.ViewMemory().setAmount(amount)
                                         .setType(memoryType.getKey())
                                         .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                         .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
    }

    public String getType() {
        return memoryType.getKey();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memory)) return false;
        Memory memory = (Memory) o;
        return getAmount() == memory.getAmount() && memoryType.equals(memory.memoryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), memoryType);
    }
}
