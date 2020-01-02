package com.telefonica.entityservice.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.telefonica.entityservice.models.entities.Entidad;

public interface IJPAEntidadDao extends JpaRepository<Entidad, Long> {
	
	Entidad findByNombre(String nombre);
	
}
