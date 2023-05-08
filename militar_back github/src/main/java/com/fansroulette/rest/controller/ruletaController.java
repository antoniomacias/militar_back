package com.fansroulette.rest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fansroulette.rest.modelo.ZTP_INT;
import com.fansroulette.rest.modelo.ZTP_RULETA;
import com.fansroulette.rest.modelo.ZTP_RULETA_CONFIG;
import com.fansroulette.rest.modelo.ZTT_CONFIG_RULETA;
import com.fansroulette.rest.modelo.ZTT_CREDITO;
import com.fansroulette.rest.modelo.ZTT_RULETA;
import com.fansroulette.rest.modelo.ZTT_TIRADA;
import com.fansroulette.rest.modelo.ZTT_USUARIO;
import com.fansroulette.rest.repository.ConfigRuletaRepository;
import com.fansroulette.rest.repository.CreditoRepository;
import com.fansroulette.rest.repository.RuletaRepository;
import com.fansroulette.rest.repository.TiradaRepository;
import com.fansroulette.rest.repository.UsuarioRepository;

@RestController
public class ruletaController {
    
	@Autowired
	private UsuarioRepository li_usuario_rep;
	@Autowired
	private RuletaRepository li_ruleta_rep;
	@Autowired
	private ConfigRuletaRepository li_config_ruleta_rep;
	@Autowired
	private TiradaRepository li_tirada_rep;
	@Autowired
	private CreditoRepository li_credito_rep;


	@CrossOrigin
	@PostMapping("/crear_ruleta")
	ResponseEntity<?> crearRuleta(@RequestBody ZTP_RULETA ls_datos) {

		// Creamos una nueva ruleta para el usuario
		ZTT_RULETA ls_nueva_ruleta = crearNuevaRuleta(ls_datos.getLs_ruleta());
		if (!ObjectUtils.isEmpty(ls_nueva_ruleta)) {
			
			//Creamos los apartados de la ruleta
			for (ZTT_CONFIG_RULETA ls_config_ruleta : ls_datos.getLt_config_ruleta() ) {
				ls_config_ruleta.setIdruleta(ls_nueva_ruleta.getIdruleta());
				li_config_ruleta_rep.save(ls_config_ruleta);
			}
			
			return ResponseEntity.ok("Se ha creado la ruleta: "+ls_nueva_ruleta.getNombre());

		}else{
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping("/crear_tirada")
	ResponseEntity<?> crearTirada(@RequestBody ZTT_TIRADA ls_tirada) {

		// Verificamos que exista el usuario
		ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_tirada.getIdusuariotirada()).get();
		if (!ObjectUtils.isEmpty(ls_usuario)) {
			// Verificamos que exista la ruleta
			ZTT_RULETA ls_ruleta = li_ruleta_rep.findById(ls_tirada.getIdruleta()).get();
			if (!ObjectUtils.isEmpty(ls_ruleta)) {
				// Verificamos que exista la config ruleta
				ZTT_CONFIG_RULETA ls_config_ruleta = li_config_ruleta_rep.findById(ls_tirada.getIdconfigruleta()).get();
				if (!ObjectUtils.isEmpty(ls_config_ruleta)) {

					//Si está todo correcto, creamos la tirada.
					ZTT_TIRADA ls_tirada_creada = li_tirada_rep.save(ls_tirada);
					if (!ObjectUtils.isEmpty(ls_tirada_creada)) {

						//Creada la ruleta, debemos restar los créditos
						ZTT_CREDITO ls_credito = li_credito_rep.findByIdusuario(ls_tirada.getIdusuariotirada());
						if (!ObjectUtils.isEmpty(ls_credito)) {
							ls_credito.setNum_fichas(ls_credito.getNum_fichas() - ls_ruleta.getCantidad_fichas());
							li_credito_rep.save(ls_credito);
						}
						
						return ResponseEntity.ok("Tirada correcta");
					}else{
						return ResponseEntity.notFound().build();
					}
				}else{
					return ResponseEntity.notFound().build();
				}
			}else{
				return ResponseEntity.notFound().build();
			}
		}else{
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
	@PostMapping("/recuperar_ruleta")
	ResponseEntity<?> recuperarRuleta(@RequestBody ZTP_INT ls_valor) {

		List<ZTP_RULETA_CONFIG> lt_datos = new ArrayList<>();

		// Verificamos que exista la ruleta
		ZTT_RULETA ls_ruleta = li_ruleta_rep.findById(ls_valor.getValor()).get();
		if (!ObjectUtils.isEmpty(ls_ruleta)) {
			// Verificamos que exista la config ruleta
			List<ZTT_CONFIG_RULETA> lt_config_ruleta = li_config_ruleta_rep.findAllByIdruleta(ls_valor.getValor());
			if (!ObjectUtils.isEmpty(lt_config_ruleta)) {

				//Hacemos una ordenación random
				Collections.shuffle(lt_config_ruleta);

				//Deshabilitamos las que ya ha ganado
				for (ZTT_CONFIG_RULETA ls_config_ruleta : lt_config_ruleta ) {
					ZTT_TIRADA ls_tirada = li_tirada_rep.findByIdusuariotiradaAndIdconfigruleta(ls_valor.getValor2(), ls_config_ruleta.getIdconfig_ruleta());

					if (ObjectUtils.isEmpty(ls_tirada)) {
						lt_datos.add(new ZTP_RULETA_CONFIG( ls_config_ruleta, false ) );
					}else{
						lt_datos.add(new ZTP_RULETA_CONFIG( ls_config_ruleta, true ) );
					}
				}

				return ResponseEntity.ok(lt_datos);
				
			}else{
				return ResponseEntity.notFound().build();
			}
		}else{
			return ResponseEntity.notFound().build();
		}
	}


// *********************************************		MÉTODOS		*************************************************
	private ZTT_RULETA crearNuevaRuleta(ZTT_RULETA ls_nueva_ruleta) {
		return li_ruleta_rep.save(ls_nueva_ruleta);
	}

}
