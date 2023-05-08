package com.fansroulette.rest.controller;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fansroulette.rest.modelo.ZTP_INT;
import com.fansroulette.rest.modelo.ZTP_LOGIN;
import com.fansroulette.rest.modelo.ZTP_USUARIO;
import com.fansroulette.rest.modelo.ZTT_CREDITO;
import com.fansroulette.rest.modelo.ZTT_USUARIO;
import com.fansroulette.rest.repository.CreditoRepository;
import com.fansroulette.rest.repository.UsuarioRepository;

@RestController
public class usuarioController {
	@Autowired
	private UsuarioRepository li_usuario_rep = null;
	@Autowired
	private CreditoRepository li_credito_rep;
	private BCryptPasswordEncoder passwordEncoder  =
	new BCryptPasswordEncoder(10, new SecureRandom());

	usuarioController(UsuarioRepository li_usuario_rep) {
		this.li_usuario_rep = li_usuario_rep;
	}

	
	//Búsqueda de listado de usuarios
	@GetMapping("/usuarios")
	ResponseEntity<?> usuarios() {
		try {
			return ResponseEntity.ok(li_usuario_rep.findAll());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} 
	}

	//Búsqueda por correo
	@CrossOrigin
	@GetMapping("/usuario/{correo}")
    public ResponseEntity<?> usuarioCorreo(@PathVariable("correo") String lv_correo) {

		ZTT_USUARIO ls_usuario = li_usuario_rep.findByCorreo(lv_correo);

		if (!ObjectUtils.isEmpty(ls_usuario)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	//Búsqueda por apodo
	@CrossOrigin
	@GetMapping("/apodo/{apodo}")
	public ResponseEntity<?> usuarioApodo(@PathVariable("apodo") String lv_apodo) {

		ZTT_USUARIO ls_usuario = li_usuario_rep.findByApodo(lv_apodo);

		if (!ObjectUtils.isEmpty(ls_usuario)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@CrossOrigin
	@PostMapping("/crear_usuario")
	ResponseEntity<?> crearUsuario(@RequestBody ZTT_USUARIO ls_nuevo_usuario) {

		// Hashear la contraseña
		ls_nuevo_usuario.setContrasena(passwordEncoder.encode(ls_nuevo_usuario.getContrasena()));
		ZTT_USUARIO ls_usuario = li_usuario_rep.save(ls_nuevo_usuario);
		
		if (ls_usuario != null) {
			// Devolvemos una respuesta de éxito
			actualizarUltimoAcceso(ls_usuario.getIduser());
			return ResponseEntity.ok(ls_usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
	}

	@CrossOrigin
	@PostMapping("/crear_usuario_google")
	ResponseEntity<?> crearUsuarioGoogle(@RequestBody ZTT_USUARIO ls_nuevo_usuario) {

		ZTP_USUARIO ls_datos = new ZTP_USUARIO();

		//Estructuras
		ZTT_USUARIO ls_usuario_creado = new ZTT_USUARIO();
		ZTT_USUARIO ls_usuario = li_usuario_rep.findByCorreo(ls_nuevo_usuario.getCorreo());
		
		if (!ObjectUtils.isEmpty(ls_usuario)) {
			//Actualizamos acceso
			actualizarUltimoAcceso(ls_usuario.getIduser());

			//Informamos datos a devolver
			ls_datos.setLs_usuario(ls_usuario_creado);
			ls_datos.setLv_creditos(recuperarCreditos(ls_usuario_creado.getIduser()));
			// Devolvemos una respuesta de éxito
            return ResponseEntity.ok(ls_datos);
        } else {
			ls_usuario_creado = li_usuario_rep.save(ls_nuevo_usuario);
			if (!ObjectUtils.isEmpty(ls_usuario_creado)) {

				//Actualizamos acceso
				actualizarUltimoAcceso(ls_usuario_creado.getIduser());

				//Creamos registro en la tabla maestra de créditos
				li_credito_rep.save(new ZTT_CREDITO(ls_usuario_creado.getIduser(), 0));

				//Informamos datos a devolver
				ls_datos.setLs_usuario(ls_usuario_creado);
				ls_datos.setLv_creditos(0);
				// Devolvemos una respuesta de éxito
				return ResponseEntity.ok(ls_datos);
			} else {
				return ResponseEntity.notFound().build();
			}
        }
	}

	/*@PutMapping("/usuario/{id}")
	ZTT_USUARIO actualizarUsuario(@RequestBody ZTT_USUARIO nuevoUsuario, @PathVariable Integer id) {
	    
	    return li_usuario_rep.findById(id)
	      .map(ztt_user -> {
	    	  ztt_user.setNombre(nuevoUsuario.getNombre());
	    	  ztt_user.setApellidos(nuevoUsuario.getApellidos());
	        return li_usuario_rep.save(ztt_user);
	      })
	      .orElseGet(() -> {
	    	  nuevoUsuario.setIduser(id);
	        return li_usuario_rep.save(nuevoUsuario);
	      });
	  }

	@DeleteMapping("/usuario/{id}")
	void eliminarUsuario(@PathVariable Integer id) {
		li_usuario_rep.deleteById(id);
	}*/

	@CrossOrigin
	@PostMapping("/iniciar_sesion")
    public ResponseEntity<?> iniciar_sesion(@RequestBody ZTP_LOGIN ls_login) {
		
		ZTT_USUARIO ls_usuario = li_usuario_rep.findByCorreo(ls_login.getCorreo());
		
		if (!ObjectUtils.isEmpty(ls_usuario) && validarContrasena(ls_login.getContrasena(), ls_usuario.getContrasena())) {
			actualizarUltimoAcceso(ls_usuario.getIduser());
            return ResponseEntity.ok(ls_usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario o contraseña incorrectos");
        }
	}

	@CrossOrigin
	@PostMapping("/actualizar")
    public ResponseEntity<?> actualizarUsuario(@RequestBody ZTT_USUARIO ls_usuario) throws IllegalArgumentException, IllegalAccessException {

		// Buscar al usuario por su ID en la base de datos
		ZTT_USUARIO ls_usuarioDB = li_usuario_rep.findById(ls_usuario.getIduser()).get();
		if (!ObjectUtils.isEmpty(ls_usuarioDB)){
			Class<?> usuarioClass = ls_usuario.getClass();
			Field[] fields = usuarioClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(ls_usuario);
				if (value != null) {
					field.set(ls_usuarioDB, value);
				}
			}
			
			li_usuario_rep.save(ls_usuarioDB);
			return ResponseEntity.ok().build();
		}else{
			return ResponseEntity.notFound().build();
		}
    }

	@CrossOrigin
	@PostMapping("/recuperar_contrasena")
	public ResponseEntity<String> recuperarContrasena(@RequestBody ZTP_INT ls_variable) {
		// Buscar al usuario por su ID en la base de datos
		ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_variable.getValor()).get();
		if (!ObjectUtils.isEmpty(ls_usuario)) {
			// Generar una contraseña aleatoria
			String lv_nuevaContraseña = generarContraseñaAleatoria();
			
			// Enviar la nueva contraseña por correo
			try {
				enviarCorreo(ls_usuario.getCorreo(), "Recuperación de contraseña", "Su nueva contraseña es: " + lv_nuevaContraseña);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Actualizar la contraseña del usuario en la base de datos
			ls_usuario.setContrasena(passwordEncoder.encode(ls_usuario.getContrasena()));
			li_usuario_rep.save(ls_usuario);
			
			// Devolver un mensaje de éxito
			return ResponseEntity.ok("Se ha enviado una nueva contraseña al correo electrónico del usuario.");
			
		}else{
			// Si el usuario no existe, devolver un HTTP 404
			return ResponseEntity.notFound().build();
		}
	}

	@CrossOrigin
    @PostMapping("/verificar_creador")
    public ResponseEntity<?> verificarCreador(@RequestBody ZTP_INT ls_variable) {

        ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_variable.getValor()).get();
        if (!ObjectUtils.isEmpty(ls_usuario)) {
			//Verificamos campos obligatorios para ser creador
			if (ls_usuario.getNombre() == null || ls_usuario.getNombre().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'nombre'");
			}
			if (ls_usuario.getApellidos() == null || ls_usuario.getApellidos().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'apellidos'");
			}
			if (ls_usuario.getAno_nacimiento() == null ) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'año de nacimiento'");
			}
			if (ls_usuario.getApodo() == null || ls_usuario.getApodo().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'apodo'");
			}
			if (ls_usuario.getBiografia() == null || ls_usuario.getBiografia().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'biografia'");
			}
			if (ls_usuario.getFoto() == null || ls_usuario.getFoto().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'foto'");
			}
			if (ls_usuario.getInstagram() == null || ls_usuario.getInstagram().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'instagram'");
			}
			/*if (ls_usuario.getInstagram_seguidores() == null ) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'instagram'");
			}*/
			if (ls_usuario.getBanner() == null || ls_usuario.getBanner().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'banner'");
			}
			if (ls_usuario.getIban() == null || ls_usuario.getIban().isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Es obligatorio informar el campo 'iban'");
			}
			ls_usuario.setTipousuario(2);
			ls_usuario.setVerificado(false);
			li_usuario_rep.save(ls_usuario);
			return ResponseEntity.ok("Se ha realizado la petición para ser creador.");

		}else{
			// Si el usuario no existe, devolver un HTTP 404
			return ResponseEntity.notFound().build();
		}
    }
	@CrossOrigin
	@GetMapping("/aprobar_creadores")
	ResponseEntity<?> aprobarCreadores() {
		try {
			return ResponseEntity.ok(li_usuario_rep.findByTipousuarioAndVerificadoFalse(2));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} 
	}

	@CrossOrigin
    @PostMapping("/aprobar_creador")
    public ResponseEntity<?> aprobarCreador(@RequestBody ZTP_INT ls_variable) {
		ZTT_USUARIO ls_usuario = li_usuario_rep.findById(ls_variable.getValor()).get();
        if (!ObjectUtils.isEmpty(ls_usuario)) {
			
			ls_usuario.setVerificado(true);
			li_usuario_rep.save(ls_usuario);
			return ResponseEntity.ok("Petición aceptada");

		}else{
			// Si el usuario no existe, devolver un HTTP 404
			return ResponseEntity.notFound().build();
		}
	}



// *********************************************		MÉTODOS		*************************************************
	private boolean validarContrasena(String contrasena, String hashContraseña) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(contrasena, hashContraseña);
	}

	public void actualizarUltimoAcceso(int lv_id_usuario) {
        ZTT_USUARIO ls_usuario = li_usuario_rep.findById(lv_id_usuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar el campo "ultimo_acceso" del usuario
        ls_usuario.setUltimo_acceso(new Date());
        li_usuario_rep.save(ls_usuario);
    }

	public List<ZTT_USUARIO> listadoUsuariosCreadores(){
		List<ZTT_USUARIO> ls_usuarios = li_usuario_rep.findAllByTipousuario(2);
		// Ordenar la lista por el campo 'instagram_seguidores' de forma descendente
		Collections.sort(ls_usuarios, new Comparator<ZTT_USUARIO>() {
			@Override
			public int compare(ZTT_USUARIO usuario1, ZTT_USUARIO usuario2) {
				return usuario2.getInstagram_seguidores() - usuario1.getInstagram_seguidores();
			}
		});

		return ls_usuarios;
	}

	private String generarContraseñaAleatoria() {
		// Generar una cadena aleatoria de 8 caracteres
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			int index = rand.nextInt(caracteres.length());
			sb.append(caracteres.charAt(index));
		}
		return sb.toString();
	}

	public void enviarCorreo(String destinatario, String asunto, String mensaje) throws MessagingException {
		// Configurar la sesión de correo electrónico
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	
		String remitente = "correo@gmail.com"; // tu dirección de correo electrónico
		String contraseña = "tucontraseña"; // tu contraseña de correo electrónico
	
		// Autenticación del usuario y construcción del mensaje
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente, contraseña);
			}
		});
	
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(remitente));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
		message.setSubject(asunto);
		message.setText(mensaje);
	
		// Envío del mensaje
		Transport.send(message);
	}

	private int recuperarCreditos(int lv_idusuario) {
		
		ZTT_CREDITO ls_credito = li_credito_rep.findByIdusuario(lv_idusuario);

		if (!ObjectUtils.isEmpty(ls_credito)) {
			return ls_credito.getNum_fichas();
		}else{
			return 0;
		}
	}

}
