package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_ruleta")
public class ZTT_RULETA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idruleta;
	private int iduser;
	private String nombre;
	private int cantidad_fichas;
	private String usuario_creacion;
	private Timestamp fecha_creacion;
	
	public ZTT_RULETA() {
		// TODO Auto-generated constructor stub
	}

	public ZTT_RULETA(int idruleta, int iduser, String nombre, int cantidad_fichas, String usuario_creacion,
			Timestamp fecha_creacion) {
		this.idruleta = idruleta;
		this.iduser = iduser;
		this.nombre = nombre;
		this.cantidad_fichas = cantidad_fichas;
		this.usuario_creacion = usuario_creacion;
		this.fecha_creacion = fecha_creacion;
	}


	public int getIdruleta() {
		return idruleta;
	}

	public void setIdruleta(int idruleta) {
		this.idruleta = idruleta;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad_fichas() {
		return cantidad_fichas;
	}

	public void setCantidad_fichas(int cantidad_fichas) {
		this.cantidad_fichas = cantidad_fichas;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	
}
