package com.militar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.militar.rest.modelo.ZTM_CURSO;


public interface CursoRepository extends JpaRepository<ZTM_CURSO, Integer> {

    
    ZTM_CURSO findByNombre(String lv_nombre);
}
