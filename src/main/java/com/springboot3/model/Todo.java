package com.springboot3.model;

import java.util.Date;
import java.util.List;

import com.springboot3.user.Role;
import com.springboot3.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="todo")
public class Todo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	private String libelle;

	private String description;
	

}
