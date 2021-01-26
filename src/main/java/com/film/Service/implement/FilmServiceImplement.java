package com.film.Service.implement;

import com.film.Service.FilmService;
import com.film.model.Film;
import com.film.model.Genre;
import com.film.repositories.FilmRepository;
import com.film.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImplement implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public Film addFilm(Film film) {
        Film saveFilm = filmRepository.saveAndFlush(film);
        return saveFilm;
    }

    @Override
    public Film editFilm(Film film) {
        Film saveFilm = filmRepository.saveAndFlush(film);
        return saveFilm;
    }

    @Override
    public Film getById(long id) {
        return filmRepository.getById(id);
    }

    @Override
    public List<Film> getAll() {

        return filmRepository.findAll();
    }

    @Override
    public void delete(long id) {
        Film film = filmRepository.getById(id);
        filmRepository.delete(film);
    }
}
