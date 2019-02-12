package com.reciepe.ReciepeEx;

import java.util.List;

public class ReciepeDto {
	private String href;
	private List<String> ingredients;
	private String thumbnail;
	private String title;
	private Integer Iid;
	
	public Integer getIid() {
		return Iid;
	}

	public void setIid(Integer iid) {
		Iid = iid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;   
	}

	 
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
