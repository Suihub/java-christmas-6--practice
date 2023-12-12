package christmas.benefit.discount;

import christmas.benefit.EventBenefit;

import java.text.DecimalFormat;

public class SpecialDiscount implements EventBenefit {
    private final String name;
    private final int amount;

    public SpecialDiscount() {
        this.name = "특별 할인";
        this.amount = 1000;
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
