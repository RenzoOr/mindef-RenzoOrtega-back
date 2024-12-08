package com.mindefexamen.renzoortega.dominio.embedables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlagEstado {
	@Column(name ="flag_estado", length = 1, nullable = false, columnDefinition = "bpchar(1) DEFAULT '1'")
	private String flagEstado;
}
