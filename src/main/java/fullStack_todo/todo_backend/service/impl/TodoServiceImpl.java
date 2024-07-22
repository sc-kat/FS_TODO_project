package fullStack_todo.todo_backend.service.impl;

import fullStack_todo.todo_backend.dto.TodoDto;
import fullStack_todo.todo_backend.entity.TodoEntity;
import fullStack_todo.todo_backend.exception.ResourceNotFoundException;
import fullStack_todo.todo_backend.repository.TodoRepository;
import fullStack_todo.todo_backend.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        TodoEntity todoEntity = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("The Todo with id " + todoId + " doesn't exist."));
        return modelMapper.map(todoEntity, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<TodoEntity> allEntityTodos = todoRepository.findAll();

        List<TodoDto> todoDtoList = allEntityTodos.stream()
                .map(todoEntity -> modelMapper.map(todoEntity, TodoDto.class))
                .toList();
        return todoDtoList;
    }
}
