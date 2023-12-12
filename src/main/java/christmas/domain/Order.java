package christmas.domain;

import christmas.domain.benefit.Benefits;
import christmas.domain.calendar.EventCalendar;
import christmas.domain.menu.Menus;

import java.util.List;

public class Order {
    private final EventCalendar calendar;
    private final Menus menus;

    public Order(EventCalendar calendar, Menus menus) {
        this.calendar = calendar;
        this.menus = menus;
    }

    public Benefits resultBenefit() {
        return Benefits.of(menus.calculateOrderAmount(), calendar, menus);
    }

    public int resultTotalOrderAmount() {
        return menus.calculateOrderAmount();
    }

    public int getEventDate() {
        return calendar.getEventDate();
    }

    public List<String> resultTotalOrderList() {
        return menus.writeOrderList();
    }
}
