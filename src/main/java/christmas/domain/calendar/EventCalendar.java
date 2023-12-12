package christmas.domain.calendar;

import java.time.LocalDate;

public class EventCalendar {
    private final LocalDate date;

    public EventCalendar(String input) {
        numberValidate(input);
        this.date = LocalDate.of(2023, 12, Integer.parseInt(input));
    }

    private void numberValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
