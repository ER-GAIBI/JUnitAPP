package com.in28minutes.junit.helper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class StringHelperParametrizedSecondTest {

    StringHelper helper = new StringHelper();

    private String input;
    private boolean expectedOutputs;

    public StringHelperParametrizedSecondTest(String input, boolean expectedOutputs) {
        this.input = input;
        this.expectedOutputs = expectedOutputs;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parametres(){
        Object[][] expectedOutputs = {
            {"HGYUNHG", true},
            {"GYUNHG", false}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testareFirstAndLastTwoCharactersTheSameTrue(){
        assertEquals(expectedOutputs, helper.areFirstAndLastTwoCharactersTheSame(input));
    }
}