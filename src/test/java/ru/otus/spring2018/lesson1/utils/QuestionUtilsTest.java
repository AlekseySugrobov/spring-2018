package ru.otus.spring2018.lesson1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тесты QuestionUtils")
public class QuestionUtilsTest {
    @Test
    @DisplayName("Тест получения ответов")
    public void getAnswers() throws Exception {
        String inputString = "Ответ1 Ответ2";
        List<String> answers = QuestionUtils.getAnswers(inputString);
        assertEquals(answers.size(), 2);
        assertTrue(answers.contains("Ответ1"));
    }
}