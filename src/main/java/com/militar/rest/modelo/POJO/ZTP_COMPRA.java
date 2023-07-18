package com.militar.rest.modelo.POJO;

public class ZTP_COMPRA {
    private int idcompra;
	private int iduser;
    private String nombre_completo;
	private int idcurso;
    private String nombre_curso;
	private String precio_compra;
	private String fecha_compra;

    
    public ZTP_COMPRA() {
    }

    public ZTP_COMPRA(int idcompra, int iduser, String nombre_completo, int idcurso, String nombre_curso,
            String precio_compra, String fecha_compra) {
        this.idcompra = idcompra;
        this.iduser = iduser;
        this.nombre_completo = nombre_completo;
        this.idcurso = idcurso;
        this.nombre_curso = nombre_curso;
        this.precio_compra = precio_compra;
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
    public String getNombre_completo() {
        return nombre_completo;
    }
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
    public int getIdcurso() {
        return idcurso;
    }
    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }
    public String getNombre_curso() {
        return nombre_curso;
    }
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }
    public String getPrecio_compra() {
        return precio_compra;
    }
    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }
    public String getFecha_compra() {
        return fecha_compra;
    }
    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    
}
