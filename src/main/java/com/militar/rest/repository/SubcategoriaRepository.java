package com.militar.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.militar.rest.modelo.ZTM_SUBCATEGORIA;


public interface SubcategoriaRepository extends JpaRepository<ZTM_SUBCATEGORIA, Integer> {

    List<ZTM_SUBCATEGORIA> findAllByIdcategoria(int idcategoria);

}
