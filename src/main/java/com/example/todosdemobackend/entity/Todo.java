package com.example.todosdemobackend.entity;

public class Todo extends TodoContent {
    private String id;

    public Todo(String id, String text) {
        super(text);
        this.id = id;
    }

    public Todo(String id, TodoContent todo) {
        super(todo.getText());
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
