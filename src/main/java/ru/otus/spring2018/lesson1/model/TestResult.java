package ru.otus.spring2018.lesson1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class TestResult {

    private static final String NEW_ROW = "\r\n";

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s: %s", resourceBundle.getString("app.output.name"), this.getName()))
                .append(NEW_ROW);
        for (Question question : this.getQuestions()) {
            stringBuilder.append(String.format("%s: %s|%s: %s",
                    resourceBundle.getString("app.output.question-text"),
                    question.getText(),
                    resourceBundle.getString("app.output.result"),
                    question.isCorrect() ? resourceBundle.getString("app.output.result.correct") : resourceBundle.getString("app.output.result.incorrect")))
                    .append(NEW_ROW);
        }
        System.out.println(stringBuilder.toString());
    }
}
