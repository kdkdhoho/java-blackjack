package blackjack.domain.participant;

import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.TWO;
import static blackjack.domain.card.Suit.HEART;
import static blackjack.domain.card.Suit.SPADE;
import static blackjack.domain.participant.Players.PLAYERS_COUNT_ERROR_MESSAGE;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Hand;
import blackjack.domain.card.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class PlayersTest {

    private final List<Player> playerData = new ArrayList<>(List.of(
            new Player("player1"),
            new Player("player2")
    ));
    private Players players;

    @BeforeEach
    void setUp() {
        this.players = new Players(playerData);
    }

    @ParameterizedTest(name = PLAYERS_COUNT_ERROR_MESSAGE + "{0}")
    @ValueSource(ints = {1, 9})
    void create_invalidCount(int playerCount) {
        List<Player> players = IntStream.range(0, playerCount)
                .mapToObj(x -> new Player(String.valueOf(playerCount)))
                .collect(toList());

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Players(players)
        ).withMessage(PLAYERS_COUNT_ERROR_MESSAGE + players);
    }

    @Test
    @DisplayName("플레이어의 수와 다른 갯수의 Hand를 받으면 예외가 발생한다.")
    void distributeHandsTest_different_size_exception() {
        Hand hand = new Hand(List.of(new Card(ACE, HEART), new Card(TWO, SPADE)));
        List<Hand> hands = new ArrayList<>(List.of(hand));

        assertThatIllegalArgumentException().isThrownBy(
                () -> players.distributeHands(hands)
        ).withMessage("세팅 카드와 플레이어의 수가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("플레이어의 수에 일치한 Hands를 받으면 2장의 카드를 분배한다.")
    void distributeHandsTest() {
        Hand hand1 = new Hand(List.of(new Card(ACE, HEART), new Card(TWO, SPADE)));
        Hand hand2 = new Hand(List.of(new Card(ACE, HEART), new Card(TWO, SPADE)));
        List<Hand> hands = new ArrayList<>(List.of(hand1, hand2));

        assertThatNoException().isThrownBy(
                () -> players.distributeHands(hands)
        );
    }
}
