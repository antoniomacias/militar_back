package com.fansroulette.rest.modelo;

import java.util.List;

public class ZTP_HOME {
    
    List<ZTT_USUARIO> listado_usuarios;
    List<ZTT_USUARIO> listado_sugeridos;

    public ZTP_HOME() {
    }

    public ZTP_HOME(List<ZTT_USUARIO> listado_usuarios, List<ZTT_USUARIO> listado_sugeridos) {
        this.listado_usuarios = listado_usuarios;
        this.listado_sugeridos = listado_sugeridos;
    }

    public List<ZTT_USUARIO> getListado_usuarios() {
        return listado_usuarios;
    }
    public void setListado_usuarios(List<ZTT_USUARIO> listado_usuarios) {
        this.listado_usuarios = listado_usuarios;
    }
    public List<ZTT_USUARIO> getListado_sugeridos() {
        return listado_sugeridos;
    }
    public void setListado_sugeridos(List<ZTT_USUARIO> listado_sugeridos) {
        this.listado_sugeridos = listado_sugeridos;
    }
}
