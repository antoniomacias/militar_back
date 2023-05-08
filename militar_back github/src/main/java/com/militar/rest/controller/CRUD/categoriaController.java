package com.militar.rest.controller.CRUD;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.militar.rest.modelo.ZTM_CATEGORIA;
import com.militar.rest.repository.CategoriaRepository;


@RestController
public class categoriaController {
    
	@Autowired
	private CategoriaRepository li_categoria_rep;

    //Recuperar una categoria por ID
    @CrossOrigin
    @PostMapping("/get_categoria_id")
    public ResponseEntity<?> getCategoriaId(@RequestParam("idcategoria") int lv_categoria) {

        // Estructuras
        ZTM_CATEGORIA ls_categoria = new ZTM_CATEGORIA();

        //Buscamos categoria
        ls_categoria = li_categoria_rep.findById(lv_categoria).get();

        if (!ObjectUtils.isEmpty(ls_categoria)) {
            return ResponseEntity.ok(ls_categoria);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Recuperar una categoria por Nombre
    @CrossOrigin
    @PostMapping("/get_categoria_nombre")
    public ResponseEntity<?> getCategoriaNombre(@RequestParam("nombre_categoria") String lv_nombre_categoria) {

        // Estructuras
        ZTM_CATEGORIA ls_categoria = new ZTM_CATEGORIA();

        //Buscamos categoria
        ls_categoria = li_categoria_rep.findByNombre(lv_nombre_categoria);

        if (!ObjectUtils.isEmpty(ls_categoria)) {
            return ResponseEntity.ok(ls_categoria);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Recuperar todas las categorias
    @CrossOrigin
    @GetMapping("/get_categorias")
    public ResponseEntity<?> getCategorias() {

        // Estructuras
        List<ZTM_CATEGORIA> lt_categoria = new ArrayList<>();

        //Buscamos categoria
        lt_categoria = li_categoria_rep.findAll();

        if (!ObjectUtils.isEmpty(lt_categoria)) {
            return ResponseEntity.ok(lt_categoria);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Crear una nueva categoria
    @CrossOrigin
    @PostMapping("/create_categoria")
    public ResponseEntity<?> createCategoria(@RequestBody ZTM_CATEGORIA ls_nueva_categoria) {

        // Estructuras
        ZTM_CATEGORIA ls_categoria = new ZTM_CATEGORIA();

        //Buscamos categoria
        ls_categoria = li_categoria_rep.findByNombre(ls_nueva_categoria.getNombre());
        if (!ObjectUtils.isEmpty(ls_categoria)) {
            li_categoria_rep.save(ls_nueva_categoria);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El nombre de la categoria ya existe");
        }
    }

    //Editar una categoria

    //Eliminar una categoria
    @CrossOrigin
    @PostMapping("/delete_categoria")
    public ResponseEntity<?> deleteCategoria(@RequestParam("idcategoria") int lv_categoria) {

        // Estructuras
        ZTM_CATEGORIA ls_categoria = new ZTM_CATEGORIA();

        //Buscamos categoria
        ls_categoria = li_categoria_rep.findById(lv_categoria).get();
        if (!ObjectUtils.isEmpty(ls_categoria)) {
            li_categoria_rep.deleteById(lv_categoria);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    
}
