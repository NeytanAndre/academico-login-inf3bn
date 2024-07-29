package com.itb.lip2.academicologininf3bn.controller;

import com.itb.lip2.academicologininf3bn.model.Professor;
import com.itb.lip2.academicologininf3bn.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academico/api/v1/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProfessor(@RequestBody Professor professor, @PathVariable(value = "id") Long id) {
        try {
            //URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/acade"))
            return ResponseEntity.ok().body(professorService.update(id, professor));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}

