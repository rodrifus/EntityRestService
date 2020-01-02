package com.telefonica.entityservice.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.telefonica.entityservice.models.entities.Entidad;

public interface ICRUDEntidadDao extends CrudRepository<Entidad, Long> {
		
}
