package christmas.benefit;

public class UnappliedBenefit implements EventBenefit{
    private final String name;
    private final int amount;

    public UnappliedBenefit() {
        this.name = "없음";
        this.amount = 0;
    }

    @Override
    public String writeBenefitHistory() {
        return name;
    }

    @Override
    public int getBenefitAmount() {
        return amount;
    }
}
