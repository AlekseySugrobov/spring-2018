package ru.otus.spring2018.lesson1.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring2018.lesson1.model.Question;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты QuestionDAO")
public class QuestionDAOSimpleTest {

    private Properties properties;

    @BeforeEach
    public void setUp() throws IOException {
        properties = new Properties();
        properties.load(QuestionDAOSimpleTest.class.getClassLoader().getResourceAsStream("application.properties"));
    }

    @Test
    @DisplayName("Получение списка вопросов")
    public void getQuestions() {
        QuestionDAOSimple questionDAOSimple = new QuestionDAOSimple(properties.getProperty("main.file"));
        List<Question> questions = questionDAOSimple.getQuestions();
        assertEquals(questions.size(), 5);
    }

}