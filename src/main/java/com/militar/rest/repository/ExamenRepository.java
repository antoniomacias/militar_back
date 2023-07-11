package com.militar.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.militar.rest.modelo.ZTT_EXAMEN;


public interface ExamenRepository extends JpaRepository<ZTT_EXAMEN, Integer> {
    
    List<ZTT_EXAMEN> findByIduserAndTipoexamen(int iduser, int tipoexamen );

        @Query(value = "SELECT * FROM ZTT_EXAMEN p WHERE p.iduser = :iduser AND p.tipoexamen = :tipoexamen" +
    " AND p.preguntas_total != p.preguntas_acertadas", nativeQuery = true)
    List<ZTT_EXAMEN> testerrors(int iduser, int tipoexamen );
}
