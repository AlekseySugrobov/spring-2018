package ru.otus.spring2018.lesson1.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Тесты QuestionService")
@SpringBootTest
public class QuestionServiceImplTest {

    @Autowired
    private QuestionService questionService;

    @Test
    @DisplayName("Получение списка вопросов")
    public void getQuestions() {
        List<Question> questions = questionService.getQuestions();
        assertFalse(questions.isEmpty());
        assertEquals(questions.size(), 5);
    }

}