package com.jakob.demo.Doktor;

import com.fasterxml.jackson.annotation.*;
import com.jakob.demo.Pacient.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "doktors")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "doktorId",
        "department",
        "patients"

})

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doktor implements Serializable {
    private static final long serialversionUID = 1L;
    @JsonProperty("doktorId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("department")
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
