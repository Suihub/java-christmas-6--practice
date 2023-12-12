package christmas.domain.benefit;

import christmas.domain.benefit.discount.ChristmasDiscount;
import christmas.domain.benefit.discount.SpecialDiscount;
import christmas.domain.benefit.discount.WeekdayDiscount;
import christmas.domain.benefit.discount.WeekendDiscount;
import christmas.domain.calendar.EventCalendar;
import christmas.domain.menu.Menus;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.benefit.EventBadge.*;

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

    public int calculateTotalBenefitAmount() {
        return benefits.stream()
                .mapToInt(EventBenefit::getBenefitAmount)
                .sum();
    }

    public int calculateTotalDiscountAmount() {
        int result = calculateTotalBenefitAmount();

        if (benefits.contains(GiveawayBenefit.getInstance())) {
            return result - 25_000;
        }
        return result;
    }

    public List<String> writeBenefitHistoryList() {
        return benefits.stream()
                .map(EventBenefit::writeBenefitHistory)
                .toList();
    }

    public EventBadge resultEventBadge() {
        return resultBadge(calculateTotalBenefitAmount());
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
