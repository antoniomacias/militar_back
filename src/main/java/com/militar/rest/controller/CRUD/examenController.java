package com.militar.rest.controller.CRUD;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.militar.rest.modelo.ZTT_EXAMEN;
import com.militar.rest.modelo.POJO.ZTP_RESULTADO;
import com.militar.rest.modelo.POJO.ZTP_RESULTADOS;
import com.militar.rest.modelo.POJO.ZTP_TIPO_EXAMEN;
import com.militar.rest.modelo.TIPADOS.ZTP_INT;
import com.militar.rest.repository.CategoriaRepository;
import com.militar.rest.repository.ExamenRepository;

@RestController
public class examenController {
    
	@Autowired
	private ExamenRepository li_examen_rep;
	@Autowired
	private CategoriaRepository li_categoria_rep;

    
    //  Recuperamos exámenes de un usuario
    @CrossOrigin
    @PostMapping("/recoverExamUser")
    public ResponseEntity<?> recoverExamUser(@RequestBody ZTP_INT ls_valores) {

        List<ZTP_TIPO_EXAMEN> lt_datos = new ArrayList<>();
        List<ZTP_RESULTADOS> lt_resultados = new ArrayList<>();
        List<ZTP_RESULTADO> lt_resultado = new ArrayList<>();
        List<ZTT_EXAMEN> lt_examen = new ArrayList<>();
        ZTP_TIPO_EXAMEN ls_datos = new ZTP_TIPO_EXAMEN();
        ZTP_RESULTADOS ls_resultados = new ZTP_RESULTADOS();
        boolean lv_encontrado;


        //  Recuperamos los exámenes de categorias
        lt_examen = li_examen_rep.findByIduserAndTipoexamen(ls_valores.getValor1(), 1);
        if (!ObjectUtils.isEmpty(lt_examen)) {
            for (ZTT_EXAMEN ls_examen : lt_examen) {
                
                //  Buscamos si la categoria ya se encuentra añadida
                lv_encontrado = false;

                lv_encontrado = lt_resultados.stream()
                .anyMatch(resultado -> resultado.getIdcategory() == ls_examen.getTipoexamen()); 

                if (!lv_encontrado) {
                    //  Añadimos categoria + examen
                    lt_resultado = new ArrayList<>();
                    lt_resultado.add(new ZTP_RESULTADO(ls_examen.getIdexamen(), ls_examen.getFecha_examen(), ls_examen.getPreguntas_total(), ls_examen.getPreguntas_acertadas(), 
                    ls_examen.getPreguntas_falladas(), true));

                    //  Añadimos categoria + examen
                    lt_resultados.add(new ZTP_RESULTADOS(ls_examen.getIdcategoria(), li_categoria_rep.findById(ls_examen.getIdcategoria()).get().getNombre(),
                        lt_resultado));
                }else{
                    //  Añadimos solo examen
                     ls_resultados = lt_resultados.stream()
                        .filter(e -> e.getIdcategory() == ls_examen.getIdcategoria())
                        .findFirst()
                        .orElse(null);

                    if (ls_resultados != null) {
                        ls_resultados.getLs_result().add(new ZTP_RESULTADO(ls_examen.getIdexamen(), ls_examen.getFecha_examen(), ls_examen.getPreguntas_total(), ls_examen.getPreguntas_acertadas(), 
                        ls_examen.getPreguntas_falladas(), true));
                    }
                }
            }

            //  Mapeamos información
            if (!ObjectUtils.isEmpty(lt_resultados)) {
                ls_datos = new ZTP_TIPO_EXAMEN();
                ls_datos.setType_exam(1);
                ls_datos.setExam("Categorias");
                ls_datos.setLt_result(lt_resultados);

                lt_datos.add(ls_datos);
            }
        }

        //  Recuperamos los exámenes de subcategorias
        lt_examen = new ArrayList<>();
        lt_examen = li_examen_rep.findByIduserAndTipoexamen(ls_valores.getValor1(), 2);
        if (!ObjectUtils.isEmpty(lt_examen)) {
            for (ZTT_EXAMEN ls_examen : lt_examen) {
                
                //  Buscamos si la categoria ya se encuentra añadida
                lv_encontrado = false;

                lv_encontrado = lt_resultados.stream()
                .anyMatch(resultado -> resultado.getIdcategory() == ls_examen.getTipoexamen()); 

                if (!lv_encontrado) {
                    //  Añadimos categoria + examen
                    lt_resultado = new ArrayList<>();
                    lt_resultado.add(new ZTP_RESULTADO(ls_examen.getIdexamen(), ls_examen.getFecha_examen(), ls_examen.getPreguntas_total(), ls_examen.getPreguntas_acertadas(), 
                    ls_examen.getPreguntas_falladas(), true));

                    //  Añadimos categoria + examen
                    lt_resultados.add(new ZTP_RESULTADOS(ls_examen.getIdcategoria(), li_categoria_rep.findById(ls_examen.getIdcategoria()).get().getNombre(),
                        lt_resultado));
                }else{
                    //  Añadimos solo examen
                     ls_resultados = lt_resultados.stream()
                        .filter(e -> e.getIdcategory() == ls_examen.getIdcategoria())
                        .findFirst()
                        .orElse(null);

                    if (ls_resultados != null) {
                        ls_resultados.getLs_result().add(new ZTP_RESULTADO(ls_examen.getIdexamen(), ls_examen.getFecha_examen(), ls_examen.getPreguntas_total(), ls_examen.getPreguntas_acertadas(), 
                        ls_examen.getPreguntas_falladas(), true));
                    }
                }
            }

            //  Mapeamos información
            if (!ObjectUtils.isEmpty(lt_resultados)) {
                ls_datos = new ZTP_TIPO_EXAMEN();
                ls_datos.setType_exam(2);
                ls_datos.setExam("Subcategorias");
                ls_datos.setLt_result(lt_resultados);

                lt_datos.add(ls_datos);
            }
        }
        
        //  Recuperamos los exámenes de simulacros
        lt_examen = new ArrayList<>();
        lt_examen = li_examen_rep.findByIduserAndTipoexamen(ls_valores.getValor1(), 3);
        if (!ObjectUtils.isEmpty(lt_examen)) {
            for (ZTT_EXAMEN ls_examen : lt_examen) {
                
                //  Buscamos si la categoria ya se encuentra añadida
                lv_encontrado = false;

                lv_encontrado = lt_resultados.stream()
                .anyMatch(resultado -> resultado.getIdcategory() == ls_examen.getTipoexamen()); 

                if (!lv_encontrado) {
                    //  Añadimos categoria + examen
                    lt_resultado = new ArrayList<>();
                    lt_resultado.add(new ZTP_RESULTADO(ls_examen.getIdexamen(), ls_examen.getFecha_examen(), ls_examen.getPreguntas_total(), ls_examen.getPreguntas_acertadas(), 
                    ls_examen.getPreguntas_falladas(), true));

                    //  Añadimos categoria + examen
                    lt_resultados.add(new ZTP_RESULTADOS(ls_examen.getIdcategoria(), li_categoria_rep.findById(ls_examen.getIdcategoria()).get().getNombre(),
                        lt_resultado));
                }else{
                    //  Añadimos solo examen
                     ls_resultados = lt_resultados.stream()
                        .filter(e -> e.getIdcategory() == ls_examen.getIdcategoria())
                        .findFirst()
                        .orElse(null);

                    if (ls_resultados != null) {
                        ls_resultados.getLs_result().add(new ZTP_RESULTADO(ls_examen.getIdexamen(), ls_examen.getFecha_examen(), ls_examen.getPreguntas_total(), ls_examen.getPreguntas_acertadas(), 
                        ls_examen.getPreguntas_falladas(), true));
                    }
                }
            }

            //  Mapeamos información
            if (!ObjectUtils.isEmpty(lt_resultados)) {
                ls_datos = new ZTP_TIPO_EXAMEN();
                ls_datos.setType_exam(3);
                ls_datos.setExam("Simulacros");
                ls_datos.setLt_result(lt_resultados);

                lt_datos.add(ls_datos);
            }
        }

        return ResponseEntity.ok(lt_datos);
    }   
}
