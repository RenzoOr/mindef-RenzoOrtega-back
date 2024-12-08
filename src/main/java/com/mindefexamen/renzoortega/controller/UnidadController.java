package com.mindefexamen.renzoortega.controller;

import org.slf4j.LoggerFactory;

import java.net.URI;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefexamen.renzoortega.dtos.UnidadDTO;
import com.mindefexamen.renzoortega.service.IUnidadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/unidades")
public class UnidadController {

	@Autowired 
	private IUnidadService unidadService;
	
	private Logger log = LoggerFactory.getLogger(UnidadController.class.getName());
	
	@PostMapping("/")
	public ResponseEntity<?> insertar(@Valid @RequestBody UnidadDTO unidadDTO){
		log.debug("UnidadController.insertar() ==================> INICIO <==================");
		try {
			
			UnidadDTO retorno = unidadService.insertar(unidadDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.insertar() ==================> FIN <==================");
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long idCodUnidad){
		log.debug("UnidadController.eliminar() ==================> INICIO <==================");
		try {
			
			unidadService.eliminar(idCodUnidad);
			return ResponseEntity.status(HttpStatus.CREATED).body("Registro eliminado satisfactoriamente");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.eliminar() ==================> FIN <==================");
		}
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		log.debug("UnidadController.getAll() ==================> INICIO <==================");
		try {
			
			List<UnidadDTO> listaRetorno = unidadService.getAll();
			return ResponseEntity.status(HttpStatus.CREATED).body(listaRetorno);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.getAll() ==================> FIN <==================");
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long idCodUnidad){
		log.debug("UnidadController.getAll() ==================> INICIO <==================");
		try {
			
			UnidadDTO objRetorno = unidadService.getById(idCodUnidad);
			return ResponseEntity.status(HttpStatus.OK).body(objRetorno);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.getAll() ==================> FIN <==================");
		}
		
	}	
	
	
	@PutMapping("/")
	public ResponseEntity<?> update(@RequestBody UnidadDTO unidadDTO){
	    log.debug("UnidadController.update() ==================> INICIO <==================");
	    try {
	        unidadService.update(unidadDTO);
	        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.OK);
	        problemDetail.setTitle("Operación Exitosa");
	        problemDetail.setDetail("La unidad ha sido actualizada correctamente");
	        problemDetail.setInstance(URI.create("/api/unidades/"));
	        problemDetail.setProperty("timestamp", new Date());
	        problemDetail.setProperty("entity", "UnidadDTO");
	        problemDetail.setProperty("id", unidadDTO.getIdCodUnidad());
	        
	        return ResponseEntity.created(null).body(problemDetail);
	        
	    } catch(Exception ex) {
	        ex.printStackTrace();
	        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
	        problemDetail.setTitle("Error en la Operación");
	        problemDetail.setDetail("Ha ocurrido un error: " + ex.getMessage());
	        problemDetail.setInstance(URI.create("/api/unidades/"));
	        problemDetail.setProperty("timestamp", Instant.now());
	        
	        return ResponseEntity.badRequest().body(problemDetail);
	    } finally {
	        log.debug("UnidadController.update() ==================> FIN <==================");
	    }
	}
	
	@PutMapping("/desactivarUnidad")
	public ResponseEntity<?> desactivarUnidad(@RequestBody UnidadDTO unidadDTO){
	    log.debug("UnidadController.desactivarUnidad() ==================> INICIO <==================");
	    try {
	        unidadDTO.setFlagEstado("0");
	        unidadService.update(unidadDTO);
	        
	        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.OK);
	        problemDetail.setTitle("Operación Exitosa");
	        problemDetail.setDetail("La unidad ha sido desactivada correctamente");
	        problemDetail.setInstance(URI.create("/api/unidades/desactivarUnidad"));
	        problemDetail.setProperty("timestamp", Instant.now());
	        problemDetail.setProperty("entity", "Unidad");
	        problemDetail.setProperty("id", unidadDTO.getIdCodUnidad());
	        problemDetail.setProperty("estado", "Desactivado");
	        
	        return ResponseEntity.ok().body(problemDetail);
	    } catch(Exception ex) {
	        ex.printStackTrace();
	        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
	        problemDetail.setTitle("Error en la Operación");
	        problemDetail.setDetail("Ha ocurrido un error: " + ex.getMessage());
	        problemDetail.setInstance(URI.create("/api/unidades/desactivarUnidad"));
	        problemDetail.setProperty("timestamp", Instant.now());
	        
	        return ResponseEntity.badRequest().body(problemDetail);
	    } finally {
	        log.debug("UnidadController.desactivarUnidad() ==================> FIN <==================");
	    }
	}
	
	@PutMapping("/activarUnidad")
	public ResponseEntity<?> activarUnidad(@RequestBody UnidadDTO unidadDTO){
	    log.debug("UnidadController.activarUnidad() ==================> INICIO <==================");
	    try {
	        unidadDTO.setFlagEstado("1");
	        unidadService.update(unidadDTO);
	        
	        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.OK);
	        problemDetail.setTitle("Operación Exitosa");
	        problemDetail.setDetail("La unidad ha sido activada correctamente");
	        problemDetail.setInstance(URI.create("/api/unidades/activarUnidad"));
	        problemDetail.setProperty("timestamp", Instant.now());
	        problemDetail.setProperty("entity", "Unidad");
	        problemDetail.setProperty("id", unidadDTO.getIdCodUnidad());
	        problemDetail.setProperty("estado", "Activado");
	        
	        return ResponseEntity.ok().body(problemDetail);
	    } catch(Exception ex) {
	        ex.printStackTrace();
	        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
	        problemDetail.setTitle("Error en la Operación");
	        problemDetail.setDetail("Ha ocurrido un error: " + ex.getMessage());
	        problemDetail.setInstance(URI.create("/api/unidades/activarUnidad"));
	        problemDetail.setProperty("timestamp", Instant.now());
	        
	        return ResponseEntity.badRequest().body(problemDetail);
	    } finally {
	        log.debug("UnidadController.activarUnidad() ==================> FIN <==================");
	    }
	}

}