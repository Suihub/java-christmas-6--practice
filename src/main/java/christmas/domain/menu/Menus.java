package christmas.domain.menu;

import static christmas.domain.menu.Menu.*;
import static christmas.exception.OrderValidate.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Menus {
    private final Map<Menu, Integer> menus;

    public Menus(List<String> orders) {
        orderValidate(orders);
        this.menus = orders.stream()
                .map(order -> order.split("-"))
                .collect(toMap(list -> orderMenu(list[0]), list -> Integer.parseInt(list[1])));
        notExistMenuValidate();
        onlyDrinkValidate();
        menuNumMaxValidate();
    }

    public int calculateOrderAmount() {
        return menus.keySet().stream()
                .mapToInt(key -> key.getPrice() * menus.get(key))
                .sum();
    }

    public List<String> writeOrderList() {
        return menus.keySet().stream()
                .map(key -> String.format("%s %d개", key.getName(), menus.get(key)))
                .toList();
    }

    public long calculateMainMenuNum() {
        return menus.keySet().stream()
                .filter(key -> key.getMenuCode() == 2)
                .count();
    }

    public long calculateDessertMenuNum() {
        return menus.keySet().stream()
                .filter(key -> key.getMenuCode() == 3)
                .count();
    }

    private void notExistMenuValidate() {
        Optional<Menu> result = menus.keySet().stream()
                .filter(menu -> menu.getMenuCode() == 0)
                .findAny();

        if (result.isPresent()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void onlyDrinkValidate() {
        long result = menus.keySet().stream()
                .filter(menu -> menu.getMenuCode() == 4)
                .count();

        if (result == menus.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void menuNumMaxValidate() {
        int result = menus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (result > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
