package com.itb.lip2.academicologininf3bn.service;


import com.itb.lip2.academicologininf3bn.model.Professor;
import com.itb.lip2.academicologininf3bn.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor update(Long id, Professor professor) throws Exception{
        return professorRepository.findById(id).map(al->{
            al.setNome(professor.getNome());
            al.setEmail(professor.getEmail());
            al.setCodStatusUsuario(professor.isCodStatusUsuario());
            al.setTipoUsuario(professor.getTipoUsuario());
            return professorRepository.save(al);
        }).orElseThrow(()-> new Exception("Aluno não encontrado!"));
    }
}
