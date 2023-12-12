package christmas.benefit;

import christmas.benefit.discount.ChristmasDiscount;
import christmas.benefit.discount.SpecialDiscount;
import christmas.benefit.discount.WeekdayDiscount;
import christmas.benefit.discount.WeekendDiscount;
import christmas.domain.calendar.EventCalendar;
import christmas.domain.menu.Menus;

import java.util.ArrayList;
import java.util.List;

public class Benefits {
    private final List<EventBenefit> benefits;

    private Benefits(int orderAmount, EventCalendar calendar, Menus menus) {
        this.benefits = new ArrayList<>();
        initChristmasAndSpecialDiscount(calendar);
        initWeekDiscount(calendar, menus);
        if (orderAmount >= 120_000) {
            benefits.add(GiveawayBenefit.getInstance());
        }
    }

    private Benefits() {
        this.benefits = new ArrayList<>();
        benefits.add(new UnappliedBenefit());
    }

    public static Benefits of(int orderAmount, EventCalendar calendar, Menus menus) {
        if (orderAmount < 10_000) {
            return new Benefits();
        }

        return new Benefits(orderAmount, calendar, menus);
    }

    private void initChristmasAndSpecialDiscount(EventCalendar calendar) {
        if (calendar.judgeChristmasDiscount()) {
            benefits.add(new ChristmasDiscount(calendar.getEventDate()));
        }

        if (calendar.judgeSpecialDiscount()) {
            benefits.add(new SpecialDiscount());
        }
    }

    private void initWeekDiscount(EventCalendar calendar, Menus menus) {
        if (calendar.judgeWeekdayDiscount() && menus.calculateDessertMenuNum() != 0) {
            benefits.add(new WeekdayDiscount(menus.calculateDessertMenuNum()));
        }

        if (calendar.judgeWeekendDiscount() && menus.calculateMainMenuNum() != 0) {
            benefits.add(new WeekendDiscount(menus.calculateMainMenuNum()));
        }
    }
}
