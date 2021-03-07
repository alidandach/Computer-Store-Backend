package com.example.computerstorebackend.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * The type Audit metadata.
 */
@MappedSuperclass
public class AuditMetadata {
    /**
     * The Created date.
     */
    @Column(name = "created_date", nullable = false)
    protected Date createdDate;

    /**
     * The Updated date.
     */
    @Column(name = "updated_date")
    protected Date updatedDate;
}