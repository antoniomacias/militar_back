package com.militar.rest.controller.CRUD;

import java.lang.reflect.Field;
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

import com.militar.rest.modelo.ZTM_SUBCATEGORIA;
import com.militar.rest.modelo.POJO.ZTP_SUBCATEGORIA;
import com.militar.rest.modelo.TIPADOS.ZTP_INT;
import com.militar.rest.repository.SubcategoriaRepository;

public class subcategoriaController {

	@Autowired
	private SubcategoriaRepository li_subcategoria_rep;


    //Recuperar todas las subcategorias
    @CrossOrigin
    @GetMapping("/get_subcategories")
    public ResponseEntity<?> getSubcategories() {

        // Estructuras
        List<ZTP_SUBCATEGORIA> lt_subcategoria = new ArrayList<>();

        //Buscamos subcategorias
        lt_subcategoria = li_subcategoria_rep.obtenerSubcategorias();

        if (!ObjectUtils.isEmpty(lt_subcategoria)) {
            return ResponseEntity.ok(lt_subcategoria);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    //Recuperar una subcategoria por ID
    @CrossOrigin
    @PostMapping("/get_subcategory")
    public ResponseEntity<?> getSubcategory(@RequestParam("idsubcategory") int lv_subcategoria) {

        // Estructuras
        ZTP_SUBCATEGORIA ls_subcategoria = new ZTP_SUBCATEGORIA();

        //Buscamos categoria
        ls_subcategoria = li_subcategoria_rep.obtenerSubcategoriasId(lv_subcategoria);

        if (!ObjectUtils.isEmpty(ls_subcategoria)) {
            return ResponseEntity.ok(ls_subcategoria);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

   //Recuperar una subcategoria por ID
    @CrossOrigin
    @PostMapping("/get_subcategory_name")
    public ResponseEntity<?> getSubcategoryName(@RequestParam("namesubcategory") String lv_nombre_subcategoria) {

        // Estructuras
        ZTP_SUBCATEGORIA ls_subcategoria = new ZTP_SUBCATEGORIA();

        //Buscamos categoria
        ls_subcategoria = li_subcategoria_rep.obtenerSubcategoriasName(lv_nombre_subcategoria);

        if (!ObjectUtils.isEmpty(ls_subcategoria)) {
            return ResponseEntity.ok(ls_subcategoria);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


    //Crear una nueva categoria
    @CrossOrigin
    @PostMapping("/create_subcategory")
    public ResponseEntity<?> createSubcategory(@RequestBody ZTM_SUBCATEGORIA ls_nueva_subcategoria) {

        // Estructuras
        List<ZTP_SUBCATEGORIA> lt_subcategoria = new ArrayList<>();
        ZTM_SUBCATEGORIA ls_subcategoria = new ZTM_SUBCATEGORIA();

        //Buscamos categoria
        ls_subcategoria = li_subcategoria_rep.findByNombre(ls_nueva_subcategoria.getNombre());
        if (ObjectUtils.isEmpty(ls_subcategoria)) {
            li_subcategoria_rep.save(ls_subcategoria);
            
            //Buscamos subcategorias
            lt_subcategoria = li_subcategoria_rep.obtenerSubcategorias();

            if (!ObjectUtils.isEmpty(lt_subcategoria)) {
                return ResponseEntity.ok(lt_subcategoria);
            }else{return ResponseEntity.badRequest().build();}
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El nombre de la subcategoria ya existe");}
    }

    //Editar una categoria
    @CrossOrigin
	@PostMapping("/update_subcategory")
    public ResponseEntity<?> updateSubcategory(@RequestBody ZTM_SUBCATEGORIA ls_subcategoria) throws IllegalArgumentException, IllegalAccessException {
		
        // Estructuras
        List<ZTP_SUBCATEGORIA> lt_subcategoria = new ArrayList<>();

		// Buscar al usuario por su ID en la base de datos
		ZTM_SUBCATEGORIA ls_subcategoriaDB = li_subcategoria_rep.findById(ls_subcategoria.getIdsubcategoria()).get();
		if (!ObjectUtils.isEmpty(ls_subcategoriaDB)){
			Class<?> usuarioClass = ls_subcategoria.getClass();
			Field[] fields = usuarioClass.getDeclaredFields();
			for (Field field : fields) {

				if (field.getName() == "idsubcategoria" ||  field.getName() == "usuario_creacion" ||  field.getName() == "fecha_creacion") {
					//	Estos campos no serán editables.
				}else{
					field.setAccessible(true);
					Object value = field.get(ls_subcategoria);
					if (value != null && value != "") {
						field.set(ls_subcategoriaDB, value);
					}
				}
			}
			
			//	Actualizamos usuario
			li_subcategoria_rep.save(ls_subcategoriaDB);
			
            //Buscamos subcategorias
            lt_subcategoria = li_subcategoria_rep.obtenerSubcategorias();

            if (!ObjectUtils.isEmpty(lt_subcategoria)) {
                return ResponseEntity.ok(lt_subcategoria);
            }else{return ResponseEntity.badRequest().build();}
		}else{return ResponseEntity.notFound().build();}
    }


    //Eliminar una categoria
    @CrossOrigin
    @PostMapping("/delete_subcategory")
    public ResponseEntity<?> deleteSubcategory(@RequestBody ZTP_INT ls_valor) {

        // Estructuras
        List<ZTP_SUBCATEGORIA> lt_subcategoria = new ArrayList<>();
        ZTM_SUBCATEGORIA ls_subcategoria = new ZTM_SUBCATEGORIA();

        //Buscamos categoria
        ls_subcategoria = li_subcategoria_rep.findById(ls_valor.getValor1()).get();
        if (!ObjectUtils.isEmpty(ls_subcategoria)) {
            li_subcategoria_rep.deleteById(ls_valor.getValor1());
            //Buscamos subcategorias
            lt_subcategoria = li_subcategoria_rep.obtenerSubcategorias();

            if (!ObjectUtils.isEmpty(lt_subcategoria)) {
                return ResponseEntity.ok(lt_subcategoria);
            }else{return ResponseEntity.badRequest().build();}
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
