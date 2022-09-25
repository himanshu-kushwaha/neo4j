package com.app.neo4j.controller;

import com.app.neo4j.model.Movie;
import com.app.neo4j.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/getMovies")
    public ResponseEntity<Page<Movie>> getMovies(@RequestParam(required = false) String title,
                                                 @RequestParam(required = false) Integer released,
                                                 Pageable pageable,
                                                 PagedResourcesAssembler assembler
                                                 ) {
        ResponseEntity<Page<Movie>> tResponseEntity = new ResponseEntity<>(movieService.getMovie(pageable),
                HttpStatus.OK);
        return tResponseEntity;
    }

    @GetMapping("/getMoviesDirector")
    public Collection<Movie> getMoviesDirector(){
        return movieService.getMovieDirector();
    }
}
