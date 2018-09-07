
	package com.cg.service;

	import java.util.List;
/**
 * Class Name:ProductServiceImpl
 * Number of methods:6
 * Name of methods:addProduct(),delProduct(),viewProduct(),viewById(),update(),validateProduct()
 * @author Jeevana
 * Date of creation:08/08/2018
 */

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.cg.bean.Product;

import com.cg.exception.ProductException;
import com.cg.repo.ProductRepo;
	@Service
	public class ProductServiceImpl implements IProductService {
		@Autowired
	private ProductRepo repo;
		
		@Override
		public Product addProduct(Product product) throws ProductException {
			if(repo.findById(product.getId()).isPresent())
			{
				throw new ProductException("Product with Id "+ product.getId()+" already exists in the database");
			}
			if(validateProduct(product))
			{
			repo.save(product);
			}
			
			
			return product;
		}
		
		@Override
		public String delProduct(String id) throws ProductException {
			if(id.isEmpty())
			{
			throw new ProductException("Product Id should not be blank");
			}
		else if(!(repo.findById(id).isPresent()))
		{
			throw new ProductException("Product Id does not exist in the database");
		}
			repo.deleteById(id);
			return id;
			
		}
		@Override
		public List<Product> viewProduct() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}
		@Override
		public Product viewById(String id) throws ProductException {
			if(id.isEmpty())
			{
				throw new ProductException("Product Id should not be blank");
			}
			else if(!(repo.findById(id).isPresent()))
			{
				throw new ProductException("Product Id does not exist in the database");
			}
			return repo.getOne(id);
		}
				@Override
		public String update(Product product) throws ProductException {
			// TODO Auto-generated method stub
					Product product1 =new Product();
					if(validateProduct(product))
					{
				
			  product1=repo.getOne(product.getId());
			  product1.setName(product.getName());
			  product1.setModel(product.getModel());
			  product1.setPrice(product.getPrice());
			  product1.setManufacturingDate(product.getManufacturingDate());
				
				repo.save(product1);
					}
			return product1.getId();
		}
				
				@Override
				public Boolean validateProduct(Product product) throws ProductException {
					if(product.getId().isEmpty())
					{
						throw new ProductException("Product Id should not be blank");
					}
					if(product.getName().isEmpty())
					
					{
						throw new ProductException("Product name should not be blank");
					}

					if(product.getModel().isEmpty())
					{
						throw new ProductException("model cannot be blank");
					}
					if(product.getPrice()<=0)
					{
						throw new ProductException("Price should be greater than or equal to zero");
					}
				 
					return true;
				
				
				}
	}


