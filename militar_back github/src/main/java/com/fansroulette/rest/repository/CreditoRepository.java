package com.fansroulette.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fansroulette.rest.modelo.ZTT_CREDITO;

public interface CreditoRepository extends JpaRepository<ZTT_CREDITO, Integer> {
    
    ZTT_CREDITO findByIdusuario(int lv_idusuario);
}
