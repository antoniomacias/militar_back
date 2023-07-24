package com.militar.rest.modelo.POJO;

import com.militar.rest.modelo.ZTT_USUARIO;

public class ZTP_USUARIO {
    private ZTT_USUARIO ls_usuario;

    public ZTT_USUARIO getLs_usuario() {
        return ls_usuario;
    }


    public ZTP_USUARIO() {
    }

    public ZTP_USUARIO(ZTT_USUARIO ls_usuario) {
        this.ls_usuario = ls_usuario;
    }

    public void setLs_usuario(ZTT_USUARIO ls_usuario) {
        this.ls_usuario = ls_usuario;
    }
}
