package com.example.music_appl.service;

import com.example.music_appl.model.service.AlbumServiceModel;
import com.example.music_appl.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumServiceModel albumServiceModel);

    Long findTotalCopies();

    List<AlbumViewModel> findAllAlbums();

    void deleteById(Long id);
}
