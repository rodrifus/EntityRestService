package com.telefonica.entityservice.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telefonica.entityservice.models.entities.Alias;

public interface IJPAAliasDao extends JpaRepository<Alias, Long>{
		
		List<Alias> findByValor(String valor);
}
