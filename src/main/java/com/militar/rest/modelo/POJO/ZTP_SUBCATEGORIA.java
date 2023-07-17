package com.militar.rest.modelo.POJO;

public class ZTP_SUBCATEGORIA {
	private int idcategoria;
	private String nombre_categoria;
	private int idsubcategoria;
	private String nombre_subcategoria;
	private String usuario_creacion;
	private String fecha_creacion;
	private String usuario_modificacion;
	private String fecha_modificacion;

    
    public ZTP_SUBCATEGORIA() {
    }

    public ZTP_SUBCATEGORIA(int idcategoria, String nombre_categoria, int idsubcategoria, String nombre_subcategoria,
            String usuario_creacion, String fecha_creacion, String usuario_modificacion, String fecha_modificacion) {
        this.idcategoria = idcategoria;
        this.nombre_categoria = nombre_categoria;
        this.idsubcategoria = idsubcategoria;
        this.nombre_subcategoria = nombre_subcategoria;
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

    public int getIdsubcategoria() {
        return idsubcategoria;
    }

    public void setIdsubcategoria(int idsubcategoria) {
        this.idsubcategoria = idsubcategoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }


    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }



    public String getNombre_subcategoria() {
        return nombre_subcategoria;
    }


    public void setNombre_subcategoria(String nombre_subcategoria) {
        this.nombre_subcategoria = nombre_subcategoria;
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
