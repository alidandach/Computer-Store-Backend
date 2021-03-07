package com.example.computerstorebackend.entities.processor;

import com.example.computerstorebackend.dto.entities.ProcessorDto;
import com.example.computerstorebackend.entities.AuditMetadata;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Entity
@NoArgsConstructor
@Table(name = "socket_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SocketType extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "socket_type_key", unique = true, nullable = false)
    private String key;

    public SocketType(String key) {
        this.key = key;
        this.createdDate = new Date();
        log.debug("save new socket type {}", key);
    }

    public ProcessorDto.ViewSocketType view() {
        return new ProcessorDto.ViewSocketType().setKey(key)
                                                .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                                .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SocketType)) return false;
        SocketType that = (SocketType) o;
        return getKey().equals(that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey());
    }
}
