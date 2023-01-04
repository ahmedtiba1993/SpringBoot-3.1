package com.springboot3.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot3.dto.TodoDto;
import com.springboot3.exception.ErrorCodes;
import com.springboot3.exception.InvalidEntityException;
import com.springboot3.model.Todo;
import com.springboot3.repository.TodoRepository;
import com.springboot3.service.TodoService;
import com.springboot3.validator.TodoValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService{

	private TodoRepository todoRepository;
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@Override
	public TodoDto save(TodoDto dto) {
		
		List<String> errors = TodoValidator.validate(dto);
				
		if(!errors.isEmpty()) {
			throw new InvalidEntityException("todo n'est pas valide",ErrorCodes.TODO_NOT_VALID,errors);
		}
		
		return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(dto)));

	}

	@Override
	public TodoDto findById(Integer id) {
		if(id == null) {
			return null;
		}
		
		Optional<Todo> todo = todoRepository.findById(id);
		TodoDto dto = TodoDto.fromEntity(todo.get());
		
		
		return Optional.of(dto).orElseThrow(() ->
			new NoSuchElementException("SomelogicalDescription")
		);
	}

	@Override
	public List<TodoDto> findAll() {

		return todoRepository.findAll().stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if (id == null) {
			return;
		}
		
		todoRepository.deleteById(id);
	}

}