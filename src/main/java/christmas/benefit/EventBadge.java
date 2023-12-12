package christmas.benefit;

public enum EventBadge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NOT_EXIST("없음");

    private final String status;

    EventBadge(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static EventBadge resultBadge(int amount) {
        if (amount > 20_000) {
            return SANTA;
        }

        if (amount > 10_000) {
            return TREE;
        }

        if (amount > 5_000) {
            return STAR;
        }
        return NOT_EXIST;
    }
}
