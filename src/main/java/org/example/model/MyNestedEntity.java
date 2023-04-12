package org.example.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class MyNestedEntity {

    @Id
    private Long id;

    private String name;

    public MyNestedEntity() {
    }

    public MyNestedEntity(String name) {
        this.name = name;
    }
}