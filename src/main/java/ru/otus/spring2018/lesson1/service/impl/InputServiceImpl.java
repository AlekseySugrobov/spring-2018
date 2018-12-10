package ru.otus.spring2018.lesson1.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.model.TestResult;
import ru.otus.spring2018.lesson1.service.InputService;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

@Service
public class InputServiceImpl implements InputService {

    private QuestionService questionService;
    private Scanner scanner;
    private ResourceBundle resourceBundle;

    public InputServiceImpl(QuestionService questionService, Scanner scanner, ResourceBundle resourceBundle) {
        this.questionService = questionService;
        this.scanner = scanner;
        this.resourceBundle = resourceBundle;
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
