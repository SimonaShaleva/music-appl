package com.example.music_appl.service;

import com.example.music_appl.model.entity.Artist;
import com.example.music_appl.model.entity.ArtistEnum;

public interface ArtistService {
    void initArtists();

    Artist findByArtist(ArtistEnum artist);
}
