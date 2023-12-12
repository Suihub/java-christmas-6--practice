package christmas.benefit.discount;

import christmas.benefit.EventBenefit;

import java.text.DecimalFormat;

public class WeekdayDiscount implements EventBenefit {
    private final String name;
    private final int amount;

    public WeekdayDiscount(int num) {
        this.name = "평일 할인";
        this.amount = 2023 * num;
    }

    @Override
    public String writeBenefitHistory() {
        DecimalFormat standard = new DecimalFormat("###,###,###");
        return String.format("%s: -%s원", name, standard.format(amount));
    }

    @Override
    public int getBenefitAmount() {
        return amount;
    }
}
