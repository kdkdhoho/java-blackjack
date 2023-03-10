package blackjack.view;

import static java.util.stream.Collectors.joining;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hand;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;

public class OutputView {

    public void printSettingGameMessage(final Dealer dealer, final Players players) {
        String playerNames = players.getPlayers().stream()
                .map(Player::getName)
                .collect(joining(", "));

        System.out.println(dealer.getName() + "와 " + playerNames + "에게 " + dealer.getInitCardCount() + "장을 나누었습니다.");
        System.out.println();

        System.out.println(dealer.getName() + ": " + cardToString(dealer.showOneCard()));
        for (Player player : players.getPlayers()) {
            System.out.println(player.getName() + ": " + handToString(player.getHand()));
        }
        System.out.println();
    }

    public void printPlayerHand(final Player player) {
        System.out.println(player.getName() + "카드: " + handToString(player.getHand()));
    }

    private String handToString(final Hand hand) {
        return hand.getHand().stream()
                .map(card -> "" + card.getDenomination().getName() + card.getSuit().getName())
                .collect(joining(", "));
    }

    private String cardToString(final Card card) {
        return "" + card.getDenomination().getName() + card.getSuit().getName();
    }

    public void printDealerDrawMessage(final Dealer dealer) {
        System.out.println(dealer.getName() + dealer.getCanDrawScore() + "점 이하라 한 장의 카드를 더 받았습니다.");
        System.out.println();
    }

    public void printLastCards(final Dealer dealer, final Players players) {

    }
}
