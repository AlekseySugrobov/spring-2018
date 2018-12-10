package ru.otus.spring2018.lesson1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.otus.spring2018.lesson1.model.Question;
import ru.otus.spring2018.lesson1.service.QuestionService;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Тесты сервиса работы с пользователем")
class InputServiceImplTest {

    private static final String DEFAULT_INPUT = "default input";

    @Mock
    private QuestionService questionService;
    private Scanner scanner;
    private InputServiceImpl inputService;

    @BeforeEach
    public void setUp() {
        ByteArrayInputStream in = new ByteArrayInputStream(DEFAULT_INPUT.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        questionService = mock(QuestionServiceImpl.class);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("console", new Locale("en"));
        when(questionService.getQuestions()).thenReturn(Arrays.asList(new Question("Вопрос1", Collections.emptyList()), new Question("Вопрос2", Collections.emptyList())));
        inputService = new InputServiceImpl(questionService, scanner, resourceBundle);
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
        assertThat(questions).isNotNull().hasSize(2);
    }

    @Test
    @DisplayName("Тест запроса имени пользователя")
    void getUserName() {
        String userName = inputService.getUserName();
        assertThat(userName).isEqualTo(DEFAULT_INPUT);
    }
}