package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private final InputView input;
    private final OutputView output;

    public EventController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        output.announce();

        while (true) {
            try {
                String date = input.readDate();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
