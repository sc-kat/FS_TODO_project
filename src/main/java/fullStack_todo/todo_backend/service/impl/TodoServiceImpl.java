package fullStack_todo.todo_backend.service.impl;

import fullStack_todo.todo_backend.dto.TodoDto;
import fullStack_todo.todo_backend.entity.TodoEntity;
import fullStack_todo.todo_backend.repository.TodoRepository;
import fullStack_todo.todo_backend.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        TodoEntity todo = new TodoEntity();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        TodoEntity savedEntity = todoRepository.save(todo);

        TodoDto savedDto = new TodoDto();
        savedDto.setId(savedEntity.getId());
        savedDto.setTitle(savedEntity.getTitle());
        savedDto.setDescription(savedEntity.getDescription());
        savedDto.setCompleted(savedEntity.isCompleted());


        return savedDto;
    }
}
