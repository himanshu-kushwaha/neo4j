package com.app.neo4j.model;

public class MovieSearchCriteria {
    private String title;
    private Integer released;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleased() {
        return released;
    }

    public void setReleased(Integer released) {
        this.released = released;
    }
}
