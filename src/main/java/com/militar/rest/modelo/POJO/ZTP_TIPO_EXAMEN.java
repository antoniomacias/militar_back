package com.militar.rest.modelo.POJO;

import java.util.List;

public class ZTP_TIPO_EXAMEN {
    private int type_exam;
    private String exam;
    private List<ZTP_RESULTADOS> lt_result;

    
    public ZTP_TIPO_EXAMEN() {
    }

    public ZTP_TIPO_EXAMEN(int type_exam, String exam, List<ZTP_RESULTADOS> lt_result) {
        this.type_exam = type_exam;
        this.exam = exam;
        this.lt_result = lt_result;
    }

    public int getType_exam() {
        return type_exam;
    }

    public void setType_exam(int type_exam) {
        this.type_exam = type_exam;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public List<ZTP_RESULTADOS> getLt_result() {
        return lt_result;
    }

    public void setLt_result(List<ZTP_RESULTADOS> lt_result) {
        this.lt_result = lt_result;
    }
}
