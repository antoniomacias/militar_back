package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_pregunta_examen")
public class ZTT_PREGUNTA_EXAMEN {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpreguntaexamen;
	private int idexamen;
	private int idpregunta;
	private boolean acertada;
	private String fecha_creacion;

    
    public ZTT_PREGUNTA_EXAMEN() {
    }

    public ZTT_PREGUNTA_EXAMEN(int idpreguntaexamen, int idexamen, int idpregunta, boolean acertada,
            String fecha_creacion) {
        this.idpreguntaexamen = idpreguntaexamen;
        this.idexamen = idexamen;
        this.idpregunta = idpregunta;
        this.acertada = acertada;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdpreguntaexamen() {
        return idpreguntaexamen;
    }

    public void setIdpreguntaexamen(int idpreguntaexamen) {
        this.idpreguntaexamen = idpreguntaexamen;
    }

    public int getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(int idexamen) {
        this.idexamen = idexamen;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

}
