package com.jakob.demo.Pacient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

import com.jakob.demo.Doktor.Doktor;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient  implements Serializable {
        private static Log Log = LogFactory.getLog(Patient.class);

        private static final long serialversionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String first_name;


        private String last_name;


        //@Autowired
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "doktor_id",nullable = false)
        @Transient
        private Doktor doktor;

        @Transient
        private String[] diseases;

        @Column(name = "diseases")
        @JsonIgnore
        private String diseaseCSV;

    public Patient(Long id, String first_name, String last_name, Doktor doktor, String[] diseases, String diseaseCSV) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.doktor = doktor;
        this.diseases = diseases;
        this.diseaseCSV = diseaseCSV;
    }

    public String[] getDiseases() {
        return diseases;
    }

    public void setDiseases(String[] diseases) {
        this.diseases = diseases;
    }

    public String getDiseaseCSV() {
        String nekej="";
        for (String a:diseases
             ) {
            nekej+=a+" ";
        }
        return nekej;
    }

    public void setDiseaseCSV() {
        String nekej="";
        for (String a:diseases
        ) {
            nekej+=a+" ";
        }

        this.diseaseCSV = nekej;
    }

    public Patient(){};

    public Patient(Long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    @Autowired
    public Doktor getDoktor() {
        return doktor;
    }

    @Autowired
    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
