package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztm_subcategoria")
public class ZTM_SUBCATEGORIA {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idsubcategoria;
	private int idcategoria;
	private String nombre;
	private String usuario_creacion;
	private String fecha_creacion;
	private String usuario_modificacion;
	private String fecha_modificacion;

    
    public ZTM_SUBCATEGORIA() {
    }

    public ZTM_SUBCATEGORIA(int idsubcategoria, int idcategoria, String nombre, String usuario_creacion,
            String fecha_creacion, String usuario_modificacion, String fecha_modificacion) {
        this.idsubcategoria = idsubcategoria;
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
        this.usuario_modificacion = usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getIdsubcategoria() {
        return idsubcategoria;
    }


    public void setIdsubcategoria(int idsubcategoria) {
        this.idsubcategoria = idsubcategoria;
    }


    public int getIdcategoria() {
        return idcategoria;
    }


    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getUsuario_creacion() {
        return usuario_creacion;
    }


    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }


    public String getFecha_creacion() {
        return fecha_creacion;
    }


    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }


    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }


    public String getFecha_modificacion() {
        return fecha_modificacion;
    }


    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

}
