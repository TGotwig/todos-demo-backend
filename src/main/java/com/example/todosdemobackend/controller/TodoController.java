package com.example.todosdemobackend.controller;

import com.example.todosdemobackend.MongoService;
import com.example.todosdemobackend.entity.Todo;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RestController
public class TodoController implements WebMvcConfigurer {

    @GetMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo getTodo(@PathVariable String id) { return MongoService.getTodo(id); }

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> getTodos() { return MongoService.getTodos(); }

    @PutMapping(path = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo putTodo(@RequestBody Todo todo) { return MongoService.putTodo(todo); }

    @DeleteMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> deleteTodo(@PathVariable String id) { return MongoService.deleteTodo(id); }

    @PostMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable String id) {
        todo.setId(id);
        System.out.println(todo);
        return MongoService.updateTodo(todo);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

}
