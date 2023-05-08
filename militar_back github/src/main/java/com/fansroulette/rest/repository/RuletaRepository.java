package com.fansroulette.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fansroulette.rest.modelo.ZTT_RULETA;

public interface RuletaRepository extends JpaRepository<ZTT_RULETA, Integer> {
    
    List<ZTT_RULETA> findAllByIduser(int lv_idusuario);
}
