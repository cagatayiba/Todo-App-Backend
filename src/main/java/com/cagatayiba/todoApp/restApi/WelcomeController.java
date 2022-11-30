package com.cagatayiba.todoApp.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WelcomeController {
	private HelloDTO HelloDTO;

    @Autowired
    public WelcomeController(HelloDTO HelloDTO) {
        this.HelloDTO = HelloDTO;
    }

    @GetMapping("/")
    public String home(){
        return "welcome the api";
    }

    @GetMapping("/hello/{name}")
    public HelloDTO hello(@PathVariable String name){
        return new HelloDTO(name);
    }

    


}
