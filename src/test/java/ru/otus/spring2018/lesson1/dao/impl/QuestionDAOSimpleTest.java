package ru.otus.spring2018.lesson1.dao.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring2018.lesson1.dao.QuestionDAO;
import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты QuestionDAO")
@SpringBootTest
public class QuestionDAOSimpleTest {

    @Autowired
    private QuestionDAO questionDAO;

    @Test
    @DisplayName("Получение списка вопросов")
    public void getQuestions() {
        List<Question> questions = questionDAO.getQuestions();
        assertEquals(questions.size(), 5);
    }

}