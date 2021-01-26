package com.film.Service;

import com.film.model.Film;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FilmService {

    Film addFilm(Film film);
    Film editFilm(Film film);
    Film getById(long id);
    List<Film> getAll();

    void delete(long id);

}
