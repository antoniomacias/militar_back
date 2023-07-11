package com.militar.rest.modelo.POJO;

import java.util.List;

import com.militar.rest.modelo.ZTT_PREGUNTA;

public class ZTP_EXAMEN {
    private int idexam;
    private String name;
    private List<ZTT_PREGUNTA> lt_exam;

    
    public ZTP_EXAMEN() {
    }

    public ZTP_EXAMEN(int idexam, String name, List<ZTT_PREGUNTA> lt_exam) {
        this.idexam = idexam;
        this.lt_exam = lt_exam;
    }

    public int getIdexam() {
        return idexam;
    }

    public void setIdexam(int idexam) {
        this.idexam = idexam;
    }

    public List<ZTT_PREGUNTA> getLt_exam() {
        return lt_exam;
    }

    public void setLt_exam(List<ZTT_PREGUNTA> lt_exam) {
        this.lt_exam = lt_exam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
