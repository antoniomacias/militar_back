package com.fansroulette.rest.modelo;

import java.sql.Timestamp;

public class ZTP_HISTORIAL_TIRADA_CREADOR {
    private int idtirada;
    private int idusuario;  //Usuario normal.
    private String nombre_completo_creador;
    private String apodo_creador;
    private int idusuarioruleta;
    private String titulo_ruleta;
	private Timestamp fecha_tirada;

    
    public ZTP_HISTORIAL_TIRADA_CREADOR() {
    }

    public ZTP_HISTORIAL_TIRADA_CREADOR(int idtirada, int idusuario, String nombre_completo_creador,
            String apodo_creador, int idusuarioruleta, String titulo_ruleta, Timestamp fecha_tirada) {
        this.idtirada = idtirada;
        this.idusuario = idusuario;
        this.nombre_completo_creador = nombre_completo_creador;
        this.apodo_creador = apodo_creador;
        this.idusuarioruleta = idusuarioruleta;
        this.titulo_ruleta = titulo_ruleta;
        this.fecha_tirada = fecha_tirada;
    }

    public int getIdtirada() {
        return idtirada;
    }
    
    public void setIdtirada(int idtirada) {
        this.idtirada = idtirada;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public int getIdusuarioruleta() {
        return idusuarioruleta;
    }

    public void setIdusuarioruleta(int idusuarioruleta) {
        this.idusuarioruleta = idusuarioruleta;
    }

    public String getTitulo_ruleta() {
        return titulo_ruleta;
    }

    public void setTitulo_ruleta(String titulo_ruleta) {
        this.titulo_ruleta = titulo_ruleta;
    }

    public Timestamp getFecha_tirada() {
        return fecha_tirada;
    }

    public void setFecha_tirada(Timestamp fecha_tirada) {
        this.fecha_tirada = fecha_tirada;
    }
}
