package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
public class Product {
	
@Id
private String id;
private String name;
private String model;
private Integer price;
private String manufacturingDate;
public String getManufacturingDate() {
	return manufacturingDate;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + ", manufacturingDate="
			+ manufacturingDate + "]";
}
public void setManufacturingDate(String manufacturingDate) {
	this.manufacturingDate = manufacturingDate;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
}
