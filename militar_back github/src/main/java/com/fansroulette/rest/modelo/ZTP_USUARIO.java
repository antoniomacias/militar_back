package com.fansroulette.rest.modelo;

public class ZTP_USUARIO {
    
    private ZTT_USUARIO ls_usuario;
    private int lv_creditos;


    public ZTP_USUARIO() {
    }

    public ZTP_USUARIO(ZTT_USUARIO ls_usuario, int lv_creditos) {
        this.ls_usuario = ls_usuario;
        this.lv_creditos = lv_creditos;
    }

    public ZTT_USUARIO getLs_usuario() {
        return ls_usuario;
    }

    public void setLs_usuario(ZTT_USUARIO ls_usuario) {
        this.ls_usuario = ls_usuario;
    }

    public int getLv_creditos() {
        return lv_creditos;
    }

    public void setLv_creditos(int lv_creditos) {
        this.lv_creditos = lv_creditos;
    }
}
