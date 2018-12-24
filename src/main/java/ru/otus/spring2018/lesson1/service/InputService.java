package ru.otus.spring2018.lesson1.service;

import ru.otus.spring2018.lesson1.exception.InputException;

public interface InputService {
    void start();
    void setUserName(String name);
    void askAnswers() throws InputException;
    void printResult() throws InputException;
}
