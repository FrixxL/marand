package com.jakob.demo.Pacient;


import com.jakob.demo.Doktor.DoktorRepository;
import com.jakob.demo.NotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoktorRepository doktorRepository;

    @GetMapping("/doktors/{doktorId}/patients")
    public List<Patient> getPatientByDoktorId(@PathVariable Long doctorId){
        if(!doktorRepository.existsById(doctorId)){
            throw new NotFoundExeption("ta doktor ne obstaja");
        }
        return patientRepository.findByDoktorId(doctorId);
    }
    @PostMapping("/doktors/{doktorId}/patients")
    public Patient addPatient(@PathVariable Long doktorId,
                              @Validated@RequestBody Patient patient){
        return doktorRepository.findById(doktorId)
                .map( doktor-> {

                        patient.setDoktor(doktor);
                        return patientRepository.save(patient);

                }).orElseThrow(() -> new NotFoundExeption("pacient ni najden"));
    }



}
