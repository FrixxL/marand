package com.jakob.demo.Pacient;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient,Long> {
    List<Patient> findByDoktorId(Long doktorId);
}
