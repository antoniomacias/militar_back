package com.militar.rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.militar.rest.modelo.ZTT_PREGUNTA;
import com.militar.rest.modelo.ZTT_PREGUNTA_EXAMEN;


public interface PreguntaRepository extends JpaRepository<ZTT_PREGUNTA, Integer> {
    @Query(value = "SELECT * FROM ZTT_PREGUNTA ORDER BY RAND() LIMIT 15", nativeQuery = true)
    List<ZTT_PREGUNTA> obtenerPreguntasAleatorias();

    @Query(value = "SELECT p.idpregunta, p.idsubcategoria, p.identificador, p.ejemplo, p.orden, p.pregunta, p.rcorrecta, p.rfalsa1, p.rfalsa2, p.rfalsa3, p.foto, " +
    "p.descripcion_respuesta, p.foto_respuesta,  p.usuario_creacion, p.fecha_creacion, p.usuario_modificacion, p.fecha_modificacion  FROM ZTT_PREGUNTA p " +
    "INNER JOIN ZTM_SUBCATEGORIA s ON p.idsubcategoria = s.idsubcategoria " +
    "INNER JOIN ZTM_CATEGORIA c ON s.idcategoria = c.idcategoria " +
    "WHERE c.idcategoria = :idCategoria " +
    "ORDER BY RAND() LIMIT 15", nativeQuery = true)
    List<ZTT_PREGUNTA> obtenerPreguntasAleatoriasCategoria(@Param("idCategoria") int idCategoria);

    @Query(value = "SELECT p.idpregunta, p.idsubcategoria, p.identificador, p.ejemplo, p.orden, p.pregunta, p.rcorrecta, p.rfalsa1, p.rfalsa2, p.rfalsa3, p.foto, " +
    "p.descripcion_respuesta, p.foto_respuesta,  p.usuario_creacion, p.fecha_creacion, p.usuario_modificacion, p.fecha_modificacion  FROM ZTT_PREGUNTA p " +
    "INNER JOIN ZTM_SUBCATEGORIA s ON p.idsubcategoria = s.idsubcategoria " +
    "INNER JOIN ZTM_CATEGORIA c ON s.idcategoria = c.idcategoria " +
    "WHERE c.idcategoria = :idCategoria " +
    "ORDER BY RAND() LIMIT 1", nativeQuery = true)
    ZTT_PREGUNTA obtenerPreguntaAleatoriasCategoria(@Param("idCategoria") int idCategoria);

    @Query(value = "SELECT p.idpregunta, p.idsubcategoria, p.identificador, p.ejemplo, p.orden, p.pregunta, p.rcorrecta, p.rfalsa1, p.rfalsa2, p.rfalsa3, p.foto, " +
    "p.descripcion_respuesta, p.foto_respuesta,  p.usuario_creacion, p.fecha_creacion, p.usuario_modificacion, p.fecha_modificacion  FROM ZTT_PREGUNTA p " +
    "INNER JOIN ZTM_SUBCATEGORIA s ON p.idsubcategoria = s.idsubcategoria " +
    "WHERE s.idsubcategoria = :idSubcategoria " +
    "ORDER BY RAND() LIMIT 15", nativeQuery = true)
    List<ZTT_PREGUNTA> obtenerPreguntasAleatoriasSubcategoria(@Param("idSubcategoria") int idSubcategoria);

}
