package com.springboot3.service;

import java.util.List;

import com.springboot3.dto.TodoDto;


public interface TodoService {

	TodoDto save(TodoDto dto);
	
	TodoDto findById(Integer id);
	
	List<TodoDto> findAll();
	
	void delete (Integer id);
}
