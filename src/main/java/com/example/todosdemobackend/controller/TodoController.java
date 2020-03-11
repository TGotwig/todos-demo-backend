package com.example.todosdemobackend.controller;

import com.example.todosdemobackend.MongoService;
import com.example.todosdemobackend.entity.Todo;
import com.example.todosdemobackend.entity.TodoContent;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RestController
@RequestMapping("/api")
public class TodoController implements WebMvcConfigurer {

    @GetMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo getTodo(@PathVariable String id) {
        return MongoService.getTodo(id);
    }

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> getTodos() {
        return MongoService.getTodos();
    }

    @PutMapping(path = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo putTodo(@RequestBody TodoContent todo) {
        return MongoService.putTodo(todo);
    }

    @DeleteMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> deleteTodo(@PathVariable String id) {
        return MongoService.deleteTodo(id);
    }

    @DeleteMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> deleteTodos() {
        return MongoService.deleteTodos();
    }

    @PostMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo updateTodo(@RequestBody TodoContent todo, @PathVariable String id) {
        return MongoService.updateTodo(new Todo(id, todo));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
    }

}
