package com.mindefexamen.renzoortega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindefexamen.renzoortega.dominio.model.Unidad;
@Repository
public interface IUnidadRepository extends JpaRepository<Unidad, Long>{
	List<Unidad> findAllByOrderByIdCodUnidadAsc();
}
