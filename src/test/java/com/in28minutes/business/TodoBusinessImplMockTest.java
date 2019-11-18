package com.in28minutes.business;


import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetreiveTodosRelatedToSpringUsingMock(){
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn angular", "Learn Spring");
        when(todoServiceMock.retreiveTodos("dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        List<String> filtredTodos = todoBusiness.retreiveTodosRelatedToSpring("dummy");
        assertEquals(2, filtredTodos.size());

    }
}