package com.militar.rest.controller.CRUD;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.militar.rest.modelo.ZTT_USUARIO;
import com.militar.rest.modelo.POJO.ZTP_USUARIO;
import com.militar.rest.modelo.TIPADOS.ZTP_INT;
import com.militar.rest.repository.UsuarioRepository;

@RestController
public class usuarioController {
    @Autowired
	private UsuarioRepository li_usuario_rep;

    //Recuperar todos los usuarios
    @CrossOrigin
    @GetMapping("/get_users")
    public ResponseEntity<?> getUsers() {

        // Estructuras
        List<ZTT_USUARIO> lt_usuarios = new ArrayList<>();

        //Buscamos usuarios
        lt_usuarios = li_usuario_rep.findAll();

        if (!ObjectUtils.isEmpty(lt_usuarios)) {
            return ResponseEntity.ok(lt_usuarios);
        }else{return ResponseEntity.badRequest().build();}
    }

    //Recuperar usuario
    @CrossOrigin
    @PostMapping("/get_user")
    public ResponseEntity<?> getUser(@RequestParam("iduser") int lv_iduser) {

        // Estructuras
        ZTP_USUARIO ls_datos = new ZTP_USUARIO();
        ZTT_USUARIO ls_usuario = new ZTT_USUARIO();

        //Buscamos categoria
        ls_usuario = li_usuario_rep.findById(lv_iduser).get();

        if (!ObjectUtils.isEmpty(ls_usuario)) {
            ls_datos.setLs_usuario(ls_usuario);
            return ResponseEntity.ok(ls_datos);
        }else{return ResponseEntity.badRequest().build();}
    }

    //Eliminar un usuario
    @CrossOrigin
    @PostMapping("/delete_user")
    public ResponseEntity<?> deleteUser(@RequestBody ZTP_INT ls_valor) {

        // Estructuras
        List<ZTT_USUARIO> lt_usuarios = new ArrayList<>();
        ZTT_USUARIO ls_usuario = new ZTT_USUARIO();


        //Buscamos usuario
        ls_usuario = li_usuario_rep.findById(ls_valor.getValor1()).get();
        if (!ObjectUtils.isEmpty(ls_usuario)) {
            li_usuario_rep.deleteById(ls_valor.getValor1());
            
            //Buscamos usuarios
            lt_usuarios = li_usuario_rep.findAll();

            if (!ObjectUtils.isEmpty(lt_usuarios)) {
                return ResponseEntity.ok(lt_usuarios);
            }else{return ResponseEntity.badRequest().build();}
        }else{return ResponseEntity.badRequest().build();}
    }
}
