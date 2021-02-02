package com.academy.netex.service;

import com.academy.netex.model.MovieModel;
import com.academy.netex.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MovieService {
    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    @Autowired
    private MovieRepo repository;

    public MovieService() {
        System.out.println("aaaaa");
    }

    public MovieService(MovieRepo repository){
        this.repository = repository;
    }

    public MovieModel saveMovie(MovieModel movie){
        return repository.save(movie);
    }

    public List<MovieModel> saveMovies(List<MovieModel> movie){
        return repository.saveAll(movie);
    }

    public List<MovieModel> getMovies(){
        return repository.findAll();
    }

    public MovieModel getMovieById(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteMovie(int id) {
        repository.deleteById(id);
        return "The movie with the id " + id + " has been removed";
    }

    public MovieModel updateMovie(MovieModel movie){
        MovieModel existingMovie = repository.findById(movie.getId()).orElse(null);
        existingMovie.setTitle(movie.getTitle());
        return repository.save(existingMovie);

    }

}
