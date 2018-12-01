package ru.otus.spring2018.lesson1.utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CSVUtilsTest {
    @Test
    public void getDataFromCsv() {
        List<String[]> dataFromCsv = CSVUtils.getDataFromCsv("questions.csv");
        assertFalse(dataFromCsv.isEmpty());
        assertEquals(dataFromCsv.size(), 5);
    }

}