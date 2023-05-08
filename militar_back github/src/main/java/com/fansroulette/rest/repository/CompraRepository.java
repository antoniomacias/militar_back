package com.fansroulette.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fansroulette.rest.modelo.ZTT_COMPRA;

public interface CompraRepository extends JpaRepository<ZTT_COMPRA, Integer> {

    List<ZTT_COMPRA> findAllByIduser(int lv_iduser);
}
