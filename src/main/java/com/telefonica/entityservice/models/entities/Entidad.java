package com.telefonica.entityservice.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.qos.logback.core.subst.Token.Type;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Entidad implements Serializable {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ent_id")
	private Long id;
	
	@NotEmpty(message = "El nombre de la entidad es obligatorio")
	@Column(unique = true)
    @ApiModelProperty(notes = "Nombre de la entidad, Unico e irrepetible",required = true)
	private String nombre;

	@OneToMany(orphanRemoval=true ,cascade=CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn(name = "ent_id" )
	@Valid
	@NotNull(message = "La lista de items es obligatorio")
    @ApiModelProperty(notes = "Lista de items", required = true)
	private List<Item> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
