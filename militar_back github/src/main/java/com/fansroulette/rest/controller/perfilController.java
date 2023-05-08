package com.fansroulette.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fansroulette.rest.modelo.ZTP_PERFIL;
import com.fansroulette.rest.repository.UsuarioRepository;

@RestController
public class perfilController {
    @Autowired
    private usuarioController l_usuario;
    @Autowired
	private UsuarioRepository li_usuario_rep = null;

    //Búsqueda por ID de tabla
    @CrossOrigin
	@GetMapping("/perfil/{id}")
	ResponseEntity<?> obtenerPerfil(@PathVariable("id") int lv_id) {
        
        ZTP_PERFIL ls_listado = new ZTP_PERFIL();

        // Asignamos el usuario que se visualizará
        ls_listado.setUsuario(li_usuario_rep.findById(lv_id).get());
        // Recuperamos el resto de usuarios de la plataforma
        ls_listado.setListado_sugeridos(l_usuario.listadoUsuariosCreadores());

        // Eliminamos del listado al usuario que se visualiza
        ls_listado.getListado_sugeridos().removeIf(usuario -> usuario.getIduser() == ls_listado.getUsuario().getIduser());


		return ResponseEntity.ok(ls_listado);
	}
}
