package com.example.todo.todocore;

import org.springframework.data.repository.Repository;

public interface TodoItemRepository extends Repository<TodoItem, Long> {
    TodoItem save(TodoItem item);

    Iterable<TodoItem> findAll();
}
