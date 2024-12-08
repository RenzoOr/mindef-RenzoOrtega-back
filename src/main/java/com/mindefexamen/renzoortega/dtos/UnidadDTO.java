package com.mindefexamen.renzoortega.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mindefexamen.renzoortega.dtos.ancestors.AncestorDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class UnidadDTO extends AncestorDTO{
	@JsonProperty(index = 0)
	private Long idCodUnidad;
	
	@JsonProperty(index = 1)
	@Size(min = 5, max = 150, message = "Nombre debe tener entre 2 y 50 caracteres")
	private String nombre;
	
	@JsonProperty(index = 2)
	@NotNull
	private String sigla;
	
	@JsonProperty(index = 3)
	@NotNull
	@Size(min = 1, max = 1, message = "El Flag de estado solo debe ser de 1 caracter")
    private String flagEstado;
}
