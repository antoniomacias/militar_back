package com.fansroulette.rest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fansroulette.rest.modelo.ZTM_FICHA;
import com.fansroulette.rest.modelo.ZTP_HISTORIAL_COMPRA;
import com.fansroulette.rest.modelo.ZTP_HISTORIAL_TIRADA;
import com.fansroulette.rest.modelo.ZTP_HISTORIAL_TIRADA_CREADOR;
import com.fansroulette.rest.modelo.ZTP_INT;
import com.fansroulette.rest.modelo.ZTT_COMPRA;
import com.fansroulette.rest.modelo.ZTT_TIRADA;
import com.fansroulette.rest.modelo.ZTT_USUARIO;
import com.fansroulette.rest.modelo.ZTT_CONFIG_RULETA;
import com.fansroulette.rest.modelo.ZTT_RULETA;
import com.fansroulette.rest.repository.CompraRepository;
import com.fansroulette.rest.repository.ConfigRuletaRepository;
import com.fansroulette.rest.repository.FichaRepository;
import com.fansroulette.rest.repository.RuletaRepository;
import com.fansroulette.rest.repository.TiradaRepository;
import com.fansroulette.rest.repository.UsuarioRepository;

@RestController
public class compraController {
    
	@Autowired
	private CompraRepository li_compra_rep;
	@Autowired
	private FichaRepository li_ficha_rep;
	@Autowired
	private TiradaRepository li_tirada_rep;
	@Autowired
	private UsuarioRepository li_usuario_rep;
	@Autowired
	private RuletaRepository li_ruleta_rep;
	@Autowired
	private ConfigRuletaRepository li_config_ruleta_rep;


    //Historial de compras de un usuario
	@CrossOrigin
    @PostMapping("/historial_compra")
    public ResponseEntity<?> getHistorialCompra(@RequestBody ZTP_INT ls_variable) {

        List<ZTP_HISTORIAL_COMPRA> lt_historial_compra = new ArrayList<>();

        List<ZTT_COMPRA> lt_compras = li_compra_rep.findAllByIduser(ls_variable.getValor());

        for (ZTT_COMPRA ls_compra : lt_compras ) {
            ZTM_FICHA ls_ficha = li_ficha_rep.findById(ls_compra.getIdficha()).get();
            if (!ObjectUtils.isEmpty(ls_ficha)) {
                ZTP_HISTORIAL_COMPRA ls_historial_compra = new ZTP_HISTORIAL_COMPRA(ls_compra.getIdcompra(), ls_compra.getIduser(), ls_compra.getIdficha(), ls_ficha.getPrecio(),
                ls_compra.getFecha_compra(), ls_ficha.getCantidad(), ls_ficha.getPrecio());
                lt_historial_compra.add(ls_historial_compra);
            }
        }
        Collections.sort(lt_historial_compra, new Comparator<ZTP_HISTORIAL_COMPRA>() {
			@Override
			public int compare(ZTP_HISTORIAL_COMPRA compra1, ZTP_HISTORIAL_COMPRA compra2) {
                return compra2.getFecha_compra().compareTo(compra1.getFecha_compra());
			}
		});
        return ResponseEntity.ok(lt_historial_compra);
    }
    
    //Historial de tiradas de un usuario
	@CrossOrigin
    @PostMapping("/historial_tiradas")
    public ResponseEntity<?> getHistorialTiradas(@RequestBody ZTP_INT ls_variable) {    

        List<ZTP_HISTORIAL_TIRADA> lt_historial_tirada = new ArrayList<>();

        List<ZTT_TIRADA> lt_tiradas = li_tirada_rep.findAllByIdusuariotirada(ls_variable.getValor());

        for (ZTT_TIRADA ls_tirada : lt_tiradas ) {
            ZTT_CONFIG_RULETA ls_config_ruleta = li_config_ruleta_rep.findById(ls_tirada.getIdconfigruleta()).get();
            if (!ObjectUtils.isEmpty(ls_config_ruleta)) {
                
                ZTT_RULETA ls_ruleta = li_ruleta_rep.findById(ls_config_ruleta.getIdruleta()).get();    //Buscamos por la ruleta que ha tirado
                if (!ObjectUtils.isEmpty(ls_ruleta)) {
                    ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_ruleta.getIduser()).get();    //Buscamos por el usuario creador
                    if (!ObjectUtils.isEmpty(ls_usuario)) {
                        ZTP_HISTORIAL_TIRADA ls_historial_tirada = new ZTP_HISTORIAL_TIRADA(ls_tirada.getIdtirada(), ls_usuario.getIduser(), ls_usuario.getNombre_completo(), ls_usuario.getApodo(),
                        ls_usuario.getFoto(), ls_config_ruleta.getTitulo(), ls_config_ruleta.getUrl_adjunto(), ls_tirada.getFecha_tirada());
                        lt_historial_tirada.add(ls_historial_tirada);
                    }
                }
                
            }
        }
        Collections.sort(lt_historial_tirada, new Comparator<ZTP_HISTORIAL_TIRADA>() {
			@Override
			public int compare(ZTP_HISTORIAL_TIRADA compra1, ZTP_HISTORIAL_TIRADA compra2) {
                return compra2.getFecha_tirada().compareTo(compra1.getFecha_tirada());
			}
		});
        return ResponseEntity.ok(lt_historial_tirada);
    }

        //Historial de tiradas de un creador
	@CrossOrigin
    @PostMapping("/historial_tiradas_creador")
    public ResponseEntity<?> getHistorialTiradasCreador(@RequestBody ZTP_INT ls_variable) {

        List<ZTP_HISTORIAL_TIRADA_CREADOR> lt_historial_tirada_creador = new ArrayList<>();
        
        List<ZTT_RULETA> lt_ruletas = li_ruleta_rep.findAllByIduser(ls_variable.getValor());    //  Buscamos todas las ruletas del creador
        for (ZTT_RULETA ls_ruleta : lt_ruletas ) {
            
            List<ZTT_TIRADA> lt_tiradas = li_tirada_rep.findAllByIdruleta(ls_ruleta.getIdruleta()); //  Buscamos todas las tiradas de cada ruleta
            for (ZTT_TIRADA ls_tirada : lt_tiradas ) {
                ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_tirada.getIdusuariotirada()).get();  
                if (!ObjectUtils.isEmpty(ls_usuario)) {
                    ZTP_HISTORIAL_TIRADA_CREADOR ls_historial_tirada_creador = new ZTP_HISTORIAL_TIRADA_CREADOR(ls_tirada.getIdtirada(), ls_usuario.getIduser(), 
                    ls_usuario.getNombre_completo(), ls_usuario.getApodo(), ls_ruleta.getIdruleta(), ls_ruleta.getNombre(), ls_tirada.getFecha_tirada());
                    lt_historial_tirada_creador.add(ls_historial_tirada_creador);
                }
            }
        }
        Collections.sort(lt_historial_tirada_creador, new Comparator<ZTP_HISTORIAL_TIRADA_CREADOR>() {
            @Override
            public int compare(ZTP_HISTORIAL_TIRADA_CREADOR compra1, ZTP_HISTORIAL_TIRADA_CREADOR compra2) {
                return compra2.getFecha_tirada().compareTo(compra1.getFecha_tirada());
            }
        });
        return ResponseEntity.ok(lt_historial_tirada_creador);
    }

    
// *********************************************		MÉTODOS		*************************************************
    private boolean validarTirada(int lv_idusuario, int lv_idficha) {
        return false;
        
    }
}
