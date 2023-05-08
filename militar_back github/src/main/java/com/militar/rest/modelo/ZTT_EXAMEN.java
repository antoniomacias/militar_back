package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_examen")
public class ZTT_EXAMEN {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idexamen;
	private int iduser;
	private int idcategoria;
	private String preguntas_total;
	private String preguntas_acertadas;
    private String preguntas_falladas;
    private String fecha_examen;

    
    public ZTT_EXAMEN() {
    }

    public ZTT_EXAMEN(int idexamen, int iduser, int idcategoria, String preguntas_total, String preguntas_acertadas,
            String preguntas_falladas, String fecha_examen) {
        this.idexamen = idexamen;
        this.iduser = iduser;
        this.idcategoria = idcategoria;
        this.preguntas_total = preguntas_total;
        this.preguntas_acertadas = preguntas_acertadas;
        this.preguntas_falladas = preguntas_falladas;
        this.fecha_examen = fecha_examen;
    }

    public int getIdexamen() {
        return idexamen;
    }
    public void setIdexamen(int idexamen) {
        this.idexamen = idexamen;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public int getIdcategoria() {
        return idcategoria;
    }
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    public String getPreguntas_total() {
        return preguntas_total;
    }
    public void setPreguntas_total(String preguntas_total) {
        this.preguntas_total = preguntas_total;
    }
    public String getPreguntas_acertadas() {
        return preguntas_acertadas;
    }
    public void setPreguntas_acertadas(String preguntas_acertadas) {
        this.preguntas_acertadas = preguntas_acertadas;
    }
    public String getPreguntas_falladas() {
        return preguntas_falladas;
    }
    public void setPreguntas_falladas(String preguntas_falladas) {
        this.preguntas_falladas = preguntas_falladas;
    }
    public String getFecha_examen() {
        return fecha_examen;
    }
    public void setFecha_examen(String fecha_examen) {
        this.fecha_examen = fecha_examen;
    }    
}
