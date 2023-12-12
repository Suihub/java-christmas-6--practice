package christmas.controller;

import christmas.domain.calendar.EventCalendar;
import christmas.domain.menu.Menus;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventController {
    private final InputView input;
    private final OutputView output;

    public EventController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        output.announce();
        createEventCalendar();
    }

    private void createEventCalendar() {
        EventCalendar eventDate;

        while (true) {
            try {
                String date = input.readDate();
                eventDate = new EventCalendar(date);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        createMenus(eventDate);
    }

    private void createMenus(EventCalendar eventDate) {
        Menus menus;

        while (true) {
            try {
                List<String> order = input.readOrder();
                menus = new Menus(order);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
