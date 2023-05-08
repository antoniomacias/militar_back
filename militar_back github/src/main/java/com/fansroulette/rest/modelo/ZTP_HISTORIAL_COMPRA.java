package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

public class ZTP_HISTORIAL_COMPRA {
	private int idcompra;
	private int iduser;
	private int idficha;
	private float precio_compra;
	private Timestamp fecha_compra;
    private int cantidad;
	private float precio;

    
    public ZTP_HISTORIAL_COMPRA() {
    }

    public ZTP_HISTORIAL_COMPRA(int idcompra, int iduser, int idficha, float precio_compra, Timestamp fecha_compra,
            int cantidad, float precio) {
        this.idcompra = idcompra;
        this.iduser = iduser;
        this.idficha = idficha;
        this.precio_compra = precio_compra;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public int getIdficha() {
        return idficha;
    }

    public void setIdficha(int idficha) {
        this.idficha = idficha;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Timestamp getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Timestamp fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
