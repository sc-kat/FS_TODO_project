package fullStack_todo.todo_backend.service;

import fullStack_todo.todo_backend.dto.TodoDto;
import fullStack_todo.todo_backend.repository.TodoRepository;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
}
