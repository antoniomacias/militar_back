package com.fansroulette.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fansroulette.rest.modelo.ZTT_CONFIG_RULETA;

public interface ConfigRuletaRepository extends JpaRepository<ZTT_CONFIG_RULETA, Integer> {
    
    List<ZTT_CONFIG_RULETA> findAllByIdruleta(int lv_idruleta);
}
