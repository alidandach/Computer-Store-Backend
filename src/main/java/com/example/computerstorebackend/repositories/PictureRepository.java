package com.example.computerstorebackend.repositories;

import com.example.computerstorebackend.entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Picture repository.
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
