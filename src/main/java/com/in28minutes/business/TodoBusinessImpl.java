package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retreiveTodosRelatedToSpring(String user){
        List<String> filtredTodod = new ArrayList<String>();
        List<String> todos = todoService.retreiveTodos(user);
        for (String todo : todos) {
            if (todo.contains("Spring")){
                filtredTodod.add(todo);
            }
        }
        return filtredTodod;
    }

    public void deleteTodosNotRelatedToSpring(String user){
        List<String> todos = todoService.retreiveTodos(user);
        for (String todo : todos) {
            if (!todo.contains("Spring")){
                todoService.deleteTodos(todo);
            }
        }
    }
}
