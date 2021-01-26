package com.film.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class GenreFilm {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String name;
    private String type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "FILM_ID")
    private Film primaryID;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Film getPrimaryID() {
        return primaryID;
    }

    public void setPrimaryID(Film primaryID) {
        this.primaryID = primaryID;
    }

    @Override
    public String toString() {
        return "GenreFilm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", primaryID=" + primaryID.getId() +
                '}';
    }
}
