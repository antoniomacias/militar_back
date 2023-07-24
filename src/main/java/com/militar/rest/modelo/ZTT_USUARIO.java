package com.militar.rest.modelo;

import java.sql.Timestamp;
import java.util.Date;

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
	private int iduser;
	private String correo;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String nombre_completo;
	private String ano_nacimiento;
	private int telefono;
	private String direccion;
	private String apodo;
	private String foto;
	private String genero;
	private String fecha_creacion;
	private Date ultimo_acceso;
	private String discord;
	

	public ZTT_USUARIO() {
		// TODO Auto-generated constructor stub
	}

	public ZTT_USUARIO(int iduser, String correo, String contrasena, String nombre, String apellidos,
			String nombre_completo, String ano_nacimiento, int telefono, String direccion, String apodo, String foto,
			String genero, String fecha_creacion, Date ultimo_acceso, String discord) {
		this.iduser = iduser;
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_completo = nombre_completo;
		this.ano_nacimiento = ano_nacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.apodo = apodo;
		this.foto = foto;
		this.genero = genero;
		this.fecha_creacion = fecha_creacion;
		this.ultimo_acceso = ultimo_acceso;
		this.discord = discord;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Date getUltimo_acceso() {
		return ultimo_acceso;
	}

	public void setUltimo_acceso(Date ultimo_acceso) {
		this.ultimo_acceso = ultimo_acceso;
	}

	public String getDiscord() {
		return discord;
	}

	public void setDiscord(String discord) {
		this.discord = discord;
	}


	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	
}
