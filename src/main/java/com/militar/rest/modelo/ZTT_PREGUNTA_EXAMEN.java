package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_pregunta_examen")
public class ZTT_PREGUNTA_EXAMEN {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idexamen_pregunta;
	private int idexamen;
	private int idpregunta;
	private boolean rcorrecta;
	private boolean rfalsa1;
	private boolean rfalsa2;
	private boolean rfalsa3;
	private String fecha_creacion;

    
    public ZTT_PREGUNTA_EXAMEN() {
    }

    public ZTT_PREGUNTA_EXAMEN(int idexamen, int idpregunta, boolean rcorrecta, boolean rfalsa1,
            boolean rfalsa2, boolean rfalsa3, String fecha_creacion) {
        this.idexamen = idexamen;
        this.idpregunta = idpregunta;
        this.rcorrecta = rcorrecta;
        this.rfalsa1 = rfalsa1;
        this.rfalsa2 = rfalsa2;
        this.rfalsa3 = rfalsa3;
        this.fecha_creacion = fecha_creacion;
    }

    public int getIdexamen_pregunta() {
        return idexamen_pregunta;
    }

    public void setIdexamen_pregunta(int idexamen_pregunta) {
        this.idexamen_pregunta = idexamen_pregunta;
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

    public boolean isRcorrecta() {
        return rcorrecta;
    }

    public void setRcorrecta(boolean rcorrecta) {
        this.rcorrecta = rcorrecta;
    }

    public boolean isRfalsa1() {
        return rfalsa1;
    }

    public void setRfalsa1(boolean rfalsa1) {
        this.rfalsa1 = rfalsa1;
    }

    public boolean isRfalsa2() {
        return rfalsa2;
    }

    public void setRfalsa2(boolean rfalsa2) {
        this.rfalsa2 = rfalsa2;
    }

    public boolean isRfalsa3() {
        return rfalsa3;
    }

    public void setRfalsa3(boolean rfalsa3) {
        this.rfalsa3 = rfalsa3;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}