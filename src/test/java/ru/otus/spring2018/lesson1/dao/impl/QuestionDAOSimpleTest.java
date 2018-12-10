package ru.otus.spring2018.lesson1.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты QuestionDAO")
public class QuestionDAOSimpleTest {
    @Test
    @DisplayName("Получение списка вопросов")
    public void getQuestions() throws Exception {
        QuestionDAOSimple questionDAOSimple = new QuestionDAOSimple("samples/questions_test.csv");
        List<Question> questions = questionDAOSimple.getQuestions();
        assertEquals(questions.size(), 5);
    }

}