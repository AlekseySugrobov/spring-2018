package ru.otus.spring2018.lesson1.dao.impl;

import org.junit.Test;
import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionDAOSimpleTest {
    @Test
    public void getQuestions() throws Exception {
        QuestionDAOSimple questionDAOSimple = new QuestionDAOSimple("samples/questions_test.csv");
        List<Question> questions = questionDAOSimple.getQuestions();
        assertEquals(questions.size(), 5);
    }

}