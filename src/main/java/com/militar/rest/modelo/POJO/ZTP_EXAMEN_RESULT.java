package com.militar.rest.modelo.POJO;

import java.util.List;

public class ZTP_EXAMEN_RESULT {

    private int idexamen;
    private List<ZTP_PREGUNTAS_RESULT> lt_preguntas;

    
    public ZTP_EXAMEN_RESULT() {
    }

    public ZTP_EXAMEN_RESULT(int idexamen, List<ZTP_PREGUNTAS_RESULT> lt_preguntas) {
        this.idexamen = idexamen;
        this.lt_preguntas = lt_preguntas;
    }

    public int getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(int idexamen) {
        this.idexamen = idexamen;
    }
    
    public List<ZTP_PREGUNTAS_RESULT> getLt_preguntas() {
        return lt_preguntas;
    }

    public void setLt_preguntas(List<ZTP_PREGUNTAS_RESULT> lt_preguntas) {
        this.lt_preguntas = lt_preguntas;
    }
}
