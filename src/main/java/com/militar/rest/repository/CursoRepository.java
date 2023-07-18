package com.militar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.militar.rest.modelo.ZTM_CURSO;


public interface CursoRepository extends JpaRepository<ZTM_CURSO, Integer> {

    @Query(value = "SELECT * FROM ztm_curso p WHERE p.nombre_curso = :nombreCurso", nativeQuery = true)
    ZTM_CURSO obtenerNombrecurso(String nombreCurso );

}
