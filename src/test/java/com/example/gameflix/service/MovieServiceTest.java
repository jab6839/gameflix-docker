package com.example.gameflix.service;

import com.example.gameflix.model.Movie;
import com.example.gameflix.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllMovies_ShouldReturnList() {
        Movie movie1 = new Movie("Test Movie", "Action", "8.0", "This is a test movie");
        Movie movie2 = new Movie("Another Movie", "Horror", "7.5", "Thrilling movie");

        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));

        List<Movie> movies = movieService.getAllMovies();

        assertEquals(2, movies.size());
        verify(movieRepository, times(1)).findAll();
    }

    @Test
    public void addMovie_ShouldIncreaseSize() {
        Movie movie = new Movie("New Movie", "Comedy", "8.0", "Funny and entertaining");

        when(movieRepository.save(movie)).thenReturn(movie);

        Movie saved = movieService.addMovie(movie);

        assertNotNull(saved);
        assertEquals("New Movie", saved.getTitle());
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    public void getMovieById_ShouldReturnCorrectMovie() {
        Movie movie = new Movie("Test Movie", "Action", "8.0", "This is a test movie");

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        Movie found = movieService.getMovieById(1L);

        assertNotNull(found);
        assertEquals("Test Movie", found.getTitle());
        verify(movieRepository, times(1)).findById(1L);
    }
}

