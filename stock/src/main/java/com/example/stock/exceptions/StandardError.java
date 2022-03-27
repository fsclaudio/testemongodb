package com.example.stock.exceptions;

import java.time.Instant;

import lombok.Data;

@Data
public class StandardError {

	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

}
