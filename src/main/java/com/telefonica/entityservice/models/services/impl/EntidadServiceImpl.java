package com.telefonica.entityservice.models.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.entityservice.models.dao.ICRUDEntidadDao;
import com.telefonica.entityservice.models.dao.IJPAEntidadDao;
import com.telefonica.entityservice.models.dtos.EntidadDTO;
import com.telefonica.entityservice.models.entities.Entidad;
import com.telefonica.entityservice.models.services.IEntidadService;

@Service
public class EntidadServiceImpl extends ServiceDTO  implements IEntidadService {
	
	@Autowired
	ICRUDEntidadDao CRUDEntidadDao;
	
	@Autowired
	private IJPAEntidadDao JPAEntidadDao;

	@Transactional(readOnly = true)
	public List<EntidadDTO> findAll() {
		
		ModelMapper modelMapper = new ModelMapper();

		List<EntidadDTO> entidadesDTO = new ArrayList<EntidadDTO>();
		JPAEntidadDao.findAll().forEach(t -> {
			entidadesDTO.add( modelMapper.map(t, EntidadDTO.class));
		});
	
		
		return  entidadesDTO.isEmpty() ? null : entidadesDTO;
	}
	
	@Transactional(readOnly = true)
	public EntidadDTO findByNombre(String nombre) {
		
		return JPAEntidadDao.findByNombre(nombre) != null ? super.DTOConverter(JPAEntidadDao.findByNombre(nombre), EntidadDTO.class): null;
		
	}
	
	@Transactional
	public void saveOrUpdate(Entidad e) {
			CRUDEntidadDao.save(e);
	}
	
	@Transactional
	public void delete (Long id) {
		JPAEntidadDao.delete(JPAEntidadDao.findById(id).get());
	}

	@Override
	@Transactional(readOnly = true)
	public EntidadDTO findById(Long id) {
		return JPAEntidadDao.findById(id).isEmpty() ? null : super.DTOConverter(JPAEntidadDao.findById(id).get(), EntidadDTO.class);
	}
	

}
