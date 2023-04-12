package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class MyEntity {

    @Id
    private Long id;

    private String status;

    @Column("my_entity_id")
    private MyNestedEntity myNestedEntity;
}