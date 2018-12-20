package ru.otus.spring2018.lesson1.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring2018.lesson1.exception.InputException;
import ru.otus.spring2018.lesson1.service.InputService;

@ShellComponent
public class Commands {
    private final InputService inputService;

    @Autowired
    public Commands(InputService inputService) {
        this.inputService = inputService;
    }

    @ShellMethod("Introduce user")
    public String introduce(@ShellOption String name) {
        this.inputService.setUserName(name);
        return "name saved";
    }

    @ShellMethod("Start test")
    public void start() {
        try {
            this.inputService.askAnswers();
        } catch (InputException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @ShellMethod("Print result")
    public void result() {
        try {
            this.inputService.printResult();
        } catch (InputException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
