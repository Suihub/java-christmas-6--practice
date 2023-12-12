package christmas.domain.calendar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EventCalendarTest {
    @Test
    @DisplayName("이벤트 날짜를 반환받는다.")
    void returnEventDate() {
        EventCalendar calendar = new EventCalendar("29");
        int date = calendar.getEventDate();

        assertThat(date).isEqualTo(29);
    }
}