package com.in28minutes.business;


import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.matchers.CapturesArguments;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

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

    //BDD approach
    @Test
    public void testRetreiveTodosRelatedToSpringUsingBDDMock(){

        //GIVEN
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn angular", "Learn Spring");
        given(todoServiceMock.retreiveTodos("dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //WHEN
        List<String> filtredTodos = todoBusiness.retreiveTodosRelatedToSpring("dummy");

        //THEN
        assertThat(filtredTodos.size(), Is.is(2));

    }

    //BDD approach
    @Test
    public void testdeleteTodosRelatedToSpringUsingBDDMock(){

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //GIVEN
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn angular", "Learn Spring", "Learn GIT");
        given(todoServiceMock.retreiveTodos("dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //WHEN
        todoBusiness.deleteTodosNotRelatedToSpring("dummy");

        //THEN
        //verify(todoServiceMock, times(1)).deleteTodos("Learn angular");
        then(todoServiceMock).should(times(2)).deleteTodos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));

        //verify(todoServiceMock, never()).deleteTodos("Learn Spring MVC");
        //then(todoServiceMock).should(never()).deleteTodos("Learn Spring MVC");
    }
}