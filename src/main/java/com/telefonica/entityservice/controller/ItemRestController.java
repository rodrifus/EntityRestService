package com.telefonica.entityservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.entityservice.models.dtos.ItemDTO;
import com.telefonica.entityservice.models.entities.Item;
import com.telefonica.entityservice.models.services.impl.ItemServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Servicios para consulta de Items ", description = " Consulta de Items  con nombre de entidad y valor del alias")

@RequestMapping("/entity-api")
public class ItemRestController {

	@Autowired
	private ItemServiceImpl itemService;
	

	@ApiOperation(value = "Obtener una Item por su nombre de entidad y alias", response = Item.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "Se obtuvo el item solicitado"),
			@ApiResponse(code = 404, message = "No existe el item para los valores solicitados") })
	@GetMapping("/items")
	public ResponseEntity<?> findItemsByEntityAndAlias(
			@RequestParam(value="nombreEntidad" , defaultValue = "" )String nombreEntidad,
			@RequestParam(value="nombreAlias" , defaultValue = "" )String nombreAlias){
		
		Optional<?> opt = itemService.findByIds(nombreEntidad,nombreAlias);
		
		
		return opt.get().getClass() == ItemDTO.class? 
					new ResponseEntity<ItemDTO>((ItemDTO) opt.get() , HttpStatus.OK):
					new ResponseEntity<String>(opt.get().toString(), HttpStatus.NOT_FOUND);
		}
	
	
}
