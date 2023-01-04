package com.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot3.model.Todo;


public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
