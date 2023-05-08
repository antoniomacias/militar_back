package com.fansroulette.rest.modelo;

import java.util.List;

public class ZTP_PERFIL {
    
    ZTT_USUARIO usuario;
    List<ZTT_USUARIO> listado_sugeridos;

    public ZTP_PERFIL() {
    }

    public ZTP_PERFIL(ZTT_USUARIO usuario, List<ZTT_USUARIO> listado_sugeridos) {
        this.usuario = usuario;
        this.listado_sugeridos = listado_sugeridos;
    }

    public ZTT_USUARIO getUsuario() {
        return usuario;
    }
    public void setUsuario(ZTT_USUARIO usuario) {
        this.usuario = usuario;
    }
    public List<ZTT_USUARIO> getListado_sugeridos() {
        return listado_sugeridos;
    }
    public void setListado_sugeridos(List<ZTT_USUARIO> listado_sugeridos) {
        this.listado_sugeridos = listado_sugeridos;
    }
}
