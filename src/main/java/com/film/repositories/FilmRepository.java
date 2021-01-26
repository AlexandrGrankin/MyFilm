package com.film.repositories;

import com.film.model.Film;
import com.film.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT b FROM Film b where b.id = :id")
    Film getById(@Param("id") long id);
}
