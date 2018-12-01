package ru.otus.spring2018.lesson1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestResult {
    private String name;
    private List<Question> questions;

    public TestResult(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public void printResult() {
        System.out.println(String.format("Имя: %s", this.getName()));
        for(Question question:this.getQuestions()) {
            System.out.println(String.format("Текст вопроса: %s|Результат: %s", question.getText(), question.isCorrect() ? "Верный" : "Неверный"));
        }
    }
}
