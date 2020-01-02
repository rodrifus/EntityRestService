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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "items")
public class Item implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "it_id")
	@JsonIgnore

	private Long id;
	
	@NotNull(message = "El nombre del item es obligatorio")
    @ApiModelProperty(notes = "Nombre de item", required = true)
	private String nombreItem;

	@ManyToOne
	@JoinColumn(name ="ent_id")
	@JsonIgnore

	private Entidad entidad;

	@OneToMany(orphanRemoval=true , cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "it_id")
	@Valid
	@NotNull(message = "La lista de alias es obligatoria")
    @ApiModelProperty(notes = "Lista de alias", required = true)
	private List<Alias> alias;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public Entidad getEntidad() {
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public List<Alias> getAlias() {
		return alias;
	}

	public void setAlias(List<Alias> alias) {
		this.alias = alias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
