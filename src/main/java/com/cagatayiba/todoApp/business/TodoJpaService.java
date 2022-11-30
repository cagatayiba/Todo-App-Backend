package com.cagatayiba.todoApp.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.cagatayiba.todoApp.dataAccess.TodoJpaRepository;

public class TodoJpaService {
	
	@Autowired
	TodoJpaRepository todoRepository;
	
	
}
