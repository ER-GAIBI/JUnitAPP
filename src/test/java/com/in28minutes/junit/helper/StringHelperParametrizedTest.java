package com.in28minutes.junit.helper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {

    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParametrizedTest(String input, String expectedOutput) {
        System.out.println(input + "  " + expectedOutput);
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    //contains inputs and outputs to test
    // at the run of test the paremetres are passed to constructor : AAD to input and D to output
    @Parameterized.Parameters
    public static Collection<String[]> parametres(){
        String[][] expectedOutputs = {
                {"AAD", "D"},
                {"ACD", "CD"}
        };
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirst2Positions() {
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }
}