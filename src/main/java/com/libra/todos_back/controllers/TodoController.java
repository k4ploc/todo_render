package com.libra.todos_back.controllers;

import com.libra.todos_back.model.Todo;
import com.libra.todos_back.model.TodoRequest;
import com.libra.todos_back.model.TodoUpdateRequest;
import com.libra.todos_back.todo.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoRequest request) {
        todoService.createTodo(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity checkUncheck(@PathVariable Long id) {
        todoService.checkUncheck(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) throws ClassNotFoundException {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity checkUncheck(@RequestBody TodoUpdateRequest request) {
        System.out.println(request);
        todoService.updateTodo(request);
        return ResponseEntity.ok().build();
    }
}
