package com.mindefexamen.renzoortega.dtos.ancestors;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AncestorDTO {
	
	@JsonProperty(index = 900)
	private String creadoPor;
	
	@JsonProperty(index = 901)
	private LocalDateTime fechaCreacion;
	
	@JsonProperty(index = 902)
	private String modificadoPor;
	
	@JsonProperty(index = 903)
	private LocalDateTime fechaModificacion;
}

