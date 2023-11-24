package com.littlemonkey.todoapp.controllers;

import com.littlemonkey.todoapp.entities.Todo;
import com.littlemonkey.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public Iterable<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addTodo(@RequestBody Todo todo) {
        try {
            todoService.addTodo(todo);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Error e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> deleteTodo(@RequestParam String id) {
        try {
            todoService.deleteTodo(Long.valueOf(id));
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(e);
        }
    }

}
