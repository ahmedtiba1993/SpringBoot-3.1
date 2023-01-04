package com.springboot3.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.springboot3.dto.TodoDto;


public class TodoValidator {

public static List<String> validate(TodoDto dto){
		
		List<String> errors = new ArrayList<String>();
		
		if(dto == null){
			
			errors.add("Veillez renseigner le libelle");
			errors.add("Veillez renseigner la description");

		}
		
		if(!StringUtils.hasLength(dto.getLibelle())) {
			errors.add("Veillez renseigner le libelle");
		}
		
		if(!StringUtils.hasLength(dto.getDescription())) {
			errors.add("Veillez renseigner la description");
		}
		
		
		
		return errors;
	}
}
