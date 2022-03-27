package com.example.stock.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Product {

	@Id
	private String id;
	@NotBlank
	private String name;
	@NotNull
	private double price;
	@NotBlank
	private String unity;
	@NotNull
	private double minStock;
	

}
