package com.sanchez.cookbook.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "ingredient")
	private String ingredient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipe_id")
	private Receipe receipe;
	
	public Ingredient() {
		
	}
	
	public Ingredient( String ingredient) {
		this.ingredient = ingredient;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Receipe getReceipe() {
		return receipe;
	}

	public void setReceipe(Receipe receipe) {
		this.receipe = receipe;
	}

//	@Override
//	public String toString() {
//		return "Ingredient [id=" + id + ", ingredient=" + ingredient + ", receipe=" + receipe + "]";
//	}
	
	
}
