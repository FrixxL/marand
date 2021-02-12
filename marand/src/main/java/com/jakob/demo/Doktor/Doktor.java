package com.jakob.demo.Doktor;

import com.fasterxml.jackson.annotation.*;
import com.jakob.demo.Pacient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doktors")
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doktor implements Serializable {
    private static final long serialversionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String department;


    @Autowired
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> patients = new ArrayList<>();

    public Doktor() {
    }

    ;

    public Doktor(String department, List<Patient> patients) {
        this.department = department;
        this.patients = patients;
    }

    public static long getSerialversionUID() {
        return serialversionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doktor{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", patients=" + patients +
                '}';
    }
}
