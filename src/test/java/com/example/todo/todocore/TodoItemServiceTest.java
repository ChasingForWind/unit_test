package com.example.todo.todocore;

import com.example.biz.service.UserServiceTest;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

class TodoItemServiceTest {
    //private TodoItemService service;
    //private TodoItemRepository repository;

    @Mock
    TodoItemRepository repository;

    @InjectMocks
    TodoItemService service;


    @BeforeEach
    public void setUp() {
//        this.repository = mock(TodoItemRepository.class);
//        this.service = new TodoItemService(this.repository);
        MockitoAnnotations.openMocks(this);
//        MockitoAnnotations.openMocks(TodoItemServiceTest.class);
    }

    @Test
    void should_add_todo_item() {
        when(repository.save(any())).then(returnsFirstArg());
        TodoItem item = service.addTodoItem(TodoParameter.of("foo"));
        assertThat(item.getContent()).isEqualTo("foo");

        verify(repository).save(any());
    }

    @Test
    public void should_throw_exception_for_null_todo_item() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> service.addTodoItem(null));
    }

    @Test
    public void should_mark_todo_item_as_done() {
        final TodoItem foo = new TodoItem("foo");
        foo.assignIndex(1);
        when(repository.findAll()).thenReturn(ImmutableList.of(foo));
        when(repository.save(any())).then(returnsFirstArg());

        final Optional<TodoItem> todoItem = service.markTodoItemDone(TodoIndexParameter.of(1));

        assertThat(todoItem).isPresent();
        final TodoItem actual = todoItem.get();
        assertThat(actual.isDone()).isTrue();
    }

    @Test
    public void should_list_all() {
        final TodoItem item = new TodoItem("foo");
        item.assignIndex(1);
        when(repository.findAll()).thenReturn(ImmutableList.of(item));

        List<TodoItem> items = service.list(true);
        assertThat(items).hasSize(1);
        final TodoItem result = items.get(0);
        assertThat(result.getIndex()).isEqualTo(1);
        assertThat(result.getContent()).isEqualTo("foo");
    }

    @Test
    public void should_not_list_without_item() {
        when(repository.findAll()).thenReturn(ImmutableList.of());

        List<TodoItem> items = service.list(true);
        assertThat(items).hasSize(0);
    }

    @Test
    public void should_list_all_without_done() {
        final TodoItem doneItem = new TodoItem("foo");
        doneItem.assignIndex(1);
        doneItem.markDone();
        final TodoItem regularItem = new TodoItem("bar");
        regularItem.assignIndex(2);

        when(repository.findAll()).thenReturn(ImmutableList.of(doneItem, regularItem));

        List<TodoItem> items = service.list(false);
        assertThat(items).hasSize(1);
        final TodoItem item = items.get(0);
        assertThat(item.getIndex()).isEqualTo(2);
        assertThat(item.getContent()).isEqualTo("bar");
    }

    @Test
    public void should_not_list_without_done_item() {
        final TodoItem doneItem = new TodoItem("foo");
        doneItem.assignIndex(1);
        doneItem.markDone();

        when(repository.findAll()).thenReturn(ImmutableList.of(doneItem));

        List<TodoItem> items = service.list(false);
        assertThat(items).hasSize(0);
    }

}