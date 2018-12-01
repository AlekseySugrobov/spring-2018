package ru.otus.spring2018.lesson1.service.impl;

import ru.otus.spring2018.lesson1.dao.QuestionDAO;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO questionDAO;

    public QuestionServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDAO.getQuestions();
    }
}
