package ru.otus.spring2018.lesson1.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.otus.spring2018.lesson1.exception.InputException;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.model.TestResult;
import ru.otus.spring2018.lesson1.service.InputService;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

@Service
public class InputServiceImpl implements InputService {

    private QuestionService questionService;
    private Scanner scanner = new Scanner(System.in);
    private ResourceBundle resourceBundle;
    private String userName;
    private List<Question> questions;
    private TestResult testResult;

    public InputServiceImpl(QuestionService questionService, ResourceBundle resourceBundle) {
        this.questionService = questionService;
        this.resourceBundle = resourceBundle;
        this.questions = getQuestions();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = getQuestions();
        String userName = getUserName();
        TestResult testResult = new TestResult(userName);
        for (Question question : questions) {
            String answer = askAnswer(question.getText());
            question.handleAnswer(answer);
            testResult.addQuestion(question);
        }
        testResult.printResult(resourceBundle);
        scanner.close();
    }

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public void askAnswers() throws InputException {
        checkNameEntered();
        testResult = new TestResult(this.userName);
        for (Question question : questions) {
            String answer = askAnswer(question.getText());
            question.handleAnswer(answer);
            testResult.addQuestion(question);
        }
    }

    @Override
    public void printResult() throws InputException {
        checkNameEntered();
        checkTestPassed();
        testResult.printResult(resourceBundle);
    }

    private void checkTestPassed() throws InputException {
        if (Objects.isNull(testResult)) {
            throw new InputException(resourceBundle.getString("exception.testNotPassed"));
        }
    }

    private void checkNameEntered() throws InputException {
        if(StringUtils.isEmpty(this.userName)) {
            throw new InputException(resourceBundle.getString("exception.emptyName"));
        }
    }

    protected String askAnswer(String text) {
        System.out.println(resourceBundle.getString("app.input.question") + String.format("%s?", text));
        return scanner.nextLine();
    }

    protected List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    protected String getUserName() {
        System.out.println(resourceBundle.getString("app.input.name"));
        return scanner.nextLine();
    }
}
