package com.telefonica.entityservice.models.services;

import java.util.Optional;

public interface IItemService {

	Optional<?> findByIds (String nombreEntidad,String nombreAlias);
	
}
