package blackjack.domain;

import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Player;
import blackjack.domain.participant.Players;

public final class BlackjackGame {

    private final Dealer dealer;
    private final Players players;

    public BlackjackGame(final Dealer dealer, final Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public void saveBettingMoney(final Player player, final Money money) {
        this.dealer.saveBettingMoney(player, money);
    }

    public void settingGame() {
        dealer.settingCards(players);
        dealer.settingSelf();
    }

    public void drawDealer() {
        dealer.drawIfLowerOrEquals16();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Players getPlayers() {
        return players;
    }
}
