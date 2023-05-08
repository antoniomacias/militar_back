package com.fansroulette.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fansroulette.rest.modelo.ZTT_USUARIO;

public interface UsuarioRepository extends JpaRepository<ZTT_USUARIO, Integer> {

    ZTT_USUARIO findByCorreo(String lv_correo);
    ZTT_USUARIO findByApodo(String lv_apodo);
    List<ZTT_USUARIO> findAllByTipousuario(int lv_tipo_usuario);
    List<ZTT_USUARIO> findByTipousuarioAndVerificadoFalse(int tipousuario);

}
