package com.cagatayiba.todoApp.restApi;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cagatayiba.todoApp.dataAccess.TodoJpaRepository;
import com.cagatayiba.todoApp.entities.Todo;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/jpa/api")
public class TodoJpaController {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    
    
    
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoJpaRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodd(@PathVariable String username,@PathVariable long id){
        return todoJpaRepository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> delete(@PathVariable String username, @PathVariable long id){
    	todoJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable
                                           long id, @RequestBody Todo todo){
    	todo.setUsername(username);
    	Todo todoUpdated = todoJpaRepository.save(todo);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    			.path("/{id}").buildAndExpand(todoUpdated.getId()).toUri();
    	return ResponseEntity.created(uri).build();

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo returned = todoJpaRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(returned.getId()).toUri();

        return ResponseEntity.created(uri).build();


    }


}


