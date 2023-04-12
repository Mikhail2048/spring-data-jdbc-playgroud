package org.example.repository;

import java.util.Optional;

import org.example.AbstractIntegrationTest;
import org.example.model.MyEntity;
import org.example.model.MyNestedEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:org/example/repository/MyEntityRepositoryIntegrationTest.sql")
public class MyEntityRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private MyEntityRepository myEntityRepository;

    @Test
    void whenInsertEntityWithNestedEntity_thenGot2Inserts() {
        MyEntity myEntity = new MyEntity();
        myEntity.setMyNestedEntity(new MyNestedEntity("alesha"));
        myEntity.setStatus("active");
        myEntityRepository.save(myEntity);
    }

    @Test
    void whenFindByRootId_then2EntitiesAreSelectedViaJoin() {
        MyEntity myEntity = new MyEntity();
        myEntity.setMyNestedEntity(new MyNestedEntity("alesha"));
        myEntity.setStatus("active");
        MyEntity save = myEntityRepository.save(myEntity);

        Optional<MyEntity> byId = myEntityRepository.findById(save.getId());
        System.out.println(byId.get());
    }

    @Test
    void whenFindByCustomProperty_then2EntitiesAreSelectedViaJoin() {
        MyEntity myEntity = new MyEntity();
        myEntity.setMyNestedEntity(new MyNestedEntity("alesha"));
        myEntity.setStatus("active");
        myEntityRepository.save(myEntity);

        Optional<MyEntity> byId = myEntityRepository.findByStatus("active");
        System.out.println(byId.get());
    }

    @Test
    void whenFindByCustomNestedProperty_then2EntitiesAreSelectedViaJoin() {
        MyEntity myEntity = new MyEntity();
        myEntity.setMyNestedEntity(new MyNestedEntity("alesha"));
        myEntity.setStatus("active");
        MyEntity save = myEntityRepository.save(myEntity);

        Optional<MyEntity> byId = myEntityRepository.findByMyNestedEntity_Name("name");
        System.out.println(byId.get());
    }
}