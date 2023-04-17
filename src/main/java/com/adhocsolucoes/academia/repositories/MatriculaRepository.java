package com.adhocsolucoes.academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adhocsolucoes.academia.entities.Matricula;


public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	//List<Matricula> findByAlunoBairro(String bairro);
	
	@Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
	List<Matricula> findAlunoMatriculadoBairro(String bairro);

}
