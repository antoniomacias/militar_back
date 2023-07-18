package com.militar.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.militar.rest.modelo.ZTT_COMPRA;
import com.militar.rest.modelo.POJO.ZTP_COMPRA;


public interface CompraRepository extends JpaRepository<ZTT_COMPRA, Integer> {

    @Query(value = "SELECT p.idcompra, p.iduser, u.nombre_completo. p.idcurso, s.nombre_curso, p.precio_compra, p.fecha_compra"+
      "FROM ZTT_COMPRA p INNER JOIN ZTM_CURSO s ON p.idcurso = s.idcurso INNER JOIN ZTT_USER u ON p.iduser = u.iduser", nativeQuery = true)
    List<ZTP_COMPRA> obtenerCompras();

    @Query(value = "SELECT p.idcompra, p.iduser, u.nombre_completo. p.idcurso, s.nombre_curso, p.precio_compra, p.fecha_compra"+
      "FROM ZTT_COMPRA p INNER JOIN ZTM_CURSO s ON p.idcurso = s.idcurso INNER JOIN ZTT_USER u ON p.iduser = u.iduser WHERE p.idcompra = :idCompra)", nativeQuery = true)
    ZTP_COMPRA obtenerCompra(Integer idCompra);
}
