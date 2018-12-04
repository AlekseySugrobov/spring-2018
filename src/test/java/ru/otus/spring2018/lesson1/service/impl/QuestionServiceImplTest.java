package ru.otus.spring2018.lesson1.service.impl;

import org.junit.Test;
import ru.otus.spring2018.lesson1.dao.impl.QuestionDAOSimple;
import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionServiceImplTest {
    @Test
    public void getQuestions() throws Exception {
        QuestionDAOSimple questionDAOSimple = new QuestionDAOSimple("questions.csv");
        QuestionServiceImpl questionService = new QuestionServiceImpl(questionDAOSimple);
        List<Question> questions = questionService.getQuestions();
        assertFalse(questions.isEmpty());
        assertEquals(questions.size(), 5);
    }

}