package com.militar.rest.modelo.POJO;

import java.util.List;

import com.militar.rest.modelo.ZTT_PREGUNTA;

public class ZTP_SIMULACRO {
    private int idexam;
    private int idcategory;
    private String category;
    private String timer;
    private ZTT_PREGUNTA ls_example;
    private List<ZTT_PREGUNTA> lt_exam;

    
    public ZTP_SIMULACRO() {
    }

    public ZTP_SIMULACRO(int idexam, int idcategory, String category, String timer, ZTT_PREGUNTA ls_example,
            List<ZTT_PREGUNTA> lt_exam) {
        this.idexam = idexam;
        this.idcategory = idcategory;
        this.category = category;
        this.timer = timer;
        this.ls_example = ls_example;
        this.lt_exam = lt_exam;
    }

    public String getTimer() {
        return timer;
    }



    public void setTimer(String timer) {
        this.timer = timer;
    }



    public ZTT_PREGUNTA getLs_example() {
        return ls_example;
    }



    public void setLs_example(ZTT_PREGUNTA ls_example) {
        this.ls_example = ls_example;
    }



    public int getIdexam() {
        return idexam;
    }
    public void setIdexam(int idexam) {
        this.idexam = idexam;
    }
    public int getIdcategory() {
        return idcategory;
    }
    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<ZTT_PREGUNTA> getLt_exam() {
        return lt_exam;
    }
    public void setLt_exam(List<ZTT_PREGUNTA> lt_exam) {
        this.lt_exam = lt_exam;
    }

    
}
