package com.libra.todos_back.model;

import java.util.Date;

public record Todo(
        Long id,
        String name,
        String quantity,
        PriorityTodo priority,
        StatusTodo status,
        Date date
) {
}
