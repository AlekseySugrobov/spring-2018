package ru.otus.spring2018.lesson1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.otus.spring2018.lesson1.dao.QuestionDAO;
import ru.otus.spring2018.lesson1.dao.impl.QuestionDAOSimple;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@PropertySource("classpath:application.properties")
@Configuration
public class MainConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public QuestionDAO questionDAO(@Value("${main.file}") String fileName) {
        return new QuestionDAOSimple(fileName);
    }

    @Bean
    public ResourceBundle resourceBundle(@Value("${main.locale}") String locale, @Value("${main.bundle}") String bundle) {
        return ResourceBundle.getBundle(bundle, new Locale(locale));
    }
}
