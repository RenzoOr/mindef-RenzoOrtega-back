package com.mindefexamen.renzoortega.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindefexamen.renzoortega.controller.UnidadController;
import com.mindefexamen.renzoortega.dominio.model.Unidad;
import com.mindefexamen.renzoortega.dtos.UnidadDTO;
import com.mindefexamen.renzoortega.repository.IUnidadRepository;
import com.mindefexamen.renzoortega.service.IUnidadService;
import com.mindefexamen.renzoortega.transformers.impl.UnidadTransformer;

@Service
public class UnidadServiceImpl implements IUnidadService{

private Logger log = LoggerFactory.getLogger(UnidadController.class.getName());
	
	@Autowired
	private IUnidadRepository unidadRepository;
	
	@Override
	public UnidadDTO insertar(UnidadDTO unidadDto) {
		
		Unidad unidad = (Unidad) UnidadTransformer.builder().build().parserDtoToModel(unidadDto);
		
		unidad.setCreadoPor("SYSTEM");
		unidad.setFechaCreacion(LocalDateTime.now());
		
		unidadRepository.save(unidad);
		
		UnidadDTO dtoRetorno = (UnidadDTO) UnidadTransformer.builder().build().parserModelToDto(unidad);
		
		return dtoRetorno;
	}
	
	@Override
	public UnidadDTO update(UnidadDTO unidadDto) {
		
		Unidad unidad = (Unidad) UnidadTransformer.builder().build().parserDtoToModel(unidadDto);
		
		unidad.setModificadoPor("SYSTEM");
		unidad.setFechaModificacion(LocalDateTime.now());
		
		//Gson gson = new Gson();
		//log.info("Unidad-Model: " + gson.toJson(unidad) );
		//log.info("Unidad-DTO: " + gson.toJson(unidadDto) );
		
		unidadRepository.save(unidad);
		
		UnidadDTO dtoRetorno = (UnidadDTO) UnidadTransformer.builder().build().parserModelToDto(unidad);
		
		return dtoRetorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadDTO> getAll() {
		List<Unidad> lista = unidadRepository.findAllByOrderByIdCodUnidadAsc();
		
		List<UnidadDTO> listaRetorno = UnidadTransformer.builder().build().parserModelToDTO(lista);
		
		return listaRetorno;
	}

	@Override
	public void eliminar(Long idCodUnidad) {
		
		unidadRepository.deleteById(idCodUnidad);
		
	}

	@Override
	public UnidadDTO getById(Long idCodUnidad) throws Exception {
		Optional<Unidad> optUnidad = unidadRepository.findById(idCodUnidad);
		
		if (optUnidad.isEmpty())
			throw new Exception ("No existe la unidad con codigo " + idCodUnidad.toString());
		
		UnidadDTO unidadDto = (UnidadDTO) UnidadTransformer.builder().build().parserModelToDto(optUnidad.get());
		
		return unidadDto;
	}

}
