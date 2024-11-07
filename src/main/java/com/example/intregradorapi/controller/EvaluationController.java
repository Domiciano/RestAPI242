package com.example.intregradorapi.controller;

import com.example.intregradorapi.entity.Evaluation;
import com.example.intregradorapi.repository.EvaluationRepository;
import com.example.intregradorapi.repository.PatientRepository;
import com.example.intregradorapi.repository.TestInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(maxAge = 3600)
public class EvaluationController {

    @Autowired
    private EvaluationRepository evaluationRepository;

    //El navegador pide la muestra para graficarla
    //http://localhost:8080/evaluation/11
    @GetMapping("evaluation/{id}")
    public ResponseEntity<?> getEvaluationById(@PathVariable("id") long id){
        var evaluation = evaluationRepository.findById(id);
        if(evaluation.isPresent()){
            return ResponseEntity.status(200).body(evaluation.get());
        }else{
            var response = new HashMap<String, String>();
            response.put("message", "La muestra no se encontró");
            return ResponseEntity.status(404).body(response);
        }

    }

    //El Controlador envia datos a este endpoint
    @PostMapping("evaluation")
    public ResponseEntity<?> addEvaluation(@RequestBody Evaluation evaluation){
        evaluationRepository.save(evaluation);

        var response = new HashMap<String, String>();
        response.put("message", "Operacion realizada");
        return ResponseEntity.status(200).body(response);
    }


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TestInfoRepository testInfoRepository;


    public void get(){
        //Adquirir un paciente
        var optPatient = patientRepository.findByNatID("11438439423");
        if(optPatient.isPresent()){
            var patient = optPatient.get();
            var testInfos = testInfoRepository.findByPatient(patient);
            var clickedTestInfo = testInfos.get(0);
            var evaluation = evaluationRepository.findByTestInfo(clickedTestInfo);
        }
    }


}
