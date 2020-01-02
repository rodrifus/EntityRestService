package com.telefonica.entityservice.models.services;

import java.util.List;

import com.telefonica.entityservice.models.entities.Alias;

public interface AliasService {
	
	List<Alias> findByName(String name);

}
