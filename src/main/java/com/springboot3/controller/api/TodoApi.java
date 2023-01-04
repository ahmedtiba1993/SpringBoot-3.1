package com.springboot3.controller.api;
import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot3.dto.TodoDto;
import com.springboot3.user.Role;

public interface TodoApi {

	@PostMapping(value = "todo/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	TodoDto save(@RequestBody TodoDto dto);
	
	@GetMapping(value = "todo/id/{idTodo}")
	TodoDto findById(@PathVariable("idTodo") Integer id);
	
	@GetMapping(value ="todos/all")
	List<TodoDto> findAll();
	
	@DeleteMapping(value ="todo/delete/{idTodo}")
	void delete (@PathVariable("idTodo") Integer id);
	
	
}
