package com.adhocsolucoes.academia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adhocsolucoes.academia.entities.Matricula;
import com.adhocsolucoes.academia.entities.forms.MatriculaForm;
import com.adhocsolucoes.academia.services.MatriculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaResource {
	
	@Autowired
	private MatriculaService service;
	
	
	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}
	
	@GetMapping
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro ){
		return service.getAll(bairro);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
