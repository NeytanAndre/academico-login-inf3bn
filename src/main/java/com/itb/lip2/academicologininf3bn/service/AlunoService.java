package com.itb.lip2.academicologininf3bn.service;

import com.itb.lip2.academicologininf3bn.model.Aluno;
import org.springframework.context.annotation.Bean;


public interface AlunoService {

    Aluno update (Long id, Aluno aluno) throws Exception;
}
