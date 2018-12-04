package ru.otus.spring2018.lesson1.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionUtilsTest {
    @Test
    public void getAnswers() throws Exception {
        String inputString = "Ответ1 Ответ2";
        List<String> answers = QuestionUtils.getAnswers(inputString);
        assertEquals(answers.size(), 2);
        assertTrue(answers.contains("Ответ1"));
    }
}