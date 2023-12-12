package christmas.domain.calendar;

import java.time.LocalDate;

public class EventCalendar {
    private final LocalDate date;

    public EventCalendar(String input) {
        this.date = LocalDate.of(2023, 12, Integer.parseInt(input));
    }
}
