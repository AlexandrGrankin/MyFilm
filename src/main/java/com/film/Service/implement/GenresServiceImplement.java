package com.film.Service.implement;

import com.film.Service.GenresService;
import com.film.model.Genre;
import com.film.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresServiceImplement implements GenresService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre addGenre(Genre genre) {
        Genre savedGenre = genreRepository.saveAndFlush(genre);
        return savedGenre;
    }

    @Override
    public Genre editGenre(Genre genre) {
        Genre savedGenre = genreRepository.saveAndFlush(genre);
        return savedGenre;
    }

    @Override
    public Genre getById(long id) {
        return genreRepository.getById(id);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public void delete(long id) {
        Genre genre = genreRepository.getById(id);
        genreRepository.delete(genre);
    }
}
