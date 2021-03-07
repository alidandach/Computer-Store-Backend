package com.example.computerstorebackend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Slf4j
@Entity
@NoArgsConstructor
@Table(name = "picture")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Picture extends AuditMetadata {
    @Id
    @Getter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "picture_name", nullable = false)
    private String name;

    @Getter
    @Column(name = "picture_value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;

    public Picture(String name, String value, Computer computer) {
        this.name = name;
        this.value = value;
        this.createdDate = new Date();
        this.computer = computer;
        log.debug("save new picture with name {}", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Picture)) return false;
        Picture picture = (Picture) o;
        return getName().equals(picture.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
