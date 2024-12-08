package com.mindefexamen.renzoortega.transformers.impl;

import com.mindefexamen.renzoortega.dominio.ancestors.IModelEntity;
import com.mindefexamen.renzoortega.dominio.model.Unidad;
import com.mindefexamen.renzoortega.dtos.UnidadDTO;
import com.mindefexamen.renzoortega.dtos.ancestors.AncestorDTO;
import com.mindefexamen.renzoortega.transformers.ITransformer;

import lombok.Builder;

@Builder
public class UnidadTransformer implements ITransformer<Unidad, UnidadDTO>{

	@Override
	public IModelEntity parserDtoToModel(AncestorDTO dto) {
		
		Unidad unidad = new Unidad();
		UnidadDTO unidadDto = (UnidadDTO) dto;
		
		unidad.setIdCodUnidad(unidadDto.getIdCodUnidad());
		unidad.setNombre(unidadDto.getNombre());
		unidad.setSigla(unidadDto.getSigla());
		unidad.setFlagEstado("1");
		
		return unidad;
	}

	@Override
	public AncestorDTO parserModelToDto(IModelEntity model) {
		UnidadDTO unidadDto = new UnidadDTO();
		Unidad unidad = (Unidad) model;
		
		unidadDto.setNombre(unidad.getNombre());
		unidadDto.setSigla(unidad.getSigla());
		unidadDto.setFlagEstado(unidad.getFlagEstado().getFlagEstado());
		unidadDto.setIdCodUnidad(unidad.getIdCodUnidad());
		
		
		unidadDto.setCreadoPor(unidad.getCreadoPor());
		unidadDto.setFechaCreacion(unidad.getFechaCreacion());
		unidadDto.setModificadoPor(unidad.getModificadoPor());
		unidadDto.setFechaModificacion(unidad.getFechaModificacion());
		
		return unidadDto;
	}

}
