package com.adhocsolucoes.academia.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhocsolucoes.academia.entities.Aluno;
import com.adhocsolucoes.academia.entities.AvaliacaoFisica;
import com.adhocsolucoes.academia.entities.forms.AlunoForm;
import com.adhocsolucoes.academia.entities.forms.AlunoUpdateForm;
import com.adhocsolucoes.academia.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService service;

	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}

	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacoesFisicas(@PathVariable Long id) {
		return service.getAllAvaliacoesFisicas(id);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno obj = service.get(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataNascimento", required = false) LocalDate dataNascimento) {
		return service.getAll(dataNascimento);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public Aluno update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm obj) {
		return service.update(id, obj);
	}

}
