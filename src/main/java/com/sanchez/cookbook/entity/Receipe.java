package com.sanchez.cookbook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "receipe")
public class Receipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receipe_id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "source")
	private String source;

	@OneToMany(mappedBy = "receipe", cascade = CascadeType.ALL)
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "receipe", cascade = CascadeType.ALL)
	private List<Step> steps;

	public Receipe() {

	}

	public Receipe(String title, String source) {
		super();
		this.title = title;
		this.source = source;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public void add(Step step) {
		if (steps == null) {
			steps = new ArrayList<>();
		}
		steps.add(step);
		step.setReceipe(this);
	}

	public void add(Ingredient ingredient) {
		if (ingredients == null) {
			ingredients = new ArrayList<>();
		}
		ingredients.add(ingredient);
		ingredient.setReceipe(this);
	}

	@Override
	public String toString() {
		return "Receipe [id=" + id + ", title=" + title + ", source=" + source + ", ingredients=" + ingredients
				+ ", steps=" + steps + "]";
	}

}
