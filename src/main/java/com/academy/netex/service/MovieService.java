package com.academy.netex.service;

import com.academy.netex.model.MovieModel;
import com.academy.netex.repo.MovieRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MovieService {
    private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());

    @Autowired
    private MovieRepo repository;


    public JPAQueryFactory getJPAQueryFactory(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movies");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return new JPAQueryFactory(entityManager);
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
