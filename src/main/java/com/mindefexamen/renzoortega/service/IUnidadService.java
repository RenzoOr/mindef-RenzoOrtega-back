package com.mindefexamen.renzoortega.service;

import java.util.List;

import com.mindefexamen.renzoortega.dtos.UnidadDTO;

public interface IUnidadService {
	
	public UnidadDTO insertar(UnidadDTO unidadDto);
	public UnidadDTO update(UnidadDTO unidadDto);
	
	public List<UnidadDTO> getAll();
	
	public void eliminar(Long idCodUnidad);
	public UnidadDTO getById(Long idCodUnidad) throws Exception;
}
