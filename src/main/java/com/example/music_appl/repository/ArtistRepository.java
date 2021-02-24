package com.example.music_appl.repository;

import com.example.music_appl.model.entity.Artist;
import com.example.music_appl.model.entity.ArtistEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByArtist(ArtistEnum artist);
}
