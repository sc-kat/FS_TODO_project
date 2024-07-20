package fullStack_todo.todo_backend.service;

import fullStack_todo.todo_backend.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long todoId);
}
