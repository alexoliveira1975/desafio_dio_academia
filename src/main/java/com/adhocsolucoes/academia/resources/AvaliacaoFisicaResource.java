package com.adhocsolucoes.academia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adhocsolucoes.academia.entities.AvaliacaoFisica;
import com.adhocsolucoes.academia.entities.forms.AvaliacaoFisicaForm;
import com.adhocsolucoes.academia.services.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaResource {
	
	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;
	
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return avaliacaoFisicaService.create(form);
		
	}
	
	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		return avaliacaoFisicaService.getAll();
	}

}
