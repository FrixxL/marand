package com.jakob.demo.document_report;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "document_reports")
public class document_report implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_doktor;
    private Date time;
    private String error;

    public document_report(Long id_doktor, Date time, String error) {
        this.id_doktor = id_doktor;
        this.time = time;
        this.error = error;
    }

    document_report(){}

    public Long getId_doktor() {
        return id_doktor;
    }

    public void setId_doktor(Long id_doktor) {
        this.id_doktor = id_doktor;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String  getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
