package com.adhocsolucoes.academia.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adhocsolucoes.academia.entities.Aluno;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		Aluno a1 = new Aluno();
		
	}

}
