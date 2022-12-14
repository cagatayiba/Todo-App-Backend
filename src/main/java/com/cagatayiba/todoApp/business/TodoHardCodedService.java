package com.cagatayiba.todoApp.business;

import com.cagatayiba.todoApp.entities.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {
    private static List<Todo> todos = new ArrayList<>();
    private static Long counter = 0L;

    static{
        todos.add(new Todo(++counter, "cagatay", "learn dance", new Date(), false));
        todos.add(new Todo(++counter, "cagatay", "learn react", new Date(), false));
        todos.add(new Todo(++counter, "cagatay", "learn spring", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo save(Todo todo){
        if (todo.getId() == -1 || todo.getId() == 0) {
            System.out.printf("the default id is %d\n", todo.getId());
            todo.setId(++counter);
            todos.add(todo);
        }else{
            this.deleteById(todo.getId());
            todos.add(todo);
        }

        return todo;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);
        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for(Todo token : todos ){
            if(token.getId()==id){
                return token;
            }
        }
        return null;
    }
}
