package com.fansroulette.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fansroulette.rest.modelo.ZTP_HOME;
import com.fansroulette.rest.modelo.ZTT_USUARIO;

@RestController
public class homeController {

	@Autowired
    private usuarioController l_usuario;


    //Búsqueda de listado de usuarios
	@CrossOrigin
	@GetMapping("/inicio")
	ResponseEntity<?> inicio() {

        ZTP_HOME ls_listado = new ZTP_HOME();
		List<ZTT_USUARIO> ls_usuarios = new ArrayList<>();

        ls_usuarios = l_usuario.listadoUsuariosCreadores();
		
		// Nos quedamos con los tres primeros registros y añadir el resto a la nueva lista
		ls_listado.setListado_sugeridos(ls_usuarios.subList(0, Math.min(ls_usuarios.size(), 3)));
		// Añadimos el resto
		
		if (ls_usuarios.size() >= 3) {
        	ls_listado.setListado_usuarios(ls_usuarios.subList(3, ls_usuarios.size()));
		}


		return ResponseEntity.ok(ls_listado);
	}
}
