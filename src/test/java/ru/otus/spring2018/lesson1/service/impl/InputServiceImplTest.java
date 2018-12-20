package ru.otus.spring2018.lesson1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Тесты сервиса работы с пользователем")
@SpringBootTest(properties = {InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"})
class InputServiceImplTest {

    private static final String DEFAULT_INPUT = "default input";

    @Value("${main.bundle}")
    private String bundleName;
    @Value("${main.locale}")
    private String localeName;
    @Autowired
    private QuestionService questionService;
    private Scanner scanner;
    private InputServiceImpl inputService;

    @BeforeEach
    public void setUp() {
        ByteArrayInputStream in = new ByteArrayInputStream(DEFAULT_INPUT.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundleName, new Locale(localeName));
        inputService = new InputServiceImpl(questionService, resourceBundle);
    }

    @Test
    @DisplayName("Тест запроса ответа")
    void askAnswer() {
        String answer = inputService.askAnswer("");
        assertThat(answer).isEqualTo(DEFAULT_INPUT);
    }

    @Test
    @DisplayName("Тест получения вопросов")
    void getQuestions() {
        List<Question> questions = inputService.getQuestions();
        assertThat(questions).isNotNull().hasSize(5);
    }

    @Test
    @DisplayName("Тест запроса имени пользователя")
    void getUserName() {
        String userName = inputService.getUserName();
        assertThat(userName).isEqualTo(DEFAULT_INPUT);
    }
}