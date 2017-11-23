package com.inventory.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // create a single tone service 
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(p -> products.add(p));
		return products;
	}
	
	public Product getProduct(String id) {
		return productRepository.findOne(id);
	}
	
	public boolean addProduct(Product product) { 
		productRepository.save(product);
		return true;
	}

	public boolean updateProduct(Product product, String id) { 
		productRepository.save(product);	
		return true;
	}

	public boolean deleteProduct(String id) {
		productRepository.delete(id);
		return true;
	}

	
}
