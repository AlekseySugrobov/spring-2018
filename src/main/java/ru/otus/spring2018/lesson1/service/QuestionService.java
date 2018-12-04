package ru.otus.spring2018.lesson1.service;

import ru.otus.spring2018.lesson1.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions();
}
