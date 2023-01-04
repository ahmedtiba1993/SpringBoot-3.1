package com.springboot3.dto;


import com.springboot3.model.Todo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TodoDto {

	private Integer id;

	private String libelle;
	
	private String description;
	

	public static TodoDto fromEntity(Todo todo) {
		
		if(todo == null) {
			return null;
		}
		return TodoDto.builder()
				.id(todo.getId())
				.libelle(todo.getLibelle())
				.description(todo.getDescription())
				.build();
	}
	
public static Todo toEntity(TodoDto dto) {
		
		if(dto == null) {
			return null;
		}
		

		Todo todo = new Todo();
		todo.setId(dto.getId());
		todo.setLibelle(dto.getLibelle());
		todo.setDescription(dto.getDescription());
		
		return todo;
	}
}
