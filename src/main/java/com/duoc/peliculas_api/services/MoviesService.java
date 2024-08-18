package com.duoc.peliculas_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duoc.peliculas_api.models.Movie;

@Service
public class MoviesService {

        private List<Movie> movies = new ArrayList<>();

        public MoviesService() {
                movies.add(new Movie(1, "La esperanza es lo último que se pierde", "1994", "Frank Darabont",
                                "Drama",
                                "Dos prisioneros en una cárcel de máxima seguridad desarrollan una profunda amistad mientras buscan esperanza y redención."));
                movies.add(new Movie(2, "El Padrino", "1972", "Francis Ford Coppola", "Crimen",
                                "La saga de una familia mafiosa que lucha por mantener el poder y la lealtad en un mundo de traición y violencia."));
                movies.add(new Movie(3, "Cien años de soledad", "1984", "Gabriel García Márquez", "Drama",
                                "La historia mágica de la familia Buendía en el pueblo ficticio de Macondo, explorando temas de amor, soledad y destino."));
                movies.add(new Movie(4, "El resplandor", "1980", "Stanley Kubrick", "Terror",
                                "Un hombre y su familia se mudan a un hotel aislado donde fuerzas sobrenaturales despiertan el terror y la locura."));
                movies.add(new Movie(5, "La vida es bella", "1997", "Roberto Benigni", "Comedia dramática",
                                "Un padre utiliza su imaginación y humor para proteger a su hijo de los horrores del campo de concentración nazi."));
                movies.add(new Movie(6, "Amélie", "2001", "Jean-Pierre Jeunet", "Comedia romántica",
                                "Una joven solitaria decide mejorar la vida de quienes la rodean mientras busca su propio camino hacia el amor."));
                movies.add(new Movie(7, "La la land", "2016", "Damien Chazelle", "Musical",
                                "Una aspirante a actriz y un músico luchan por sus sueños en Los Ángeles mientras desarrollan una historia de amor inolvidable."));
                movies.add(new Movie(8, "El laberinto del fauno", "2006", "Guillermo del Toro", "Fantasía",
                                "Una niña se sumerge en un mundo de fantasía para escapar de la dura realidad de la posguerra española y encontrar su verdadera identidad."));
                movies.add(new Movie(9, "Inception", "2010", "Christopher Nolan", "Ciencia ficción",
                                "Un ladrón especializado en el arte de la extracción de secretos de los sueños recibe una oferta para realizar la tarea imposible de implantar una idea en la mente de un objetivo."));
                movies.add(new Movie(10, "El viaje de Chihiro", "2001", "Hayao Miyazaki", "Animación",
                                "Una niña se aventura en un mundo mágico lleno de espíritus y criaturas mientras busca rescatar a sus padres transformados en cerdos y regresar a casa."));
        }

        public List<Movie> getAllMovies() {
                return movies;
        }

        public Movie getMovieById(int id) {
                return movies.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
        }

        public Movie addMovie(Movie movie) {

                int maxId = movies.stream().mapToInt(Movie::getId).max().orElse(0);
                movie.setId(maxId + 1);
                movies.add(movie);
                return movie;
        }

        public Movie updateMovie(int id, Movie newMovie) {
                Optional<Movie> existingMovieOptional = movies.stream()
                                .filter(movie -> movie.getId() == id)
                                .findFirst();

                if (existingMovieOptional.isPresent()) {
                        Movie existingMovie = existingMovieOptional.get();
                        int index = movies.indexOf(existingMovie);
                        newMovie.setId(existingMovie.getId());
                        movies.set(index, newMovie);
                        return newMovie;
                }

                return null;
        }

        public boolean deleteMovie(int id) {
                Optional<Movie> existingMovieOptional = movies.stream()
                                .filter(movie -> movie.getId() == id)
                                .findFirst();

                if (existingMovieOptional.isPresent()) {
                        Movie existingMovie = existingMovieOptional.get();
                        movies.remove(existingMovie);
                        return true;
                }

                return false;
        }

}
