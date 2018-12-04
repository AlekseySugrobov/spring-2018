package ru.otus.spring2018.lesson1.dao.impl;

import ru.otus.spring2018.lesson1.dao.QuestionDAO;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.utils.CSVUtils;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionDAOSimple implements QuestionDAO {

    private final String fileName;

    public QuestionDAOSimple(String fileName) {
        this.fileName = fileName;
    }

    public List<Question> getQuestions() {
        return CSVUtils.getDataFromCsv(fileName).stream().map(Question::new).collect(Collectors.toList());
    }
}
