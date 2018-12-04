package ru.otus.spring2018.lesson1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.model.TestResult;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService testService = context.getBean(QuestionService.class);
        List<Question> questions = testService.getQuestions();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        TestResult testResult = new TestResult(scanner.nextLine());
        for(Question question:questions) {
            System.out.println(String.format("%s?", question.getText()));
            question.handleAnswer(scanner.nextLine());
            testResult.addQuestion(question);
        }
        testResult.printResult();
    }
}
