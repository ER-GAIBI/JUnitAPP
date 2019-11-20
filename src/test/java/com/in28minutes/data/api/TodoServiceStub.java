package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    public List<String> retreiveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn angular", "Learn Spring");
    }

    public void deleteTodos(String user){

    }
}
