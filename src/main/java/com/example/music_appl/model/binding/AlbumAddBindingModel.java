package com.example.music_appl.model.binding;

import com.example.music_appl.model.entity.ArtistEnum;
import com.example.music_appl.model.entity.GenreEnum;
import com.example.music_appl.model.service.UserServiceModel;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    private String name;
    private String imgUrl;
    private BigDecimal price;
    private int copies;
    private LocalDate releaseDate;
    private String producer;
    private ArtistEnum artist;
    private GenreEnum genre;
    private String description;
    private UserServiceModel addedFrom;

    public AlbumAddBindingModel() {
    }

    @Length(min = 3, max =  20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank(message = "Enter valid name")
    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 5, message = "Image Url length must be minimum 5(inclusive) characters.")
    @NotBlank(message = "Enter valid image URL")
    public String getImgUrl() {
        return imgUrl;
    }

    public AlbumAddBindingModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    @DecimalMin(value = "0", message = "Price must be a positive number")
    @NotNull(message = "Enter price.")
    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Min(value = 10, message = "Copies must be a more than 10(inclusive).")
    @NotNull(message = "Enter copies.")
    public int getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(int copies) {
        this.copies = copies;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The date cannot be in the future!")
    @NotNull(message = "Enter date.")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    @NotNull(message = "Select artist")
    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    @NotNull(message = "Select genre")
    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    @NotBlank(message = "Enter description.")
    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserServiceModel getAddedFrom() {
        return addedFrom;
    }

    public AlbumAddBindingModel setAddedFrom(UserServiceModel addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
