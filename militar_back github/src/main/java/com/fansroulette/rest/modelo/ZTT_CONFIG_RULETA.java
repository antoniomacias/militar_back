package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_config_ruleta")
public class ZTT_CONFIG_RULETA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idconfig_ruleta;
	private int idruleta;
	private String titulo;
	private String tipo;
	private String url_adjunto;
	private Timestamp fecha_creacion;
	
	public ZTT_CONFIG_RULETA() {
		// TODO Auto-generated constructor stub
	}

	public ZTT_CONFIG_RULETA(int idconfig_ruleta, int idruleta, String titulo, String tipo, String url_adjunto,
			Timestamp fecha_creacion) {
		super();
		this.idconfig_ruleta = idconfig_ruleta;
		this.idruleta = idruleta;
		this.titulo = titulo;
		this.tipo = tipo;
		this.url_adjunto = url_adjunto;
		this.fecha_creacion = fecha_creacion;
	}


	public int getIdruleta() {
		return idruleta;
	}

	public void setIdruleta(int idruleta) {
		this.idruleta = idruleta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl_adjunto() {
		return url_adjunto;
	}

	public void setUrl_adjunto(String url_adjunto) {
		this.url_adjunto = url_adjunto;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getIdconfig_ruleta() {
		return idconfig_ruleta;
	}

	public void setIdconfig_ruleta(int idconfig_ruleta) {
		this.idconfig_ruleta = idconfig_ruleta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
