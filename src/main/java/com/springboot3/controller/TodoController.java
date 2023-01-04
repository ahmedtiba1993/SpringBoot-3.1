package com.springboot3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot3.controller.api.TodoApi;
import com.springboot3.dto.TodoDto;
import com.springboot3.service.TodoService;


@RestController
@CrossOrigin
public class TodoController implements TodoApi{

	private TodoService todoService;
	
	@Autowired	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@Override
	public TodoDto save(TodoDto dto) {
		return todoService.save(dto);
	}

	@Override
	public TodoDto findById(Integer id) {
		return todoService.findById(id);
	}

	@Override
	public List<TodoDto> findAll() {
		return todoService.findAll();
	}

	@Override
	public void delete(Integer id) {
		todoService.delete(id);
	}


}
