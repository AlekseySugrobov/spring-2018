package ru.otus.spring2018.lesson1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

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

    public void printResult(ResourceBundle resourceBundle) {
        System.out.println(String.format("%s: %s", resourceBundle.getString("app.output.name"), this.getName()));
        for(Question question:this.getQuestions()) {
            System.out.println(String.format("%s: %s|%s: %s",
                    resourceBundle.getString("app.output.question-text"),
                    question.getText(),
                    resourceBundle.getString("app.output.result"),
                    question.isCorrect() ? resourceBundle.getString("app.output.result.correct") : resourceBundle.getString("app.output.result.incorrect")));
        }
    }
}
