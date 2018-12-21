package ru.otus.spring2018.lesson1.model;

import ru.otus.spring2018.lesson1.utils.QuestionUtils;

import java.util.Arrays;
import java.util.List;

public class Question {
    private String text;
    private String translatedText;
    private List<String> answers;
    private boolean correct;

    public Question(String[] data) {
        this.text = data[0];
        this.translatedText = data[1];
        this.answers = Arrays.asList(data).subList(2, data.length);
    }

    public Question(String text, List<String> answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void handleAnswer(String inputString) {
        List<String> userAnswers = QuestionUtils.getAnswers(inputString);
        this.correct = this.answers.equals(userAnswers);
    }
}
