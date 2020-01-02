package com.telefonica.entityservice.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="alias")
public class Alias implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ali_id")
	@JsonIgnore
	private Long id ;
	
	@ManyToOne
	@JoinColumn(name = "it_id")
	@JsonIgnore
	private Item item ;
	
	@NotNull(message = "el valor del alias es obligatorio")
    @ApiModelProperty(notes = "Valor | nombre del alias", required = true)
	private String valor ; 
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	
}
