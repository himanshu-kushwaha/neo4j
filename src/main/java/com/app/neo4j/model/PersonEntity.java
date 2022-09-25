package com.app.neo4j.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class PersonEntity {
    @Id @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private final String name;

    private final Integer born;

    public PersonEntity(Integer born, String name) {
        this.born = born;
        this.name = name;
    }

    public Integer getBorn() {
        return born;
    }

    public String getName() {
        return name;
    }

}
