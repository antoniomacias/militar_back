package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztm_categoria")
public class ZTM_CATEGORIA {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcategoria;
	private String nombre;
	private String tiempo_pregunta;
	private String usuario_creacion;
	private String fecha_creacion;
	private String usuario_modificacion;
	private String fecha_modificacion;

    
    public ZTM_CATEGORIA() {
    }

    public ZTM_CATEGORIA(int idcategoria, String nombre, String tiempo_pregunta, String usuario_creacion,
            String fecha_creacion, String usuario_modificacion, String fecha_modificacion) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
        this.tiempo_pregunta = tiempo_pregunta;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
        this.usuario_modificacion = usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
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
    public String getTiempo_pregunta() {
        return tiempo_pregunta;
    }
    public void setTiempo_pregunta(String tiempo_pregunta) {
        this.tiempo_pregunta = tiempo_pregunta;
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
