package com.in28minutes.junit.helper;


import org.junit.Test;
import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper helper = new StringHelper();

    @Test
    public void testTruncateAInFirst2Positions() {
        assertEquals("BC", helper.truncateAInFirst2Positions("ABC"));
    }

    @Test
    public void testareFirstAndLastTwoCharactersTheSameFalse(){
        assertFalse( helper.areFirstAndLastTwoCharactersTheSame("ABA"));
    }

    @Test
    public void testareFirstAndLastTwoCharactersTheSameTrue(){
        assertTrue( helper.areFirstAndLastTwoCharactersTheSame("HGYUNHG"));
    }
}