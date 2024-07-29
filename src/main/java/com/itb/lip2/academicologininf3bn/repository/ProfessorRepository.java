package com.itb.lip2.academicologininf3bn.repository;



import com.itb.lip2.academicologininf3bn.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
