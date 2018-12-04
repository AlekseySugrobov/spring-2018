package ru.otus.spring2018.lesson1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionUtils {
    private static final Pattern ANSWERS_PATTERN = Pattern.compile("([а-яА-ЯёЁa-zA-Z0-9]+)");

    public static List<String> getAnswers(String inputString) {
        List<String> result = new ArrayList<>();
        Matcher inputMatcher = ANSWERS_PATTERN.matcher(inputString);
        while (inputMatcher.find()) {
            result.add(inputMatcher.group());
        }
        return result;
    }
}
