package com.militar.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.militar.rest.modelo.ZTM_SUBCATEGORIA;
import com.militar.rest.modelo.POJO.ZTP_SUBCATEGORIA;


public interface SubcategoriaRepository extends JpaRepository<ZTM_SUBCATEGORIA, Integer> {

    List<ZTM_SUBCATEGORIA> findAllByIdcategoria(int idcategoria);

    ZTM_SUBCATEGORIA findByNombre(String lv_nombre);

    @Query("SELECT s.idcategoria, s.nombre, p.idsubcategoria, p.nombre, p.usuario_creacion, p.fecha_creacion, p.usuario_modificacion, p.fecha_modificacion"+
      "FROM ZTM_SUBCATEGORIA p INNER JOIN ZTM_CATEGORIA s ON p.idcategoria = s.idcategoria ")
    List<ZTP_SUBCATEGORIA> obtenerSubcategorias();

        @Query("SELECT s.idcategoria, s.nombre, p.idsubcategoria, p.nombre, p.usuario_creacion, p.fecha_creacion, p.usuario_modificacion, p.fecha_modificacion"+
      "FROM ZTM_SUBCATEGORIA p INNER JOIN ZTM_CATEGORIA s ON p.idcategoria = s.idcategoria WHERE s.idsubcategoria = :idSubcategoria")
    ZTP_SUBCATEGORIA obtenerSubcategoriasId(@Param("idSubcategoria") Integer lv_idsubcategoria);

            @Query("SELECT s.idcategoria, s.nombre, p.idsubcategoria, p.nombre, p.usuario_creacion, p.fecha_creacion, p.usuario_modificacion, p.fecha_modificacion"+
      "FROM ZTM_SUBCATEGORIA p INNER JOIN ZTM_CATEGORIA s ON p.idcategoria = s.idcategoria WHERE s.nombre = :nameSubcategoria")
    ZTP_SUBCATEGORIA obtenerSubcategoriasName(@Param("nameSubcategoria") String lv_name_subcategoria);

}
