package com.example.stock.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.stock.entities.Product;
import com.example.stock.exceptions.UpdateNotAllowed;
import com.example.stock.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(@Valid Product product) {

		return productRepository.save(product);

	}

	public Product updateProduct(@PathVariable String id, @Valid Product product) {
		Product chosenProduct = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id not found " + id));

		if (product == chosenProduct) {

			throw new UpdateNotAllowed("Doesnt change any field, so you can't update the product");
		}

		BeanUtils.copyProperties(product, chosenProduct, "id");
		productRepository.save(chosenProduct);

		return chosenProduct;

	}

	public List<Product> listProducts() {

		List<Product> list = productRepository.findAll();

		return list;

	}

	public Product searchProductById(@PathVariable String id) {

		Product chosenProduct = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id not found " + id));

		return chosenProduct;

	}

	public ResponseEntity<?> deleteProductById(@PathVariable String id) {

		Optional<Product> chosenProduct = Optional.of(
				productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found " + id)));

		if (chosenProduct.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

}
