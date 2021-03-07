package com.example.computerstorebackend.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class AuditMetadata {
    @Column(name = "created_date", nullable = false)
    protected Date createdDate;

    @Column(name = "updated_date")
    protected Date updatedDate;
}