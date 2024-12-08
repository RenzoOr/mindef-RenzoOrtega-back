package com.mindefexamen.renzoortega.dominio.model;

import java.io.Serializable;

import com.mindefexamen.renzoortega.dominio.ancestors.IModelEntity;
import com.mindefexamen.renzoortega.dominio.auditable.DataAuditable;
import com.mindefexamen.renzoortega.dominio.embedables.FlagEstado;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "t_m_unidad",
	uniqueConstraints = {
        @UniqueConstraint(name = "PK_T_M_UNIDAD", columnNames = "id_cod_unidad"),
        @UniqueConstraint(name = "UK_T_M_UNIDAD_NOMBRE", columnNames = "nombre")
	})
public class Unidad extends DataAuditable implements Serializable, IModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3540598256864918973L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_t_m_unidad")
    @SequenceGenerator(
        name = "seq_t_m_unidad",
        sequenceName = "seq_t_m_unidad",
        allocationSize = 1
    )
	@Column(name ="id_cod_unidad", columnDefinition = "NUMERIC(8,0)")
	private Long idCodUnidad;
	
	@Column(name ="nombre", length = 150, nullable = false)
	private String nombre;
	
	@Column(name ="sigla", length = 20, nullable = false)
	private String sigla;
	
	@Embedded
    private FlagEstado flagEstado;
	
	public void setFlagEstado(String value) {
		if (this.flagEstado == null) {
			this.flagEstado = FlagEstado.builder().flagEstado(value).build();
		}
		
		this.flagEstado.setFlagEstado(value);
	}

}

