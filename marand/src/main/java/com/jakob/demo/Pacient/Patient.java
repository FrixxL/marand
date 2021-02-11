package com.jakob.demo.Pacient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jakob.demo.Doktor.Doktor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient  implements Serializable {
        private static final long serialversionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "first_name")
        private String first_name;

        @Column(name = "last_name")
        private String last_name;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "doktor_id",nullable = false)
        @JsonIgnore
        private Doktor doktor;

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

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", doktor=" + doktor +
                '}';
    }
}
