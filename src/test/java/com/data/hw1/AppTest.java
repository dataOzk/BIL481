package com.data.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {

    @Test
    public void testReplaceCharacters_SingleReplacement() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("Hello");
        request.setStr2("World");
        request.setArray1("2");
        request.setArray2("4");
        String expected = "Hedlo";
        String result = request.replaceCharacters();
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_MultipleReplacements() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("Hello");
        request.setStr2("World");
        request.setArray1("1,2,4");
        request.setArray2("4,1,2");
        String expected = "Hdolr";
        String result = request.replaceCharacters();
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_EmptyString() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("");
        request.setStr2("World");
        request.setArray1("");
        request.setArray2("");
        String expected = "";
        String result = request.replaceCharacters();
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_SameString() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("Hello");
        request.setStr2("Hello");
        request.setArray1("0,1,2,3,4");
        request.setArray2("0,1,2,3,4");
        String expected = "Hello";
        String result = request.replaceCharacters();
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_LargeStrings() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("This is a long string for testing");
        request.setStr2("Another long string for testing");
        request.setArray1("5,10,15,20");
        request.setArray2("10,15,20,7");
        String expected = "This ns a rong ftrin  for testing";
        String result = request.replaceCharacters();
        assertEquals(expected, result);
    }

    @Test
    public void testReplaceCharacters_UnevenArrays() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("Hello");
        request.setStr2("World");
        request.setArray1("2,3,4,1,0");
        request.setArray2("4,1,2");
        assertThrows(IllegalArgumentException.class, request::replaceCharacters);
    }

    @Test
    public void testReplaceCharacters_OutOfBoundsIndex() {
        ReplaceCharactersRequest request = new ReplaceCharactersRequest();
        request.setStr1("Hello");
        request.setStr2("World");
        request.setArray1("2,6");
        request.setArray2("4,1");
        assertThrows(IllegalArgumentException.class, request::replaceCharacters);
    }
}
