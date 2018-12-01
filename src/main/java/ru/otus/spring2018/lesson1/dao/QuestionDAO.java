package ru.otus.spring2018.lesson1.dao;

import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestions();
}
