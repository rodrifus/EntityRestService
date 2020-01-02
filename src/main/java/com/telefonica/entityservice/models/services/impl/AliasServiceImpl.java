package com.telefonica.entityservice.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.entityservice.models.dao.IJPAAliasDao;
import com.telefonica.entityservice.models.entities.Alias;


@Service
public class AliasServiceImpl extends ServiceDTO {

		@Autowired
		IJPAAliasDao aliasDao;
		
		public List<Alias> findByName(String name) {			
			return aliasDao.findByValor(name);
		}
		
}
