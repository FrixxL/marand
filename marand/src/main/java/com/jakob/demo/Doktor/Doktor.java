package com.jakob.demo.Doktor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jakob.demo.Pacient.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doktors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doktor implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "doktor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(value = "patients")
    private List<Patient> patients;

    public Doktor(){};

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
