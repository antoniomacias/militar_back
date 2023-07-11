package com.militar.rest.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_usuario")
public class ZTT_USUARIO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idficha;
	private String correo;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String nombre_completo;
	private String ano_nacimiento;
	private String apodo;
	private String foto;
	private String fecha_creacion;
	private String ultimo_acceso;
	private String discord;
	
	public ZTT_USUARIO() {
		// TODO Auto-generated constructor stub
	}

	public ZTT_USUARIO(int idficha, String correo, String contrasena, String nombre, String apellidos,
			String nombre_completo, String ano_nacimiento, String apodo, String foto, String fecha_creacion,
			String ultimo_acceso, String discord) {
		this.idficha = idficha;
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_completo = nombre_completo;
		this.ano_nacimiento = ano_nacimiento;
		this.apodo = apodo;
		this.foto = foto;
		this.fecha_creacion = fecha_creacion;
		this.ultimo_acceso = ultimo_acceso;
		this.discord = discord;
	}



	public int getIdficha() {
		return idficha;
	}

	public void setIdficha(int idficha) {
		this.idficha = idficha;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getAno_nacimiento() {
		return ano_nacimiento;
	}

	public void setAno_nacimiento(String ano_nacimiento) {
		this.ano_nacimiento = ano_nacimiento;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getUltimo_acceso() {
		return ultimo_acceso;
	}

	public void setUltimo_acceso(String ultimo_acceso) {
		this.ultimo_acceso = ultimo_acceso;
	}

	public String getDiscord() {
		return discord;
	}

	public void setDiscord(String discord) {
		this.discord = discord;
	}

	
}
