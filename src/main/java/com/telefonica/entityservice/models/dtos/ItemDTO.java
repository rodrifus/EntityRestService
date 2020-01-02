package com.telefonica.entityservice.models.dtos;

import java.util.List;

public class ItemDTO {
	
	private String nombreItem;
	private List<AliasDTO> alias;


	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public List<AliasDTO> getAlias() {
		return alias;
	}

	public void setAlias(List<AliasDTO> alias) {
		this.alias = alias;
	}

}
