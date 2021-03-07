package com.example.computerstorebackend.entities.memory;

import com.example.computerstorebackend.entities.AuditMetadata;
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
@Table(name = "memory", uniqueConstraints = {@UniqueConstraint(columnNames = {"memory_amout", "memory_type_id"})})
public class Memory extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
    @GenericGenerator(name = "incrementDomain", strategy = "increment")
    private Integer id;

    @Getter
    @Column(name = "memory_amout", nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumn(name = "memory_type_id")
    private MemoryType memoryType;

    public Memory(int amount, MemoryType memoryType) {
        this.amount = amount;
        this.memoryType = memoryType;
        this.createdDate = new Date();
        log.debug("save new memory with amount {} and type {}", amount, memoryType.getKey());
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
