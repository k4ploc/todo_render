package com.libra.todos_back.todo;

import com.libra.todos_back.entyties.TodoEntity;
import com.libra.todos_back.model.StatusTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByStatusNot(StatusTodo status);

    Optional<TodoEntity> findByIdAndStatusNot(Long id, StatusTodo status);


}
