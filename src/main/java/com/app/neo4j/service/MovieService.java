package com.app.neo4j.service;


import com.app.neo4j.model.Movie;
import com.app.neo4j.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Page<Movie> getMovie(Pageable pageable) {
          return  movieRepository.findAll(pageable);
    }

    public Collection<Movie> getMovieDirector() {
        return movieRepository.getMovieDirector();
    }
}
