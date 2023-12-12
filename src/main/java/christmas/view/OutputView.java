package christmas.view;

import christmas.controller.EventDto;

import java.text.DecimalFormat;

public class OutputView {
    private final DecimalFormat standard;

    public OutputView() {
        this.standard = new DecimalFormat("###,###,###");
    }

    public void announce() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printResult(EventDto eventDto) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n%n", eventDto.getEventDate());
        printOrderList(eventDto);
        printBeforeOrderAmount(eventDto);
        printGiveawayMenu(eventDto);
        printBenefitHistory(eventDto);
        printBenefitAmount(eventDto);
        printAfterOrderAmount(eventDto);
        printEventBadgeStatus(eventDto);
    }

    private void printOrderList(EventDto eventDto) {
        System.out.println("<주문 메뉴>");
        eventDto.getOrderList().forEach(System.out::println);
        System.out.println();
    }

    private void printBeforeOrderAmount(EventDto eventDto) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%s원%n%n", standard.format(eventDto.getOrderAmount()));
    }

    private void printGiveawayMenu(EventDto eventDto) {
        System.out.println("<증정 메뉴>");
        System.out.println(eventDto.getResultGiveaway());
        System.out.println();
    }

    private void printBenefitHistory(EventDto eventDto) {
        System.out.println("<혜택 내역>");
        eventDto.getBenefitList().forEach(System.out::println);
        System.out.println();
    }

    private void printBenefitAmount(EventDto eventDto) {
        System.out.println("<총혜택 내역>");
        System.out.printf("%s원%n%n", standard.format(eventDto.getTotalBenefitAmount()));
    }

    private void printAfterOrderAmount(EventDto eventDto) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%s원%n%n", standard.format(eventDto.getAfterOrderAmount()));
    }

    private void printEventBadgeStatus(EventDto eventDto) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventDto.getBadgeStatus());
    }
}
