package com.app.neo4j.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Movie {
    @Id
    private final String title;

    private final String tagline;

    private Integer released;

    private Long votes;

    public List<PersonEntity> getDirectors() {
        return directors;
    }

    public void setDirectors(List<PersonEntity> directors) {
        this.directors = directors;
    }

    public Movie(String title, String tagline) {
        this.title = title;
        this.tagline = tagline;
    }
//    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
//    private List<Roles> actorsAndRoles;

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<PersonEntity> directors = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public String getTagline() {
        return tagline;
    }

    public Integer getReleased() {
        return released;
    }

    public Long getVotes() {
        return votes;
    }

    public void setReleased(Integer released) {
        this.released = released;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }
}
