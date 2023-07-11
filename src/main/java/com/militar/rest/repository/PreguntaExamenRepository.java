package com.militar.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.militar.rest.modelo.ZTT_PREGUNTA_EXAMEN;


public interface PreguntaExamenRepository extends JpaRepository<ZTT_PREGUNTA_EXAMEN, Integer> {
     
    ZTT_PREGUNTA_EXAMEN findByIdexamenAndIdpregunta(int lv_idexamen, int lv_idpregunta);
    List<ZTT_PREGUNTA_EXAMEN> findByIdexamen(int lv_idexamen);
    List<ZTT_PREGUNTA_EXAMEN> findByIdexamenAndRcorrectaFalse(int lv_idexamen);
}
