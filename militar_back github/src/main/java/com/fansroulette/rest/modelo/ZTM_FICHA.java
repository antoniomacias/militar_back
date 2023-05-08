package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztm_ficha")
public class ZTM_FICHA {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idficha;
	private int cantidad;
	private float precio;
	private int porcentaje_tr;
	private Timestamp fecha_inicio;
	private Timestamp fecha_fin;
	private Timestamp fecha_creacion;
	private String usuario_creacion;
	
	public ZTM_FICHA() {
		// TODO Auto-generated constructor stub
	}

	public ZTM_FICHA(int idficha, int cantidad, float precio, int porcentaje_tr, Timestamp fecha_inicio,
			Timestamp fecha_fin, Timestamp fecha_creacion, String usuario_creacion) {
		this.idficha = idficha;
		this.cantidad = cantidad;
		this.precio = precio;
		this.porcentaje_tr = porcentaje_tr;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_creacion = fecha_creacion;
		this.usuario_creacion = usuario_creacion;
	}


	public Timestamp getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(Timestamp fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public Timestamp getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(Timestamp fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public int getIdficha() {
		return idficha;
	}

	public void setIdficha(int idficha) {
		this.idficha = idficha;
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

	public int getPorcentaje_tr() {
		return porcentaje_tr;
	}

	public void setPorcentaje_tr(int porcentaje_tr) {
		this.porcentaje_tr = porcentaje_tr;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}
	
}
