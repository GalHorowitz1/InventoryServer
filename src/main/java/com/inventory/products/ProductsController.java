package com.inventory.products;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  // mark as a spring rest controller who can handle api calls 
public class ProductsController {
	
	
	@Autowired
	private ProductService productService; 
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/products") 
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		return productService.getProduct(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST, value = "/product")
	public boolean addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.PUT , value = "/product/{id}")
	public boolean addProduct(@RequestBody Product product , @PathVariable String id) {
		return productService.updateProduct(product,id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.DELETE , value = "/product/{id}")
	public boolean addProduct(@PathVariable String id) {
		return productService.deleteProduct(id);
	}
	
	

}
