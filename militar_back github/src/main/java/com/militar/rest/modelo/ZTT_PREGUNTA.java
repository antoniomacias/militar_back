package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_pregunta")
public class ZTT_PREGUNTA {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpregunta;
	private int idsubcategoria;
    private int identificador;
    private boolean ejemplo;
    private int orden;
    private String pregunta;
    private String rcorrecta;
    private String rfalsa1;
    private String rfalsa2;
    private String rfalsa3;
    private String foto;
    private String descripcion_respuesta;
    private String foto_respuesta;
	private String usuario_creacion;
	private String fecha_creacion;
	private String usuario_modificacion;
	private String fecha_modificacion;

    
    public ZTT_PREGUNTA() {
    }

    public ZTT_PREGUNTA(int idpregunta, int idsubcategoria, int identificador, boolean ejemplo, int orden,
            String pregunta, String rcorrecta, String rfalsa1, String rfalsa2, String rfalsa3, String foto,
            String descripcion_respuesta, String foto_respuesta, String usuario_creacion, String fecha_creacion,
            String usuario_modificacion, String fecha_modificacion) {
        this.idpregunta = idpregunta;
        this.idsubcategoria = idsubcategoria;
        this.identificador = identificador;
        this.ejemplo = ejemplo;
        this.orden = orden;
        this.pregunta = pregunta;
        this.rcorrecta = rcorrecta;
        this.rfalsa1 = rfalsa1;
        this.rfalsa2 = rfalsa2;
        this.rfalsa3 = rfalsa3;
        this.foto = foto;
        this.descripcion_respuesta = descripcion_respuesta;
        this.foto_respuesta = foto_respuesta;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
        this.usuario_modificacion = usuario_modificacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getIdpregunta() {
        return idpregunta;
    }
    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }
    public int getIdsubcategoria() {
        return idsubcategoria;
    }
    public void setIdsubcategoria(int idsubcategoria) {
        this.idsubcategoria = idsubcategoria;
    }
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public boolean isEjemplo() {
        return ejemplo;
    }
    public void setEjemplo(boolean ejemplo) {
        this.ejemplo = ejemplo;
    }
    public int getOrden() {
        return orden;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public String getRcorrecta() {
        return rcorrecta;
    }
    public void setRcorrecta(String rcorrecta) {
        this.rcorrecta = rcorrecta;
    }
    public String getRfalsa1() {
        return rfalsa1;
    }
    public void setRfalsa1(String rfalsa1) {
        this.rfalsa1 = rfalsa1;
    }
    public String getRfalsa2() {
        return rfalsa2;
    }
    public void setRfalsa2(String rfalsa2) {
        this.rfalsa2 = rfalsa2;
    }
    public String getRfalsa3() {
        return rfalsa3;
    }
    public void setRfalsa3(String rfalsa3) {
        this.rfalsa3 = rfalsa3;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getDescripcion_respuesta() {
        return descripcion_respuesta;
    }
    public void setDescripcion_respuesta(String descripcion_respuesta) {
        this.descripcion_respuesta = descripcion_respuesta;
    }
    public String getFoto_respuesta() {
        return foto_respuesta;
    }
    public void setFoto_respuesta(String foto_respuesta) {
        this.foto_respuesta = foto_respuesta;
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
