package com.libra.todos_back.model;

public record TodoUpdateRequest(
        Long id,
        String name,
        String quantity,
        PriorityTodo priority
) {
}
