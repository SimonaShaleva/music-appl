package com.example.music_appl.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {
    private ArtistEnum artist;
    private String careerInformation;

    public Artist() {
    }

    public Artist(ArtistEnum artist) {
        this.artist = artist;
    }

    @Column(name = "artist", nullable = false)
    @Enumerated(EnumType.STRING)
    public ArtistEnum getArtist() {
        return artist;
    }

    public Artist setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    @Column(name = "career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public Artist setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
