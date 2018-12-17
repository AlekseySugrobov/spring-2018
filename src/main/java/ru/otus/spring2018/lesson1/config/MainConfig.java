package ru.otus.spring2018.lesson1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.otus.spring2018.lesson1.dao.QuestionDAO;
import ru.otus.spring2018.lesson1.dao.impl.QuestionDAOSimple;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class MainConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
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
