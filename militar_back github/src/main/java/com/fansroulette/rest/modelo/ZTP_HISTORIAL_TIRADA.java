package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

public class ZTP_HISTORIAL_TIRADA {
    private int idtirada;
    private int idusuario_creador;  //Usuario creador.
    private String nombre_completo_creador;
    private String apodo_creador;
    private String foto_creador;
    private String titulo;
    private String url_adjunto;
	private Timestamp fecha_tirada;

    
    public ZTP_HISTORIAL_TIRADA() {
    }

    public ZTP_HISTORIAL_TIRADA(int idtirada, int idusuario_creador, String nombre_completo_creador, String apodo_creador,
    String foto_creador, String titulo, String url_adjunto, Timestamp fecha_tirada) {
        this.idtirada = idtirada;
        this.idusuario_creador = idusuario_creador;
        this.nombre_completo_creador = nombre_completo_creador;
        this.apodo_creador = apodo_creador;
        this.foto_creador = foto_creador;
        this.titulo = titulo;
        this.url_adjunto = url_adjunto;
        this.fecha_tirada = fecha_tirada;
    }

    public int getIdtirada() {
        return idtirada;
    }

    public void setIdtirada(int idtirada) {
        this.idtirada = idtirada;
    }

    public int getIdusuario_creador() {
        return idusuario_creador;
    }

    public void setIdusuario_creador(int idusuario_creador) {
        this.idusuario_creador = idusuario_creador;
    }

    public String getNombre_completo_creador() {
        return nombre_completo_creador;
    }

    public void setNombre_completo_creador(String nombre_completo_creador) {
        this.nombre_completo_creador = nombre_completo_creador;
    }

    public String getApodo_creador() {
        return apodo_creador;
    }

    public void setApodo_creador(String apodo_creador) {
        this.apodo_creador = apodo_creador;
    }

    public String getFoto_creador() {
        return foto_creador;
    }

    public void setFoto_creador(String foto_creador) {
        this.foto_creador = foto_creador;
    }

    public Timestamp getFecha_tirada() {
        return fecha_tirada;
    }

    public void setFecha_tirada(Timestamp fecha_tirada) {
        this.fecha_tirada = fecha_tirada;
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
    
}
