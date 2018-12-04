package ru.otus.spring2018.lesson1.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuestionTest {
    @Test
    public void checkAnswer() {
        Question question = new Question("Вопрос", Arrays.asList("ответ1", "ответ2"));
        question.handleAnswer("ответ1");
        assertFalse(question.isCorrect());
        question.handleAnswer("ответ2");
        assertFalse(question.isCorrect());
        question.handleAnswer("ответ1 ответ2");
        assertTrue(question.isCorrect());
    }

}