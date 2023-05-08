package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_tirada")
public class ZTT_TIRADA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtirada;
	private int idusuariotirada;
	private int idruleta;
	private int idconfigruleta;
	private Timestamp fecha_tirada;
	
	public ZTT_TIRADA() {
		// TODO Auto-generated constructor stub
	}
	
	public ZTT_TIRADA(int idtirada, int idruleta, int idusuario_tirada, int idconfigruleta, Timestamp fecha_tirada) {
		super();
		this.idtirada = idtirada;
		this.idruleta = idruleta;
		this.idusuariotirada = idusuario_tirada;
		this.idconfigruleta = idconfigruleta;
		this.fecha_tirada = fecha_tirada;
	}


	public int getIdtirada() {
		return idtirada;
	}

	public void setIdtirada(int idtirada) {
		this.idtirada = idtirada;
	}

	public Timestamp getFecha_tirada() {
		return fecha_tirada;
	}

	public void setFecha_tirada(Timestamp fecha_tirada) {
		this.fecha_tirada = fecha_tirada;
	}

	public int getIdusuariotirada() {
		return idusuariotirada;
	}

	public void setIdusuariotirada(int idusuariotirada) {
		this.idusuariotirada = idusuariotirada;
	}

	public int getIdconfigruleta() {
		return idconfigruleta;
	}

	public void setIdconfigruleta(int idconfigruleta) {
		this.idconfigruleta = idconfigruleta;
	}

	public int getIdruleta() {
		return idruleta;
	}

	public void setIdruleta(int idruleta) {
		this.idruleta = idruleta;
	}

}
