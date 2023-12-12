package christmas.domain.benefit.discount;

import christmas.domain.benefit.EventBenefit;

import java.text.DecimalFormat;

public class WeekendDiscount implements EventBenefit {
    private final String name;
    private final int amount;

    public WeekendDiscount(int num) {
        this.name = "주말 할인";
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
