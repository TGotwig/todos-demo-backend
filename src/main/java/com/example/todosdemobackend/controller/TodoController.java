package com.example.todosdemobackend.controller;

import com.example.todosdemobackend.MongoService;
import com.example.todosdemobackend.entity.Todo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @GetMapping(path = "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo getTodo(@PathVariable String id) { return MongoService.getTodo(id); }

    @GetMapping(path = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> getTodos() { return MongoService.getTodos(); }

    @PutMapping(path = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo putTodo(@RequestBody Todo todo) { return MongoService.putTodo(todo); }

    @DeleteMapping(path = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Todo> deleteTodo(@RequestBody Todo todo) { return MongoService.deleteTodo(todo); }

    @PostMapping(path = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public Todo updateTodo(@RequestBody Todo todo) { return MongoService.updateTodo(todo); }

}
