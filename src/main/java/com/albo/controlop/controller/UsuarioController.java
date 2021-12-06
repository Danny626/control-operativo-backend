package com.albo.controlop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.controlop.model.Rol;
import com.albo.controlop.model.Usuario;
import com.albo.controlop.service.IRolService;
import com.albo.controlop.service.IUsuarioService;
import com.albo.exception.ModeloNotFoundException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IRolService rolService;

	// @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = service.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Usuario>> listarPageable(Pageable pageable) {
		Page<Usuario> usuarios = null;
		usuarios = service.listarPageable(pageable);
		return new ResponseEntity<Page<Usuario>>(usuarios, HttpStatus.OK);
	}

	// @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> listarId(@PathVariable("id") String id) {
		Usuario usuario = new Usuario();
		usuario = service.findById(id).get();
		if (usuario == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		usuario.setPassword("=)");
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

//	@GetMapping(value = "/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Usuario> listarUsername(@PathVariable("username")  String username) throws Exception {
//		Usuario usuario = new Usuario();
////		usuario = loginService.verificarNombreUsuario(username);
//		usuario = service.listarPorUsername(username);
//		System.out.println(usuario);
//		if (usuario == null) {
//			throw new ModeloNotFoundException("Usuario: " + username);
//		}
//		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
//	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrar(@Valid @RequestBody Usuario usuario) { // Valid para validar lo anotado en
																					// el modelo Signo: @Min; @Max;																		// @Size
		Usuario obj = new Usuario();
		usuario.setPassword(bcrypt.encode(usuario.getPassword()));
		Rol rol = rolService.findById("USER").get();
		usuario.setRol(rol);
		obj = service.saveOrUpdate(usuario);
		
		usuario.setPassword("=)");
		return new ResponseEntity<Usuario>(obj, HttpStatus.CREATED);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Usuario usuario) {
		service.saveOrUpdate(usuario);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> eliminar(@PathVariable String id) {
		if (service.deleteById(id)) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

}
