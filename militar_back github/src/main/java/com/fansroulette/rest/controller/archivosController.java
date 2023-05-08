package com.fansroulette.rest.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fansroulette.rest.modelo.ZTT_USUARIO;
import com.fansroulette.rest.repository.UsuarioRepository;

@RestController
public class archivosController {
    
	@Autowired
	private UsuarioRepository li_usuario_rep;

    
    @CrossOrigin
    @PostMapping("/promocionar_creador")
    public ResponseEntity<?> promocionarCreador(@RequestParam("usuario") ZTT_USUARIO ls_datos,
                                                @RequestParam("archivos") List<MultipartFile> lt_archivos) {

        // Comprobamos si el usuario existe en la base de datos
        ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_datos.getIduser()).get();
        if (!ObjectUtils.isEmpty(ls_usuario)) {
            
            // Creamos la carpeta del usuario en el servidor
            String lv_rutaUsuario = "url/" + ls_usuario.getIduser() + "/imagenes";
            File lv_carpetaUsuario = new File(lv_rutaUsuario);
            if (!lv_carpetaUsuario.exists()) {
                lv_carpetaUsuario.mkdirs();
            }
            
            // Subimos los archivos a la carpeta del usuario en el servidor
            for (MultipartFile archivo : lt_archivos) {
                String rutaArchivo = lv_rutaUsuario + "/" + archivo.getOriginalFilename();
                try {
                    archivo.transferTo(new File(rutaArchivo));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Actualizamos el usuario en la base de datos
           /*  usuarioExistente.setEsCreador(true);
            usuarioRepository.save(usuarioExistente);*/
            
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
