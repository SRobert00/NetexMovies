package com.academy.netex.repo;

import com.academy.netex.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepo extends JpaRepository<MovieModel, Integer> {
}
