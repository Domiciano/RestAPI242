package com.example.intregradorapi.repository;

import com.example.intregradorapi.entity.Patient;
import com.example.intregradorapi.entity.TestInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestInfoRepository  extends CrudRepository<TestInfo, Long> {

    List<TestInfo> findByPatient(Patient patient);

}
