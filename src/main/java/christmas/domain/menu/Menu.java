package christmas.domain.menu;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, 1),
    TAPAS("타파스", 5500, 1),
    CAESAR_SALAD("시저샐러드", 8000, 1),
    T_BONE_STEAK("티본스테이크", 55000, 2),
    BARBEQUE_RIB("바비큐립", 54000, 2),
    SEAFOOD_PASTA("해산물파스타", 35000, 2),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, 2),
    CHOCO_CAKE("초코케이크", 15000, 3),
    ICE_CREAM("아이스크림", 5000, 3),
    ZERO_COLA("제로콜라", 3000, 4),
    RED_WINE("레드와인", 60000, 4),
    CHAMPAGNE("샴페인", 25000, 4),
    NOT_EXIST("존재하지 않는 메뉴", 0, 0);

    private final String name;
    private final int price;
    private final int menuCode;

    Menu(String name, int price, int menuCode) {
        this.name = name;
        this.price = price;
        this.menuCode = menuCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public Menu order(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return NOT_EXIST;
    }
}
