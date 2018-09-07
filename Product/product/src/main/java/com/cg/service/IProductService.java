package com.cg.service;

import java.util.List;

import com.cg.bean.Product;

import com.cg.exception.ProductException;

public interface IProductService {
	public Product addProduct(Product product) throws ProductException; 
	public String delProduct(String id) throws ProductException;
	public List<Product> viewProduct() throws ProductException;
	public Product viewById(String id) throws ProductException;
	public String update(Product product) throws ProductException; 
	public Boolean validateProduct(Product product) throws ProductException ;

	
}
