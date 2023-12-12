package christmas.domain.menu;

import static christmas.domain.menu.Menu.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;

public class Menus {
    private final Map<Menu, Integer> menus;

    public Menus(List<String> orders) {
        this.menus = orders.stream()
                .map(order -> order.split("-"))
                .collect(toMap(list -> orderMenu(list[0]), list -> Integer.parseInt(list[1])));
    }
}
