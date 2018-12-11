package ru.otus.spring2018.lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.model.TestResult;
import ru.otus.spring2018.lesson1.service.InputService;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.util.List;
import java.util.Scanner;

@ComponentScan
public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);
        InputService inputService = context.getBean(InputService.class);
        inputService.start();
    }
}
