package com.militar.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztm_parametrizacion")
public class ZTM_PARAMETRIZACION {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idparametrizacion;
    private int idcategoria;
    private String tiempo;

    
    public ZTM_PARAMETRIZACION() {
    }

    
    public ZTM_PARAMETRIZACION(int idparametrizacion, int idcategoria, String tiempo) {
        this.idparametrizacion = idparametrizacion;
        this.idcategoria = idcategoria;
        this.tiempo = tiempo;
    }

    public int getIdparametrizacion() {
        return idparametrizacion;
    }

    public void setIdparametrizacion(int idparametrizacion) {
        this.idparametrizacion = idparametrizacion;
    }
    
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
    
