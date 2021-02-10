package com.academy.netex.repo;

import com.academy.netex.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@Repository
public interface MovieRepo extends JpaRepository<MovieModel, Integer>,
        QuerydslPredicateExecutor<MovieModel> {

}
