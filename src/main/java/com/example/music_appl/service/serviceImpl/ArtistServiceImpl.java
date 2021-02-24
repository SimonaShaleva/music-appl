package com.example.music_appl.service.serviceImpl;

import com.example.music_appl.model.entity.Artist;
import com.example.music_appl.model.entity.ArtistEnum;
import com.example.music_appl.repository.ArtistRepository;
import com.example.music_appl.service.ArtistService;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void initArtists() {
        if (artistRepository.count() != ArtistEnum.values().length) {
            for (ArtistEnum a : ArtistEnum.values()) {
                artistRepository.save(new Artist(a));
            }
        }
    }

    @Override
    public Artist findByArtist(ArtistEnum artist) {
        return artistRepository.findByArtist(artist);
    }
}
