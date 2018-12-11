package ru.otus.spring2018.lesson1.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring2018.lesson1.dao.impl.QuestionDAOSimple;
import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Тесты QuestionService")
public class QuestionServiceImplTest {
    @Test
    @DisplayName("Получение списка вопросов")
    public void getQuestions() {
        QuestionDAOSimple questionDAOSimple = new QuestionDAOSimple("questions.csv");
        QuestionServiceImpl questionService = new QuestionServiceImpl(questionDAOSimple);
        List<Question> questions = questionService.getQuestions();
        assertFalse(questions.isEmpty());
        assertEquals(questions.size(), 5);
    }

}