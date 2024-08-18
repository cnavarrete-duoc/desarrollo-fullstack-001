package com.duoc.peliculas_api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.peliculas_api.models.Movie;
import com.duoc.peliculas_api.services.MoviesService;
import com.duoc.peliculas_api.utils.Messages;

@RestController
@RequestMapping("/api/peliculas")
public class MoviesController {

    private static final Logger logger = LoggerFactory.getLogger(MoviesController.class);

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(moviesService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        logger.info("Buscando pelicula con id: {}", id);

        Movie movie = moviesService.getMovieById(id);

        if (movie == null) {
            logger.info(Messages.MOVIE_NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("Pelicula encontrada: {}", movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

        logger.info("Creando pelicula: {}", movie);

        Movie createdMovie = moviesService.addMovie(movie);

        logger.info("Pelicula creada: {}", createdMovie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        logger.info("Actualizando pelicula con id: {}", id);

        Movie updatedMovie = moviesService.updateMovie(id, movie);

        if (updatedMovie == null) {
            logger.info(Messages.MOVIE_NOT_FOUND);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("Pelicula actualizada: {}", updatedMovie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        logger.info("Eliminando pelicula con id: {}", id);

        boolean deleted = moviesService.deleteMovie(id);

        if (!deleted) {
            logger.info(Messages.MOVIE_NOT_FOUND);

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        logger.info("Pelicula eliminada");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
