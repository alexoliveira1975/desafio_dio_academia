package com.adhocsolucoes.academia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhocsolucoes.academia.entities.Aluno;
import com.adhocsolucoes.academia.entities.AvaliacaoFisica;
import com.adhocsolucoes.academia.entities.forms.AvaliacaoFisicaForm;
import com.adhocsolucoes.academia.entities.forms.AvaliacaoFisicaUpdateForm;
import com.adhocsolucoes.academia.repositories.AlunoRepository;
import com.adhocsolucoes.academia.repositories.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avalFis = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

		avalFis.setAluno(aluno);
		avalFis.setPeso(form.getPeso());
		avalFis.setAltura(form.getAltura());

		return avaliacaoFisicaRepository.save(avalFis);

	}

	public AvaliacaoFisica get(Long id) {
		Optional<AvaliacaoFisica> obj = avaliacaoFisicaRepository.findById(id);
		return obj.get();
	}

	public List<AvaliacaoFisica> getAll() {
		return avaliacaoFisicaRepository.findAll();

	}

	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}

	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm obj) {
		AvaliacaoFisica avalFisica = avaliacaoFisicaRepository.getReferenceById(id);
		updateAvaliacao(avalFisica, obj);
		return avaliacaoFisicaRepository.save(avalFisica);
	}

	private void updateAvaliacao(AvaliacaoFisica avaliacaoFisica, AvaliacaoFisicaUpdateForm obj) {
		avaliacaoFisica.setPeso(obj.getPeso());
		avaliacaoFisica.setAltura(obj.getAltura());
	}

}
