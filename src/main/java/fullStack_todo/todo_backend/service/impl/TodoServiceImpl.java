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

    @Override
    public TodoDto updateTodo(TodoDto todoDto,Long todoId) {

        TodoEntity todoEntityById = todoRepository.findById(todoId).orElseThrow(() ->
                new ResourceNotFoundException("The todo item cannot be found"));

        todoEntityById.setTitle(todoDto.getTitle());
        todoEntityById.setDescription(todoDto.getDescription());
        todoEntityById.setCompleted(todoEntityById.isCompleted());

        TodoEntity saved = todoRepository.save(todoEntityById);

        return modelMapper.map(saved, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("The todo cannot be found."));

        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {

        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("The todo cannot be found."));


            todoEntity.setCompleted(Boolean.TRUE);


        return modelMapper.map(todoRepository.save(todoEntity), TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodo(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("The todo cannot be found."));


        todoEntity.setCompleted(Boolean.FALSE);


        return modelMapper.map(todoRepository.save(todoEntity), TodoDto.class);
    }


}
