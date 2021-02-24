package com.example.music_appl.repository;

import com.example.music_appl.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("SELECT sum(a.copies) FROM Album a")
    Long findTotalCopies();
}
