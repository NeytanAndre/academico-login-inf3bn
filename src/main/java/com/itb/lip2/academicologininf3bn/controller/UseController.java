package com.itb.lip2.academicologininf3bn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itb.lip2.academicologininf3bn.model.Usuario;
import com.itb.lip2.academicologininf3bn.service.UsuarioService;

// Obs: Controller
// @Controller    -  Especificamente para sistema WEB
// @RestController -  Especificamente para API


@RestController
@RequestMapping("/academico/api/v1")
public class UseController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/users")
	public List<Usuario> getUsers() {
		
		List <Usuario>usuarios = new ArrayList<Usuario>();
		
		Usuario u1 = new Usuario();
		u1.setId(1l);
		u1.setNome("Neytan");
		u1.setEmail("Neytan@gmail.com");
		
		Usuario u2 = new Usuario();
		u2.setId(2l);
		u2.setNome("Andre");
		u2.setEmail("Andre@gmail.com");
		
		usuarios.add(u1);
		usuarios.add(u2);
	
		
		return usuarios;
		
	}
	
	
	public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(usuarioService.save(usuario));
	}

}
