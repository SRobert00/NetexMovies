package com.academy.netex.controller;

import com.academy.netex.model.MovieModel;
import com.academy.netex.service.MovieService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@Configurable
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/addMovie")
    public MovieModel addMovie(@RequestBody MovieModel movie){ return service.saveMovie(movie); }

    @PostMapping("/addMovies")
    public List<MovieModel> addMovies(@RequestBody List<MovieModel> movie){
        return service.saveMovies(movie);
    }

    @GetMapping("/movies")
    public List<MovieModel> findAllMovies(){
        return service.getMovies();
    }

    @GetMapping("/movieById/{id}")
    public MovieModel findMovieById(@PathVariable int id){
        return service.getMovieById(id);
    }
    @PutMapping("/update")
    public MovieModel updateMovie(@RequestBody MovieModel movie){
        return service.updateMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id){
        return service.deleteMovie(id);
    }


}
