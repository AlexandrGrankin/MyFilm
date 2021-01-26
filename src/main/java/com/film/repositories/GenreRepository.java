package com.film.repositories;


import com.film.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("SELECT b FROM Genre b where b.id = :id")
    Genre getById(@Param("id") long id);

}
