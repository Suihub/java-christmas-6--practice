package christmas.benefit;

import java.text.DecimalFormat;

public class GiveawayBenefit implements EventBenefit{
    private static GiveawayBenefit instance;

    private final String name;
    private final int amount;

    private GiveawayBenefit() {
        this.name = "증정 이벤트";
        this.amount = 25000;
    }

    public static GiveawayBenefit getInstance() {
        if (instance == null) {
            instance = new GiveawayBenefit();
        }
        return instance;
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
