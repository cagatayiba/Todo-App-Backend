package com.cagatayiba.todoApp.restApi;

import com.cagatayiba.todoApp.business.TodoHardCodedService;
import com.cagatayiba.todoApp.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TodoController {
    private TodoHardCodedService todoHardCodedService;

    @Autowired
    public TodoController(TodoHardCodedService todoHardCodedService) {
        this.todoHardCodedService = todoHardCodedService;
    }
    
    
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoHardCodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodd(@PathVariable String username,@PathVariable long id){
        return todoHardCodedService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> delete(@PathVariable String username, @PathVariable long id){
        Todo todo = todoHardCodedService.deleteById(id);
        if(todo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable
                                           long id, @RequestBody Todo todo){
        Todo returned = todoHardCodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo returned = todoHardCodedService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(returned.getId()).toUri();

        return ResponseEntity.created(uri).build();


    }


}
