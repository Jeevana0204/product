package com.cg.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Product;
import com.cg.exception.ProductException;
import com.cg.service.IProductService;
import com.cg.service.ProductServiceImpl;
@RestController
public class Controller {
	@Autowired
	private IProductService service=new ProductServiceImpl();
	/*@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) throws ProductException
	{
	try {
		service.addProduct(product);
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		throw new ProductException(e.getMessage());
	}	
		return product;
		
	}*/
	/*@RequestMapping(method=RequestMethod.GET,value= {"/sayHello"},produces= {"application/text"})
	public ResponseEntity<String> getHelloMessage()
	{
		return new ResponseEntity<String>("Hello World from RestFulWebService",HttpStatus.OK);
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Product> addProduct(@ModelAttribute Product product) throws ProductException 
	{
	
	 return new ResponseEntity<Product>(service.addProduct(product), HttpStatus.OK);
		
	}*/
	@RequestMapping(value="/viewProduct",method=RequestMethod.GET,produces= {"application/JSON"})
	public ResponseEntity<List<Product>> viewProduct() throws ProductException
	{
		return new ResponseEntity<List<Product>>(service.viewProduct(),HttpStatus.OK);
	}
	@RequestMapping(value="/getOne",method=RequestMethod.GET,produces= {"application/JSON"})
	public ResponseEntity<Product> product(@PathParam(value="id")String id) throws ProductException
	{
		return new ResponseEntity<Product>(service.viewById(id),HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/delProduct",method=RequestMethod.DELETE)
	public String delProduct(String id) throws ProductException
	{
		try {
			return "Product with Id" +service.delProduct(id)+" has ben deleted successfully";
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			throw new ProductException(e.getMessage());
		}
		
	}*/
	/*@RequestMapping(value="/viewProduct")
	public List<Product> viewProduct() throws ProductException
	{
		try {
			return service.viewProduct();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			throw new ProductException(e.getMessage());
		}
		
	}*/
/*	@RequestMapping(value="/getOne")
	public Product viewById(String id) throws ProductException
	{
		try {
			return service.viewById(id);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			throw new ProductException(e.getMessage());		}
	}
*/	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public String update(@RequestBody Product product) throws ProductException
	{
	
			try {
				return "product with id "+service.update(product) + " updated successfully";
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				throw new ProductException(e.getMessage());
			}
			


}
}
