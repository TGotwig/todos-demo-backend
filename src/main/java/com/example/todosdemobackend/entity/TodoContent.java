package com.example.todosdemobackend.entity;

public class TodoContent {
    private String text;

    public TodoContent() {}

    public TodoContent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TodoContent{" +
                "text='" + text + '\'' +
                '}';
    }
}
