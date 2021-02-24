package com.example.music_appl.service.serviceImpl;

import com.example.music_appl.model.entity.Album;
import com.example.music_appl.model.service.AlbumServiceModel;
import com.example.music_appl.model.view.AlbumViewModel;
import com.example.music_appl.repository.AlbumRepository;
import com.example.music_appl.service.AlbumService;
import com.example.music_appl.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(artistService.findByArtist(albumServiceModel.getArtist()));

        albumRepository.save(album);
    }

    @Override
    public Long findTotalCopies() {
        return albumRepository.findTotalCopies();
    }

    @Override
    public List<AlbumViewModel> findAllAlbums() {
        List<AlbumServiceModel> list = albumRepository.findAll().stream()
                .map(album -> modelMapper.map(album, AlbumServiceModel.class))
                .collect(Collectors.toList());

        return list.stream()
                .map(album -> modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }
}
