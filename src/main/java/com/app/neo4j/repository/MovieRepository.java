package com.app.neo4j.repository;

import com.app.neo4j.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository  extends Neo4jRepository<Movie, String> {
//    @Query("MATCH (movie:Movie) RETURN movie")
    Page<Movie> findAll( Pageable page);

    @Query("MATCH (movie:Movie) <- [r:DIRECTED]- (person:Person) RETURN person, movie,r")
    List<Movie> getMovieDirector();
}
