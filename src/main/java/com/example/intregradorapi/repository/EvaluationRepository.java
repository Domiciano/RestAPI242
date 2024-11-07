package com.example.intregradorapi.repository;

import com.example.intregradorapi.entity.Evaluation;
import com.example.intregradorapi.entity.TestInfo;
import com.example.intregradorapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//CRUD para entidad
//C: create, R: read, U:update, D:delete
public interface EvaluationRepository extends CrudRepository<Evaluation, Long> {

    Optional<Evaluation> findByTestInfo(TestInfo testInfo);

}
