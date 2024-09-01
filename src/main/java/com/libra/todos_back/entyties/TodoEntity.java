package com.libra.todos_back.entyties;

import com.libra.todos_back.model.PriorityTodo;
import com.libra.todos_back.model.StatusTodo;
import com.libra.todos_back.model.TodoRequest;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String quantity;
    @Enumerated(EnumType.STRING)
    private PriorityTodo priority;
    @Enumerated(EnumType.STRING)
    private StatusTodo status;
    private Date date;

    public TodoEntity() {
    }

    public TodoEntity(TodoRequest request) {
        this.name = request.name();
        this.priority = request.priority();
        this.quantity = request.quantity();
        this.status = StatusTodo.ACTIVE;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public PriorityTodo getPriority() {
        return priority;
    }

    public void setPriority(PriorityTodo priority) {
        this.priority = priority;
    }

    public StatusTodo getStatus() {
        return status;
    }

    public void setStatus(StatusTodo status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
