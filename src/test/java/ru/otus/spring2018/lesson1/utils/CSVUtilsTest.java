package ru.otus.spring2018.lesson1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Тесты CSV парсера")
public class CSVUtilsTest {
    @Test
    @DisplayName("Тест получения списка вопросов из CSV")
    public void getDataFromCsv() {
        List<String[]> dataFromCsv = CSVUtils.getDataFromCsv("questions.csv");
        assertFalse(dataFromCsv.isEmpty());
        assertEquals(dataFromCsv.size(), 5);
    }

}