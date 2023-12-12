package christmas.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderValidate {
    private OrderValidate() {
    }

    public static void orderValidate(List<String> input) {
        existRegexValidate(input);
        regexNumValidate(input);
        orderFormatValidate(input);
        notBlankValidate(input);
        menuNumberValidate(input);
        menuNumRangeValidate(input);
        menuDuplicateValidate(input);
    }

    private static void existRegexValidate(List<String> input) {
        long result = input.stream().
                filter(order -> order.contains("-"))
                .count();

        if (result != input.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void regexNumValidate(List<String> input) {
        long result = input.stream()
                .filter(order -> order.indexOf("-") == order.lastIndexOf("-"))
                .count();

        if (result != input.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void orderFormatValidate(List<String> input) {
        long result = input.stream()
                .filter(order -> order.split("-").length == 2)
                .count();

        if (result != input.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static void notBlankValidate(List<String> input) {
        input.forEach(order ->{
            String[] result = order.split("-");

            if (result[0].contains(" ") || result[1].contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        });
    }

    private static void menuNumberValidate(List<String> input) {
        input.forEach(order -> {
            String[] result = order.split("-");

            try {
                Integer.parseInt(result[1]);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        });
    }

    private static void menuNumRangeValidate(List<String> input) {
        input.forEach(order -> {
            String[] result = order.split("-");
            int num = Integer.parseInt(result[1]);

            if (num < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        });
    }

    private static void menuDuplicateValidate(List<String> input) {
        Set<String> set = new HashSet<>();

        input.forEach(order -> {
            String[] result = order.split("-");
            set.add(result[0]);
        });

        if (set.size() != input.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
