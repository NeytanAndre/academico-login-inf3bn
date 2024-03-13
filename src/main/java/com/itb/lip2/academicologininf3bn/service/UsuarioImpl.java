package com.itb.lip2.academicologininf3bn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itb.lip2.academicologininf3bn.model.Usuario;
import com.itb.lip2.academicologininf3bn.repository.UsuarioRepository;

@Service
public class UsuarioImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	public Usuario save(Usuario usuario) {
		
		return usuariorepository.save(usuario);
	}

}
