package christmas.controller;

import christmas.domain.Order;
import christmas.domain.benefit.Benefits;

import java.util.List;

public class EventDto {
    private final int eventDate;
    private final List<String> orderList;
    private final int orderAmount;
    private final String resultGiveaway;
    private final List<String> benefitList;
    private final int totalBenefitAmount;
    private final int afterOrderAmount;
    private final String badgeStatus;

    public EventDto(Order order, Benefits benefits) {
        this.eventDate = order.getEventDate();
        this.orderList = order.resultTotalOrderList();
        this.orderAmount = order.resultTotalOrderAmount();
        this.resultGiveaway = benefits.writeGiveawayMenu();
        this.benefitList = benefits.writeBenefitHistoryList();
        this.totalBenefitAmount = benefits.calculateTotalBenefitAmount() * -1;
        this.afterOrderAmount = order.resultTotalOrderAmount() - benefits.calculateTotalDiscountAmount();
        this.badgeStatus = benefits.resultEventBadge();
    }

    public int getEventDate() {
        return eventDate;
    }

    public List<String> getOrderList() {
        return orderList;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public String getResultGiveaway() {
        return resultGiveaway;
    }

    public List<String> getBenefitList() {
        return benefitList;
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public int getAfterOrderAmount() {
        return afterOrderAmount;
    }

    public String getBadgeStatus() {
        return badgeStatus;
    }
}
