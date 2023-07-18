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
import com.militar.rest.modelo.TIPADOS.ZTP_INT;
import com.militar.rest.repository.CursoRepository;

@RestController
public class cursoController {
    
	@Autowired
	private CursoRepository li_curso_rep;


    //Recuperar todas las cursos
    @CrossOrigin
    @GetMapping("/get_courses")
    public ResponseEntity<?> getCourses() {

        // Estructuras
        List<ZTM_CURSO> lt_cursos = new ArrayList<>();

        //Buscamos cursos
        lt_cursos = li_curso_rep.findAll();

        if (!ObjectUtils.isEmpty(lt_cursos)) {
            return ResponseEntity.ok(lt_cursos);
        }else{return ResponseEntity.badRequest().build();}
    }

    //Recuperar una subcategoria por ID
    @CrossOrigin
    @PostMapping("/get_course")
    public ResponseEntity<?> getCourse(@RequestParam("idcourse") int lv_idcourse) {

        // Estructuras
        ZTM_CURSO ls_curso = new ZTM_CURSO();

        //Buscamos categoria
        ls_curso = li_curso_rep.findById(lv_idcourse).get();

        if (!ObjectUtils.isEmpty(ls_curso)) {
            return ResponseEntity.ok(ls_curso);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

   //Recuperar una subcategoria por ID
    @CrossOrigin
    @PostMapping("/get_course_name")
    public ResponseEntity<?> getCourseName(@RequestParam("namecourse") String lv_nombre_course) {

        // Estructuras
        ZTM_CURSO ls_curso = new ZTM_CURSO();

        //Buscamos categoria
        ls_curso = li_curso_rep.obtenerNombrecurso(lv_nombre_course);

        if (!ObjectUtils.isEmpty(ls_curso)) {
            return ResponseEntity.ok(ls_curso);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


    //Crear una nueva categoria
    @CrossOrigin
    @PostMapping("/create_course")
    public ResponseEntity<?> createCourse(@RequestBody ZTM_CURSO ls_nuevo_curso) {

        // Estructuras
        List<ZTM_CURSO> lt_cursos = new ArrayList<>();
        ZTM_CURSO ls_curso = new ZTM_CURSO();

        //Buscamos curso
        ls_curso = li_curso_rep.obtenerNombrecurso(ls_nuevo_curso.getNombre_curso());
        if (ObjectUtils.isEmpty(ls_curso)) {
            li_curso_rep.save(ls_curso);
            
            //Buscamos cursos
            lt_cursos = li_curso_rep.findAll();

            if (!ObjectUtils.isEmpty(lt_cursos)) {
                return ResponseEntity.ok(lt_cursos);
            }else{return ResponseEntity.badRequest().build();}
        }else{return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El nombre del curso ya existe");}
    }

    //Editar una categoria
    @CrossOrigin
	@PostMapping("/update_course")
    public ResponseEntity<?> updateCourse(@RequestBody ZTM_CURSO ls_curso) throws IllegalArgumentException, IllegalAccessException {
		
        // Estructuras
        List<ZTM_CURSO> lt_cursos = new ArrayList<>();

		// Buscar al usuario por su ID en la base de datos
		ZTM_CURSO ls_cursoDB = li_curso_rep.findById(ls_curso.getIdcurso()).get();
		if (!ObjectUtils.isEmpty(ls_cursoDB)){
			Class<?> usuarioClass = ls_curso.getClass();
			Field[] fields = usuarioClass.getDeclaredFields();
			for (Field field : fields) {

				if (field.getName() == "idcurso" ||  field.getName() == "usuario_creacion" ||  field.getName() == "fecha_creacion") {
					//	Estos campos no serán editables.
				}else{
					field.setAccessible(true);
					Object value = field.get(ls_curso);
					if (value != null && value != "") {
						field.set(ls_cursoDB, value);
					}
				}
			}
			
			//	Actualizamos usuario
			li_curso_rep.save(ls_cursoDB);
			
            //Buscamos cursos
            lt_cursos = li_curso_rep.findAll();

            if (!ObjectUtils.isEmpty(lt_cursos)) {
                return ResponseEntity.ok(lt_cursos);
            }else{return ResponseEntity.badRequest().build();}
		}else{return ResponseEntity.notFound().build();}
    }


    //Eliminar una categoria
    @CrossOrigin
    @PostMapping("/delete_course")
    public ResponseEntity<?> deleteCourse(@RequestBody ZTP_INT ls_valor) {

        // Estructuras
        List<ZTM_CURSO> lt_cursos = new ArrayList<>();
        ZTM_CURSO ls_curso = new ZTM_CURSO();

        //Buscamos categoria
        ls_curso = li_curso_rep.findById(ls_valor.getValor1()).get();
        if (!ObjectUtils.isEmpty(ls_curso)) {
            li_curso_rep.deleteById(ls_valor.getValor1());

            //Buscamos cursos
            lt_cursos = li_curso_rep.findAll();

            if (!ObjectUtils.isEmpty(lt_cursos)) {
                return ResponseEntity.ok(lt_cursos);
            }else{return ResponseEntity.badRequest().build();}
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
