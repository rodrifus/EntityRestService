package com.telefonica.entityservice.models.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.entityservice.models.dao.IJPAItemDao;
import com.telefonica.entityservice.models.dtos.ItemDTO;
import com.telefonica.entityservice.models.entities.Alias;
import com.telefonica.entityservice.models.services.IItemService;

@Service
public class ItemServiceImpl extends ServiceDTO implements IItemService{
	
	@Autowired
	IJPAItemDao itemDao;
	
	@Autowired
	private AliasServiceImpl aliasService;
	
	@Autowired 
	private EntidadServiceImpl entidadService ;
	
	
	public ItemDTO findItemByEntityAndAlias(String entityName, String aliasName ) {
		
		return super.DTOConverter(itemDao.findItemsByEntityNameAndAliasName(entityName, aliasName),ItemDTO.class);
		
	}
	
	public Optional<?> findByIds (String nombreEntidad,String nombreAlias) {
	
		if(entidadService.findByNombre(nombreEntidad) == null) {
			return	Optional.of("La entidad No existe en la base de datos");
		} 
		if(aliasService.findByName(nombreAlias).isEmpty()){
			return	Optional.of("El Alias No existe en la base de datos");
		}
		
		List<Alias> alias =  aliasService.findByName(nombreAlias).stream()
				.filter(t -> t.getItem().getEntidad().getId() == entidadService.findByNombre(nombreEntidad).getId())
				.collect(Collectors.toList());
		return Optional.of(super.DTOConverter(alias.get(0).getItem(),ItemDTO.class));
		
	}
	
}
