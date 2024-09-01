package com.libra.todos_back.model;

public record TodoRequest(
        String name,
        String quantity,
        PriorityTodo priority
) {
}
