package com.example.music_appl.model.service;

import com.example.music_appl.model.entity.ArtistEnum;
import com.example.music_appl.model.entity.GenreEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel extends BaseServiceModel{
    private String name;
    private String imgUrl;
    private String description;
    private int copies;
    private BigDecimal price;
    private LocalDate releaseDate;
    private String producer;
    private GenreEnum genre;
    private ArtistEnum artist;
    private UserServiceModel addedFrom;

    public AlbumServiceModel() {
    }

    @Length(min = 3, max =  20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank(message = "Enter valid name")
    public String getName() {
        return name;
    }

    public AlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 5, message = "Image Url length must be minimum 5(inclusive) characters.")
    @NotBlank(message = "Enter valid image URL")
    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumServiceModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    @NotBlank(message = "Enter description.")
    public String getDescription() {
        return description;
    }

    public AlbumServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @Min(value = 10, message = "Copies must be a more than 10(inclusive).")
    @NotNull(message = "Enter copies.")
    public int getCopies() {
        return copies;
    }

    public AlbumServiceModel setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    @DecimalMin(value = "0", message = "Price must be a positive number")
    @NotNull(message = "Enter price.")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The date cannot be in the future!")
    @NotNull
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumServiceModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumServiceModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @NotNull
    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumServiceModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    public UserServiceModel getAddedFrom() {
        return addedFrom;
    }

    public AlbumServiceModel setAddedFrom(UserServiceModel addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
