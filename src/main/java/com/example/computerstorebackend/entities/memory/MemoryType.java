package com.example.computerstorebackend.entities.memory;

import com.example.computerstorebackend.entities.AuditMetadata;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Entity
@NoArgsConstructor
@Table(name = "memory_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MemoryType extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "memory_type_key", unique = true, nullable = false)
    private String key;

    public MemoryType(String key) {
        this.key = key;
        this.createdDate = new Date();
        log.debug("save new memory type with key {}", key);
    }

    public void update(String key){
        log.debug("change memory type key from {} to {}", this.key, key);
        this.key = key;
        updatedDate = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemoryType)) return false;
        MemoryType that = (MemoryType) o;
        return Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }
}
