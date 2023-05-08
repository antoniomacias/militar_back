package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_compra")
public class ZTT_COMPRA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcompra;
	private int iduser;
	private int idficha;
	private Timestamp fecha_compra;
	
	public ZTT_COMPRA() {
		// TODO Auto-generated constructor stub
	}

	public ZTT_COMPRA(int idcompra, int iduser, int idficha, Timestamp fecha_compra) {
		super();
		this.idcompra = idcompra;
		this.iduser = iduser;
		this.idficha = idficha;
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

	public int getIdficha() {
		return idficha;
	}

	public void setIdficha(int idficha) {
		this.idficha = idficha;
	}

	public Timestamp getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Timestamp fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	
}
