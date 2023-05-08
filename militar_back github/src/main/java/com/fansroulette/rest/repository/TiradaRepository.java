package com.fansroulette.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fansroulette.rest.modelo.ZTT_TIRADA;

public interface TiradaRepository extends JpaRepository<ZTT_TIRADA, Integer> {

    List<ZTT_TIRADA> findAllByIdusuariotirada(int lv_idusuario);
    List<ZTT_TIRADA> findAllByIdruleta(int lv_idruleta);
    ZTT_TIRADA findByIdusuariotiradaAndIdconfigruleta(int idusuarioruleta, int idconfigruleta);

}