package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztm_compra")
public class ZTT_COMPRA {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcompra;
	private int iduser;
	private int idcurso;
	private String precio_compra;
	private String fecha_compra;

    
    public ZTT_COMPRA() {
    }

    public ZTT_COMPRA(int idcompra, int iduser, int idcurso, String precio_compra, String fecha_compra) {
        this.idcompra = idcompra;
        this.iduser = iduser;
        this.idcurso = idcurso;
        this.precio_compra = precio_compra;
        this.fecha_compra = fecha_compra;
    }

    public int getIdcompra() {
        return idcompra;
    }
    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public int getIdcurso() {
        return idcurso;
    }
    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }
    public String getPrecio_compra() {
        return precio_compra;
    }
    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }
    public String getFecha_compra() {
        return fecha_compra;
    }
    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

}
