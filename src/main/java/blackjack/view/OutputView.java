package blackjack.view;

import static java.lang.String.join;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printDistributeCardsMessage(List<String> players) {
        String names = join(", ", players);
        System.out.println("딜러와 " + names + "에게 2장을 나누었습니다.");
    }

    public void printDealerInitCards(String card) {
        System.out.println("딜러: " + card);
    }

    public void printPlayersInitCards(Map<String, List<String>> initCards) {
        for (String player : initCards.keySet()) {
            System.out.println(player + "카드: " + join(", ", initCards.get(player)));
        }
    }

    public void printCurrentCards(String playerName, List<String> currentCards) {
        System.out.println(playerName + "카드: " + join(", ", currentCards));
    }

    public void printDealerDrawOneMoreCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printDealerFinalCards(List<String> cards, int score) {
        System.out.println("딜러 카드: " + join(", ", cards) + " - 결과: " + score);
    }

    public void printPlayerFinalCards(Map<String, List<String>> cardsWithName, List<Integer> scores) {
        int index = 0;
        for (String playerName : cardsWithName.keySet()) {
            System.out.println(playerName + "카드: " + join(", ", cardsWithName.get(playerName)) +
                    " - 결과: " + scores.get(index++));
        }
    }

    public void printGameResult(List<Integer> dealerResult, Map<String, String> result) {
        System.out.println("딜러: " + dealerResult.get(0) + "승 " + dealerResult.get(1) + "무 " + dealerResult.get(2) + "패 ");
        for (String playerName : result.keySet()) {
            System.out.println(playerName + ":" + result.get(playerName));
        }
    }
}
