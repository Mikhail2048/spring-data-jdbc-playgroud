package org.example.repository;

import java.util.Optional;

import org.example.model.MyEntity;
import org.springframework.data.repository.CrudRepository;

public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {

    Optional<MyEntity> findByStatus(String status);

    Optional<MyEntity> findByMyNestedEntity_Name(String name);
}