package christmas.domain.benefit.discount;

import christmas.domain.benefit.EventBenefit;

import java.text.DecimalFormat;

public class ChristmasDiscount implements EventBenefit {
    private final String name;
    private final int amount;

    public ChristmasDiscount(int date) {
        this.name = "크리스마스 디데이 할인";
        this.amount = 1000 + ((date - 1) * 100);
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
