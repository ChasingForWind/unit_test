package com.example.todo.todoapi.cli.file;


import com.example.todo.todocore.TodoItemRepository;
import com.example.todo.todocore.TodoItemService;
import picocli.CommandLine;

import java.io.File;

public class ObjectFactory {
    public CommandLine createCommandLine(final File repositoryFile) {
        return new CommandLine(createTodoCommand(repositoryFile));
    }

    private TodoCommand createTodoCommand(final File repositoryFile) {
        final TodoItemService service = createService(repositoryFile);
        return new TodoCommand(service);
    }

    public TodoItemService createService(final File repositoryFile) {
        final TodoItemRepository repository = new FileTodoItemRepository(repositoryFile);
        return new TodoItemService(repository);
    }
}
