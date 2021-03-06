package com.example.computerstorebackend.entities;

import com.example.computerstorebackend.dto.entities.ComputerDto;
import com.example.computerstorebackend.utilities.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The type Picture.
 */
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

    /**
     * Instantiates a new Picture.
     *
     * @param name     the name
     * @param value    the value
     * @param computer the computer
     */
    public Picture(String name, String value, Computer computer) {
        this.name = name;
        this.value = value;
        this.createdDate = new Date();
        this.computer = computer;
        log.debug("save new picture with name {}", name);
    }

    /**
     * View computer dto . view picture.
     *
     * @return the computer dto . view picture
     */
    public ComputerDto.ViewPicture view() {
        return new ComputerDto.ViewPicture().setName(name)
                                            .setValue(value)
                                            .setCreatedDate(DateUtil.formatDate(createdDate, "dd-MM-yyyy"))
                                            .setUpdatedDate(updatedDate != null ? DateUtil.formatDate(updatedDate, "dd-MM-yyyy") : null);
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
