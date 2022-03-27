package com.example.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.entities.Product;
import com.example.stock.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		Product prod = productService.saveProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(prod);
	}

	@PutMapping(path = "/{id}")
	public Product updateProduct(@PathVariable String id, @RequestBody Product product) {

		return productService.updateProduct(id, product);

	}

	@GetMapping
	public List<Product> listProducts() {
		return productService.listProducts();
	}

	@GetMapping(path = "/{id}")
	public Product searchProduct(@PathVariable String id) {

		return productService.searchProductById(id);

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable String id) {

		return productService.deleteProductById(id);

	}

}
