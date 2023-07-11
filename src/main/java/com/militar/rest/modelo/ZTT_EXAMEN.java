package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_examen")
public class ZTT_EXAMEN {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idexamen;
	private int iduser;
	private int idcategoria;
	private int preguntas_total;
	private int preguntas_acertadas;
    private int preguntas_falladas;
    private String fecha_examen;
    private int tipoexamen;

    
    public ZTT_EXAMEN() {
    }

    public ZTT_EXAMEN(int iduser, int idcategoria, int preguntas_total, int preguntas_acertadas, int preguntas_falladas,
            String fecha_examen, int tipoexamen) {
        this.iduser = iduser;
        this.idcategoria = idcategoria;
        this.preguntas_total = preguntas_total;
        this.preguntas_acertadas = preguntas_acertadas;
        this.preguntas_falladas = preguntas_falladas;
        this.fecha_examen = fecha_examen;
        this.tipoexamen = tipoexamen;
    }

    public ZTT_EXAMEN(int idexamen, int iduser, int idcategoria, int preguntas_total, int preguntas_acertadas,
    int preguntas_falladas, String fecha_examen, int tipoexamen) {
        this.idexamen = idexamen;
        this.iduser = iduser;
        this.idcategoria = idcategoria;
        this.preguntas_total = preguntas_total;
        this.preguntas_acertadas = preguntas_acertadas;
        this.preguntas_falladas = preguntas_falladas;
        this.fecha_examen = fecha_examen;
        this.tipoexamen = tipoexamen;
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
    public int getPreguntas_total() {
        return preguntas_total;
    }
    public void setPreguntas_total(int preguntas_total) {
        this.preguntas_total = preguntas_total;
    }
    public int getPreguntas_acertadas() {
        return preguntas_acertadas;
    }
    public void setPreguntas_acertadas(int preguntas_acertadas) {
        this.preguntas_acertadas = preguntas_acertadas;
    }
    public int getPreguntas_falladas() {
        return preguntas_falladas;
    }
    public void setPreguntas_falladas(int preguntas_falladas) {
        this.preguntas_falladas = preguntas_falladas;
    }
    public String getFecha_examen() {
        return fecha_examen;
    }
    public void setFecha_examen(String fecha_examen) {
        this.fecha_examen = fecha_examen;
    }

    public int getTipoexamen() {
        return tipoexamen;
    }

    public void setTipoexamen(int tipoexamen) {
        this.tipoexamen = tipoexamen;
    }    
}
