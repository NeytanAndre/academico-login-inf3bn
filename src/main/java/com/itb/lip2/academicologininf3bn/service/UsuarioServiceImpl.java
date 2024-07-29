package com.itb.lip2.academicologininf3bn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import com.itb.lip2.academicologininf3bn.model.Usuario;
import com.itb.lip2.academicologininf3bn.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	public Usuario save(Usuario usuario) {
		
		return usuariorepository.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		
		return usuariorepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return usuariorepository.findById(id) ;
	}

	// Metodo generico para atualizar "algumas informações" do usuario (aceita qualquer tipo de usuario)
	@Override
	@Transactional
	public Usuario update(Long id, Usuario usuario) throws Exception {
		return usuariorepository.findById(id).map(user ->{
			user.setNome(usuario.getNome());
			user.setNome(usuario.getEmail());
			user.setNome(usuario.getTipoUsuario());
            user.setCodStatusUsuario(usuario.isCodStatusUsuario());
			return usuariorepository.save(user);
		}).orElseThrow(()-> new ExpressionException("Usuário não encontrado!"));
	}

}
