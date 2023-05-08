package com.fansroulette.rest.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ztt_credito")
public class ZTT_CREDITO {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcredito;
	private int idusuario;
    private int num_fichas;

    
    public ZTT_CREDITO() {
    }
    
    public ZTT_CREDITO(int idcredito, int idusuario, int num_fichas) {
        this.idcredito = idcredito;
        this.idusuario = idusuario;
        this.num_fichas = num_fichas;
    }

    public ZTT_CREDITO(int idusuario, int num_fichas) {
        this.idusuario = idusuario;
        this.num_fichas = num_fichas;
    }

    public int getIdcredito() {
        return idcredito;
    }
    
    public void setIdcredito(int idcredito) {
        this.idcredito = idcredito;
    }

    public int getNum_fichas() {
        return num_fichas;
    }

    public void setNum_fichas(int num_fichas) {
        this.num_fichas = num_fichas;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
