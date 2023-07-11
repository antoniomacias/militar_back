package com.militar.rest.modelo.POJO;

import com.militar.rest.modelo.ZTT_PREGUNTA;

public class ZTP_RETURN_EXAMEN {
    private ZTT_PREGUNTA ls_pregunta;
    private String respuesta;

    public ZTP_RETURN_EXAMEN() {
    }

    public ZTP_RETURN_EXAMEN(ZTT_PREGUNTA ls_pregunta, String respuesta) {
        this.ls_pregunta = ls_pregunta;
        this.respuesta = respuesta;
    }

    public ZTT_PREGUNTA getLs_pregunta() {
        return ls_pregunta;
    }
    public void setLs_pregunta(ZTT_PREGUNTA ls_pregunta) {
        this.ls_pregunta = ls_pregunta;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
