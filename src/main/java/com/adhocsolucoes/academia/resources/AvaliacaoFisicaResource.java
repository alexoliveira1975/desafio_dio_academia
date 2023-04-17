package com.adhocsolucoes.academia.resources;

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
import org.springframework.web.bind.annotation.RestController;

import com.adhocsolucoes.academia.entities.AvaliacaoFisica;
import com.adhocsolucoes.academia.entities.forms.AvaliacaoFisicaForm;
import com.adhocsolucoes.academia.entities.forms.AvaliacaoFisicaUpdateForm;
import com.adhocsolucoes.academia.services.AvaliacaoFisicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaResource {
	
	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;
	
	@PostMapping
	public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return avaliacaoFisicaService.create(form);
		
	}
	
	@GetMapping(value = "/{id}")
	public AvaliacaoFisica findById(@PathVariable Long id){
		return avaliacaoFisicaService.get(id);
	}
	
	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		return avaliacaoFisicaService.getAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		avaliacaoFisicaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public AvaliacaoFisica update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateForm obj) {
		return avaliacaoFisicaService.update(id, obj);
	}

}
