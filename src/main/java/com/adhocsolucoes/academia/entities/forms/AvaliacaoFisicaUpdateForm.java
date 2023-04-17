package com.adhocsolucoes.academia.entities.forms;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "${validatedValue}' precisa ser positivo.")
	private Double peso;

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "${validatedValue}' precisa ser positivo.")
	@DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no mínimo {value}.")
	private Double altura;
}