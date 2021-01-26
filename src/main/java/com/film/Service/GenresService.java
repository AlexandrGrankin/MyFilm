package com.film.Service;

import com.film.model.Genre;

import java.util.List;

public interface GenresService {

    Genre addGenre(Genre genre);
    Genre editGenre(Genre genre);
    Genre getById(long id);
    List<Genre> getAll();

    void delete(long id);

}
