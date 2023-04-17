package com.adhocsolucoes.academia.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adhocsolucoes.academia.entities.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	List<Aluno> findByDataNascimento(LocalDate dataNascimento);

}
