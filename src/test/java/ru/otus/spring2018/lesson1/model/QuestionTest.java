package ru.otus.spring2018.lesson1.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тесты класса Question")
public class QuestionTest {
    @Test
    @DisplayName("Тест проверки введенного ответа")
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