package com.example.intregradorapi.repository;

import com.example.intregradorapi.entity.Evaluation;
import com.example.intregradorapi.entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    Optional<Patient> findByNatID(String natID);

}
