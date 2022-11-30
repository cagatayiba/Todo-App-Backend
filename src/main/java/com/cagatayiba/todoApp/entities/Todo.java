package com.cagatayiba.todoApp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue
    private Long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

    
    public Todo(Long id, String username, String description, Date date, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = date;
        this.isDone = isDone;
    }
    

    protected Todo(){

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.targetDate = date;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }if(object == null){
            return false;
        }
        if(getClass() != object.getClass()) {
            return false;
        }else{
            Todo other = (Todo) object;
            if(getId()== other.getId()){
                return true;
            }else{
                return false;
            }
        }
    }
}

