package com.militar.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.militar.rest.modelo.ZTT_USUARIO;


public interface UsuarioRepository extends JpaRepository<ZTT_USUARIO, Integer> {

}
