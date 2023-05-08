package com.fansroulette.rest.modelo;

import java.util.Date;
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
	private int iduser;
	private String correo;
	private String contrasena;
	private int tipousuario;
	private String nombre;
	private String apellidos;
	private String nombre_completo;
	private Date ano_nacimiento;
	private String apodo;
	private String biografia;
	private String foto;
	private String banner;
	private boolean verificado;
	private Timestamp fecha_creacion;
	private Date ultimo_acceso;
	private String instagram;
	private int instagram_seguidores;
	private String twitter;
	private String onlyfans;
	private String tiktok;
	private String iban;
	
	public ZTT_USUARIO() {
		// TODO Auto-generated constructor stub
	}

	public ZTT_USUARIO(String correo, String contrasena, int tipousuario, String nombre, String apellidos,
			String nombre_completo, Date ano_nacimiento, String apodo, String biografia, String foto, String banner,
			boolean verificado, Timestamp fecha_creacion, Date ultimo_acceso, String instagram, int instagram_seguidores,
			String twitter, String onlyfans, String tiktok, String iban) {
		super();
		this.correo = correo;
		this.contrasena = contrasena;
		this.tipousuario = tipousuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombre_completo = nombre_completo;
		this.ano_nacimiento = ano_nacimiento;
		this.apodo = apodo;
		this.biografia = biografia;
		this.foto = foto;
		this.banner = banner;
		this.verificado = verificado;
		this.fecha_creacion = fecha_creacion;
		this.ultimo_acceso = ultimo_acceso;
		this.instagram = instagram;
		this.instagram_seguidores = instagram_seguidores;
		this.twitter = twitter;
		this.onlyfans = onlyfans;
		this.tiktok = tiktok;
		this.iban = iban;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
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

	public int getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(int tipousuario) {
		this.tipousuario = tipousuario;
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

	public Date getAno_nacimiento() {
		return ano_nacimiento;
	}

	public void setAno_nacimiento(Date ano_nacimiento) {
		this.ano_nacimiento = ano_nacimiento;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getUltimo_acceso() {
		return ultimo_acceso;
	}

	public void setUltimo_acceso(Date date) {
		this.ultimo_acceso = date;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public int getInstagram_seguidores() {
		return instagram_seguidores;
	}

	public void setInstagram_seguidores(int instagram_seguidores) {
		this.instagram_seguidores = instagram_seguidores;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getOnlyfans() {
		return onlyfans;
	}

	public void setOnlyfans(String onlyfans) {
		this.onlyfans = onlyfans;
	}

	public String getTiktok() {
		return tiktok;
	}

	public void setTiktok(String tiktok) {
		this.tiktok = tiktok;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}