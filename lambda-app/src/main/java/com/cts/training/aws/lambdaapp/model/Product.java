package com.cts.training.aws.lambdaapp.model;

public class Product {

	private Integer id;
	private String name;
	private String category;
	private Integer cost;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Integer id, String name, String category, Integer cost) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.cost = cost;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", cost=" + cost + "]";
	}
	
	
	
}
