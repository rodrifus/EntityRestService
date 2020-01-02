package com.telefonica.entityservice.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telefonica.entityservice.models.entities.Item;

public interface IJPAItemDao extends JpaRepository<Item, Long>{
	
	@Query("Select i from Item i , Entidad e , Alias ali WHERE i.id = e.id AND ali.id = i.id AND e.nombre = ?1 AND ali.valor = ?2 ")
	Item findItemsByEntityNameAndAliasName(String entityName , String aliasName); 
	

	@Query("Select i from Item i , Entidad e , Alias ali WHERE e.id = ?1 AND ali.id = ?2 AND i.id = ali.id")
	Item findItemsByIds(Long idEnt , Long idAli); 

}
