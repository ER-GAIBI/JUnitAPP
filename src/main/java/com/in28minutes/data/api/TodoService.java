package com.in28minutes.data.api;

import java.util.List;

public interface TodoService {

    List<String> retreiveTodos(String user);
    void deleteTodos(String user);
}
