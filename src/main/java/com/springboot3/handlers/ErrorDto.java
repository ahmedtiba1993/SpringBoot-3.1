package com.springboot3.handlers;

import java.util.ArrayList;
import java.util.List;

import com.springboot3.exception.ErrorCodes;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {

	private Integer httpCode;
	
	private ErrorCodes code;
	
	private String message; 
	
	private List<String> errors = new ArrayList<>();
}
