package fullStack_todo.todo_backend.service.impl;

import fullStack_todo.todo_backend.dto.TodoDto;
import fullStack_todo.todo_backend.entity.TodoEntity;
import fullStack_todo.todo_backend.repository.TodoRepository;
import fullStack_todo.todo_backend.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        TodoEntity todo = modelMapper.map(todoDto, TodoEntity.class);

        TodoEntity savedEntity = todoRepository.save(todo);


        return modelMapper.map(savedEntity, TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long todoId) {

        TodoEntity todoEntity = todoRepository.findById(todoId).get();
        return modelMapper.map(todoEntity, TodoDto.class);
    }
}
