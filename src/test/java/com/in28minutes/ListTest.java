package com.in28minutes;

import com.in28minutes.business.TodoBusinessImpl;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    public void test(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn(2);
        assertEquals(2, mockList.get(0));
        assertEquals(2, mockList.get(1));
    }

    @Test
    public void test1(){
        Object mockObject = mock(Object.class);
        when(mockObject.toString()).thenReturn("test");
        assertEquals("test", mockObject.toString());
    }

    @Test(expected = RuntimeException.class)
    public void test2(){
        List mockList = mock(List.class);
        when(mockList.subList(anyInt(), 5)).thenThrow(RuntimeException.class);
        mockList.get(0);
    }

    @Test
    public void testUsingBDD(){
        //GIVEN
        List<Integer> mockList = mock(List.class);
        given(mockList.get(anyInt())).willReturn(2);
        //WHEN
        Integer firsElement = mockList.get(0);
        //THEN
        assertThat(firsElement, is(2));
    }

}
