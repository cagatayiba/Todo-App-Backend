package com.cagatayiba.todoApp.restApi;

import org.springframework.stereotype.Component;

@Component
public class HelloDTO {
	String str = "hello ";
	
	public HelloDTO() {
	}

	public HelloDTO(String str) {
		//super();
		this.str += str;
	}
	public String getStr() {
        return str;
    }
	
	
}
