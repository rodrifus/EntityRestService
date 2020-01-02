package com.telefonica.entityservice.models.services;

import java.util.List;

import com.telefonica.entityservice.models.dtos.EntidadDTO;
import com.telefonica.entityservice.models.entities.Entidad;

public interface IEntidadService  {
	
	public List<EntidadDTO> findAll();
	
	public void delete (Long id);

	public EntidadDTO findById(Long id );
	
	
	public EntidadDTO findByNombre(String nombre);
	
	public void saveOrUpdate(Entidad e);
}
