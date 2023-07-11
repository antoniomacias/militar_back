package com.militar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.militar.rest.modelo.ZTM_CATEGORIA;


public interface CategoriaRepository extends JpaRepository<ZTM_CATEGORIA, Integer> {

    ZTM_CATEGORIA findByNombre(String lv_nombre);
}
