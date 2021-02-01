package com.academy.netex.repo;

import com.academy.netex.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MovieRepo extends JpaRepository<MovieModel, Integer> {
}
