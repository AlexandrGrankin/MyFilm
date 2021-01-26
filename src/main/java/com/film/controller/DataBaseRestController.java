package com.film.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.film.Service.FilmService;
import com.film.model.Film;
import com.film.model.Genre;
import com.film.model.GenreFilm;
import com.google.gson.Gson;
import com.film.Service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataBaseRestController {

    @Autowired
    GenresService genresService;

    @Autowired
    FilmService filmService;

    @GetMapping("/getAllGenres")
    public String getAllGenres(Model model) {
        List<Genre> genreList = genresService.getAll();
        String json = new Gson().toJson(genreList);
        return json;
    }

    @GetMapping("/getIdGenres/{id}")
    public String getIdGenres(@PathVariable(value = "id") long id, Model model) {
        Genre genre = genresService.getById(id);
        String json = new Gson().toJson(genre);
        return json;
    }

    @RequestMapping(value = "/addGenreJson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public String addTasks(@RequestBody String genre) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Genre saveGenre = mapper.readValue(genre, Genre.class);
        genresService.addGenre(saveGenre);
        return "0";
    }

    @RequestMapping(value = "/editGenreJson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public String editTasks(@RequestBody String genre) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Genre saveGenre = mapper.readValue(genre, Genre.class);
        genresService.editGenre(saveGenre);
        return "0";
    }

    @GetMapping("/deleteIdGenre/{id}")
    public String deleteIdGenre(@PathVariable(value = "id") long id, Model model) {
        genresService.delete(id);
        return "0";
    }

    @GetMapping("/deleteIdFilm/{id}")
    public String deleteIdFilm(@PathVariable(value = "id") long id, Model model) {
        filmService.delete(id);
        return "0";
    }


    @GetMapping("/getAllFilms")
    public String getAllFilms(Model model) {
        List<Film> filmsList = filmService.getAll();
        for (int i = 0; i < filmsList.size(); i++) {
            for (int j = 0; j < filmsList.get(i).getGenre().size(); j++) {
                filmsList.get(i).getGenre().get(j).setPrimaryID(null);
            }
        }
//        Film film = filmsList.get(0);
//        System.out.println("FilmElem0: " + film.getGenre().size());
//        film.getGenre().get(0).setPrimaryID(null);

        String json = new Gson().toJson(filmsList);
        return json;
    }

    @RequestMapping(value = "/addFilmJson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public String addFilm(@RequestBody String film) throws JsonProcessingException {
//        System.out.println(film);
        ObjectMapper mapper = new ObjectMapper();
        Film saveFilm = mapper.readValue(film, Film.class);
        Film film1 = filmService.getById(saveFilm.getId());
        if (film1 == null) {
            film1 = filmService.addFilm(new Film());

        }
        film1.setTitle(saveFilm.getTitle());
        film1.setDescription(saveFilm.getDescription());
        film1.getGenre().clear();
        for (int i = 0; i < saveFilm.getGenre().size(); i++) {
            saveFilm.getGenre().get(i).setPrimaryID(film1);
            film1.getGenre().add(saveFilm.getGenre().get(i));
        }
        filmService.addFilm(film1);

        return "0";
    }


}
