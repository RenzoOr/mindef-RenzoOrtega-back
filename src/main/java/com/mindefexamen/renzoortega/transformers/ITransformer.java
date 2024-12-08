package com.mindefexamen.renzoortega.transformers;

import java.util.List;
import java.util.stream.Collectors;

import com.mindefexamen.renzoortega.dominio.ancestors.IModelEntity;
import com.mindefexamen.renzoortega.dtos.ancestors.AncestorDTO;

public interface ITransformer <E extends IModelEntity, D extends AncestorDTO> {
	public IModelEntity parserDtoToModel(AncestorDTO dto);
	public AncestorDTO parserModelToDto(IModelEntity model);
	
	// Método default que todas las implementaciones heredarán
	@SuppressWarnings("unchecked")
	default List<D> parserModelToDTO(List<E> lista) {
        return (List<D>) lista.stream()
                   .map(model -> parserModelToDto(model))
                   .collect(Collectors.toList());
    }
	
}

