package com.libra.todos_back.todo;

import com.libra.todos_back.entyties.TodoEntity;
import com.libra.todos_back.model.StatusTodo;
import com.libra.todos_back.model.Todo;
import com.libra.todos_back.model.TodoRequest;
import com.libra.todos_back.model.TodoUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {


    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        //return todoRepository.findAll();

        return todoRepository.findByStatusNot(StatusTodo.DELETED).stream()
                .map(todo -> new Todo(
                        todo.getId(),
                        todo.getName(), todo.getQuantity(), todo.getPriority(),
                        todo.getStatus(), todo.getDate())
                )
                .collect(Collectors.toList());
    }

    public Long createTodo(TodoRequest request) {
        TodoEntity entity = new TodoEntity(request);
        TodoEntity todoCreated = todoRepository.save(entity);
        return todoCreated.getId();
    }

    public void checkUncheck(Long id) {
        TodoEntity todo = todoRepository.findById(id).get();
        if (todo.getStatus() == StatusTodo.COMPLETED) {
            todo.setStatus(StatusTodo.ACTIVE);
        } else if (todo.getStatus() == StatusTodo.ACTIVE) {
            todo.setStatus(StatusTodo.COMPLETED);
        }
        todoRepository.save(todo);
    }

    public void deleteTodo(Long id) throws ClassNotFoundException {
        TodoEntity todo = todoRepository.findByIdAndStatusNot(id, StatusTodo.DELETED)
                .orElseThrow(() -> new ClassNotFoundException("No existe"));
        todo.setStatus(StatusTodo.DELETED);
        todoRepository.save(todo);
    }

    public void updateTodo(TodoUpdateRequest request) {
        TodoEntity todo = todoRepository.findById(request.id()).get();
        todo.setName(request.name());
        todo.setQuantity(request.quantity());
        todo.setPriority(request.priority());
        todoRepository.save(todo);
    }
}
