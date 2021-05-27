package com.cts.training.micro.catalogservice.dto;

import java.util.List;

public class CatalogDtoData {

	private Integer userId;
	private List<Catalog> catalogs;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Catalog> getCatalogs() {
		return catalogs;
	}
	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}
	
	
}
