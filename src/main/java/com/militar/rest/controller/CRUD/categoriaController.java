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
import com.militar.rest.modelo.ZTM_SUBCATEGORIA;
import com.militar.rest.modelo.POJO.ZTP_CATEGORIA;
import com.militar.rest.modelo.POJO.ZTP_SUBCATEGORIA;
import com.militar.rest.repository.CategoriaRepository;
import com.militar.rest.repository.SubcategoriaRepository;


@RestController
public class categoriaController {
    
	@Autowired
	private CategoriaRepository li_categoria_rep;
	@Autowired
	private SubcategoriaRepository li_subcategoria_rep;


////////////////////////////////////////////////////////////////////////////////////////////////

    // Recuperamos categorias y subcategorias
    @CrossOrigin
    @GetMapping("/getCategories")
    public ResponseEntity<?> getCategories() {

        // Estructuras
        List<ZTP_CATEGORIA> lt_datos = new ArrayList<>();
        List<ZTP_SUBCATEGORIA> lt_subcategoria_aux = new ArrayList<>();
        ZTP_CATEGORIA ls_datos = new ZTP_CATEGORIA();
        List<ZTM_CATEGORIA> lt_categoria = new ArrayList<>();
        List<ZTM_SUBCATEGORIA> lt_subcategoria = new ArrayList<>();
        


        //Buscamos categorias
        lt_categoria = li_categoria_rep.findAll();
        if (!ObjectUtils.isEmpty(lt_categoria)) {

            //  Recorremos todas las categorias
            for (ZTM_CATEGORIA ls_categoria : lt_categoria) {
                ls_datos = new ZTP_CATEGORIA();
                ls_datos.setIdcategory(ls_categoria.getIdcategoria());
                ls_datos.setCategory(ls_categoria.getNombre());

                //  Buscamos todas las subcategorias
                lt_subcategoria = new ArrayList<>();
                lt_subcategoria_aux = new ArrayList<>();
                
                lt_subcategoria = li_subcategoria_rep.findAllByIdcategoria(ls_categoria.getIdcategoria());
                if (!ObjectUtils.isEmpty(lt_subcategoria)) {

                    for (ZTM_SUBCATEGORIA ls_subcategoria : lt_subcategoria) {
                        //  Añadimos todas las subcategorias a una array
                        lt_subcategoria_aux.add(new ZTP_SUBCATEGORIA(ls_subcategoria.getIdsubcategoria(), ls_subcategoria.getNombre()));
                    }

                    //  Añadimos subcategorias
                    ls_datos.setLs_category(lt_subcategoria_aux);
                }

                lt_datos.add(ls_datos);
            }

            return ResponseEntity.ok(lt_datos);
           
        }else{return ResponseEntity.badRequest().build();}
    }

    // Recuperamos subcategoria de una categoria
    @CrossOrigin
    @PostMapping("/getSubcategoryByCategory")
    public ResponseEntity<?> getSubcategoryByCategory(@RequestParam("idcategory") int lv_categoria) {

        // Estructuras
        ZTM_CATEGORIA ls_categoria = new ZTM_CATEGORIA();
        List<ZTM_SUBCATEGORIA> lt_subcategoria = new ArrayList<>();


        //Buscamos categoria
        ls_categoria = li_categoria_rep.findById(lv_categoria).get();
        if (!ObjectUtils.isEmpty(ls_categoria)) {

            //  Buscamos todas las subcategorias
            lt_subcategoria = li_subcategoria_rep.findAllByIdcategoria(ls_categoria.getIdcategoria());
            if (!ObjectUtils.isEmpty(lt_subcategoria)) {
                return ResponseEntity.ok(lt_subcategoria);
            }else{return ResponseEntity.badRequest().build();}
        }else{return ResponseEntity.badRequest().build();}
    }

////////////////////////////////////////////////////////////////////////////////////////////////

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
    @GetMapping("/get_category")
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
    @PostMapping("/create_category")
    public ResponseEntity<?> createCategoria(@RequestBody ZTM_CATEGORIA ls_nueva_categoria) {

        // Estructuras
        ZTM_CATEGORIA ls_categoria = new ZTM_CATEGORIA();

        //Buscamos categoria
        ls_categoria = li_categoria_rep.findByNombre(ls_nueva_categoria.getNombre());
        if (ObjectUtils.isEmpty(ls_categoria)) {
            li_categoria_rep.save(ls_nueva_categoria);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El nombre de la categoria ya existe");
        }
    }

    //Editar una categoria
    @CrossOrigin
    @PostMapping("/update_category")
    public ResponseEntity<?> updateCategoria(@RequestParam("idcategoria") int lv_categoria) {

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

    //Eliminar una categoria
    @CrossOrigin
    @PostMapping("/delete_category")
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
