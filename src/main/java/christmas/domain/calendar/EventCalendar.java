package christmas.domain.calendar;

import java.time.LocalDate;

public class EventCalendar {
    private final LocalDate date;

    public EventCalendar(String input) {
        numberValidate(input);
        numberRangeValidate(input);
        this.date = LocalDate.of(2023, 12, Integer.parseInt(input));
    }

    public int getEventDate() {
        return date.getDayOfMonth();
    }

    public boolean judgeChristmasDiscount() {
        return date.isBefore(LocalDate.of(2023, 12, 26));
    }

    public boolean judgeWeekdayDiscount() {
        int value = date.getDayOfWeek().getValue();

        return value != 5 && value != 6;
    }

    public boolean judgeWeekendDiscount() {
        int value = date.getDayOfWeek().getValue();

        return value == 5 || value == 6;
    }

    public boolean judgeSpecialDiscount() {
        int value = date.getDayOfWeek().getValue();

        return value == 7 || date.getDayOfMonth() == 25;
    }

    private void numberValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void numberRangeValidate(String input) {
        int num = Integer.parseInt(input);

        if (num < 1 || num > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
