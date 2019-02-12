package com.reciepe.ReciepeEx;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingredients")
public class Ingredients {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Iid;
	private String ingredients;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "ingredient")
	@JsonIgnore
	private ReciepePojo pojo;

	public ReciepePojo getPojo() {
		return pojo;
	}

	public void setPojo(ReciepePojo pojo) {
		this.pojo = pojo;
	}

	 

	public Integer getIid() {
		return Iid;
	}

	public void setIid(Integer iid) {
		Iid = iid;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

}
