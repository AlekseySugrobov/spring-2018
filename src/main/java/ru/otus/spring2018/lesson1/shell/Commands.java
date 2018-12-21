package ru.otus.spring2018.lesson1.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring2018.lesson1.exception.InputException;
import ru.otus.spring2018.lesson1.service.InputService;

import java.util.ResourceBundle;

@ShellComponent
public class Commands {
    private final InputService inputService;
    private final ResourceBundle resourceBundle;

    @Autowired
    public Commands(InputService inputService, ResourceBundle resourceBundle) {
        this.inputService = inputService;
        this.resourceBundle = resourceBundle;
    }

    @ShellMethod("Introduce user")
    public String introduce(@ShellOption String name) {
        this.inputService.setUserName(name);
        return resourceBundle.getString("app.output.nameSaved");
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
