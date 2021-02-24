package com.example.music_appl.model.view;

import com.example.music_appl.model.entity.ArtistEnum;
import com.example.music_appl.model.entity.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String imgUrl;
    private String name;
    private ArtistEnum artist;
    private GenreEnum genre;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Long copies;

    public AlbumViewModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumViewModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumViewModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Long getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(Long copies) {
        this.copies = copies;
        return this;
    }
}
