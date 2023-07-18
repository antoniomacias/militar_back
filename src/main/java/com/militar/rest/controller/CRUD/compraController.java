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
import org.springframework.web.bind.annotation.RestController;

import com.militar.rest.modelo.ZTM_CURSO;
import com.militar.rest.modelo.ZTT_COMPRA;
import com.militar.rest.modelo.ZTT_USUARIO;
import com.militar.rest.modelo.POJO.ZTP_COMPRA;
import com.militar.rest.modelo.TIPADOS.ZTP_INT;
import com.militar.rest.repository.CompraRepository;
import com.militar.rest.repository.CursoRepository;
import com.militar.rest.repository.UsuarioRepository;

@RestController
public class compraController {

    @Autowired
	private UsuarioRepository li_usuario_rep;
    @Autowired
	private CursoRepository li_curso_rep;
    @Autowired
	private CompraRepository li_compra_rep;


    //Recuperar todas las compras
    @CrossOrigin
    @GetMapping("/get_purchases")
    public ResponseEntity<?> getPurchases() {

        // Estructuras
        List<ZTP_COMPRA> lt_compras = new ArrayList<>();

        //Buscamos compras
        lt_compras = li_compra_rep.obtenerCompras();

        if (!ObjectUtils.isEmpty(lt_compras)) {
            return ResponseEntity.ok(lt_compras);
        }else{return ResponseEntity.badRequest().build();}
    }

    //Recuperar una compra por ID
    @CrossOrigin
    @PostMapping("/get_purchase")
    public ResponseEntity<?> getPurchase(@RequestParam("idpurchase") int lv_idpurchase) {

        // Estructuras
        ZTP_COMPRA ls_compra = new ZTP_COMPRA();

        //Buscamos compra
        ls_compra = li_compra_rep.obtenerCompra(lv_idpurchase);

        if (!ObjectUtils.isEmpty(ls_compra)) {
            return ResponseEntity.ok(ls_compra);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


    //Crear una nueva compra
    @CrossOrigin
    @PostMapping("/create_purchase")
    public ResponseEntity<?> createPurchase(@RequestBody ZTT_COMPRA ls_nueva_compra) {

        // Estructuras
        List<ZTP_COMPRA> lt_compras = new ArrayList<>();
        ZTT_USUARIO ls_usuario = new ZTT_USUARIO();
        ZTM_CURSO ls_curso = new ZTM_CURSO();

        //Buscamos usuario
        ls_usuario = li_usuario_rep.findById(ls_nueva_compra.getIduser()).get();
        if (!ObjectUtils.isEmpty(ls_usuario)) {
            //Buscamos curso
            ls_curso = li_curso_rep.findById(ls_nueva_compra.getIdcurso()).get();
            if (!ObjectUtils.isEmpty(ls_curso)) {
                li_compra_rep.save(ls_nueva_compra);
            
                //Buscamos compras
                lt_compras = li_compra_rep.obtenerCompras();

                if (!ObjectUtils.isEmpty(lt_compras)) {
                    return ResponseEntity.ok(lt_compras);
                }else{return ResponseEntity.badRequest().build();}
            }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El nombre del curso ya existe");}
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El nombre del curso ya existe");}
    }

    //Editar una categoria
    @CrossOrigin
	@PostMapping("/update_purchase")
    public ResponseEntity<?> updatePurchase(@RequestBody ZTT_COMPRA ls_compra) throws IllegalArgumentException, IllegalAccessException {
		
        // Estructuras
        List<ZTP_COMPRA> lt_compras = new ArrayList<>();

		// Buscar al usuario por su ID en la base de datos
		ZTT_COMPRA ls_compraDB = li_compra_rep.findById(ls_compra.getIdcompra()).get();
		if (!ObjectUtils.isEmpty(ls_compraDB)){
			Class<?> usuarioClass = ls_compra.getClass();
			Field[] fields = usuarioClass.getDeclaredFields();
			for (Field field : fields) {

				if (field.getName() == "idcompra" ||  field.getName() == "usuario_creacion" ||  field.getName() == "fecha_creacion") {
					//	Estos campos no serán editables.
				}else{
					field.setAccessible(true);
					Object value = field.get(ls_compra);
					if (value != null && value != "") {
						field.set(ls_compraDB, value);
					}
				}
			}
			
			//	Actualizamos usuario
			li_compra_rep.save(ls_compraDB);
			
            //Buscamos compras
            lt_compras = li_compra_rep.obtenerCompras();

            if (!ObjectUtils.isEmpty(lt_compras)) {
                return ResponseEntity.ok(lt_compras);
            }else{return ResponseEntity.badRequest().build();}
		}else{return ResponseEntity.notFound().build();}
    }
}
