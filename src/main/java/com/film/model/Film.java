package com.film.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "FILM_ID", length = 6, nullable = false)
    private long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "primaryID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GenreFilm> genre = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GenreFilm> getGenre() {
        return genre;
    }

    public void setGenre(List<GenreFilm> genre) {
        this.genre = genre;
    }
}
