package com.adhocsolucoes.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.adhocsolucoes.academia.entities.Aluno;
import com.adhocsolucoes.academia.entities.Matricula;
import com.adhocsolucoes.academia.entities.forms.MatriculaForm;
import com.adhocsolucoes.academia.repositories.AlunoRepository;
import com.adhocsolucoes.academia.repositories.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	public Matricula create(@RequestBody MatriculaForm form) {
		Matricula matricula = new Matricula();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		matricula.setAluno(aluno);
		return matriculaRepository.save(matricula);

	}

	public Matricula get(Long id) {
		return matriculaRepository.findById(id).get();
	}

	public List<Matricula> getAll(String bairro) {
		if (bairro == null)
			return matriculaRepository.findAll();
		else
			return matriculaRepository.findAlunoMatriculadoBairro(bairro);

	}

	public void delete(Long id) {
		matriculaRepository.deleteById(id);
	}

}
