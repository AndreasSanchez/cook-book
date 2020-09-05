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
@Table(name = "step")
public class Step {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "step")
	private String step;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receipe_id")
	private Receipe receipe;

	public Step() {

	}

	public Step(String step) {
		this.step = step;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Receipe getReceipe() {
		return receipe;
	}

	public void setReceipe(Receipe receipe) {
		this.receipe = receipe;
	}

//	@Override
//	public String toString() {
//		return "Step [id=" + getId() + ", step=" + getStep() + ", receipe=" + getReceipe() + "]";
//	}
	
	
}
