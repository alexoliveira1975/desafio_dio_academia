package com.adhocsolucoes.academia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhocsolucoes.academia.entities.Aluno;
import com.adhocsolucoes.academia.entities.AvaliacaoFisica;
import com.adhocsolucoes.academia.entities.forms.AlunoForm;
import com.adhocsolucoes.academia.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository; 
	
	 public Aluno create(AlunoForm form) {
		 Aluno aluno = new Aluno();
		 aluno.setNome(form.getNome());
		 aluno.setCpf(form.getCpf());
		 aluno.setBairro(form.getBairro());
		 aluno.setDataNascimento(form.getDataNascimento());
		 
		 return alunoRepository.save(aluno);
		  
	 }
	 
	 public Aluno get(Long id) {
		 Optional<Aluno> obj = alunoRepository.findById(id);
		 return obj.get();
	 }
	 
	 public List<Aluno> getAll(){
		 return alunoRepository.findAll();
		 
	 }

	public List<AvaliacaoFisica> getAllAvaliacoesFisicas(Long id) {
		
		Aluno aluno = alunoRepository.findById(id).get();
		return aluno.getAvaliacoes();
	}
	 
	 

}
