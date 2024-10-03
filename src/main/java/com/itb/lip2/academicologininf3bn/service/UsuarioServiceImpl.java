package com.itb.lip2.academicologininf3bn.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.itb.lip2.academicologininf3bn.model.*;
import com.itb.lip2.academicologininf3bn.repository.PapelRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itb.lip2.academicologininf3bn.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Autowired
	private PapelRepository papelRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuariorepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Não foi encontrado o usuário no banco de dados");

		}else {
			System.out.println("Usuário encontrado: " + username);
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		usuario.getPapeis().forEach(papel -> {
			      authorities.add(new SimpleGrantedAuthority(papel.getNomePapel()));

		} );

		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getSenha(), authorities);
	}

	@Override
	public Usuario save(Usuario usuario) {

		usuario.setSenha((passwordEncoder.encode(usuario.getSenha())));
		return usuariorepository.save(usuario);
	}

	@Override
	public Usuario saveProfessor(Professor professor) {
	    professor.setCodStatusUsuario(true);
		professor.setSenha(passwordEncoder.encode(professor.getSenha()));
		professor.setPapeis(new ArrayList<>());
		addPapelToUsuario(professor, "ROLE_PROFESSOR");
		return usuariorepository.save(professor);
	}

	@Override
	public Usuario saveAluno(Aluno aluno) {
		aluno.setCodStatusUsuario(true);
		aluno.setSenha(passwordEncoder.encode(aluno.getSenha()));
		aluno.setPapeis(new ArrayList<>());
		addPapelToUsuario(aluno, "ROLE_ALUNO");
		return usuariorepository.save(aluno);
	}

	@Override
	public Usuario saveFuncionario(Funcionario funcionario) {
		funcionario.setCodStatusUsuario(true);
		funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
		funcionario.setPapeis(new ArrayList<>());
		addPapelToUsuario(funcionario, "ROLE_FUNCIONARIO");
		return usuariorepository.save(funcionario);
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



	@Override
	public Usuario findByEmail(String email) {
		return usuariorepository.findByEmail(email);
	}
	@Override
	public Papel savePapel(Papel papel) {
		papel.setCodStatusPapel(true);
		return papelRepository.save(papel);
	}


	@Override
	public void addPapelToUsuario(Usuario usuario, String papelNome) {
		 Papel papel = papelRepository.findByNomePapel(papelNome);
		 usuario.getPapeis().add(papel);

	}


}
