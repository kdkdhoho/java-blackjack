package blackjack.domain.card;

import static blackjack.domain.card.Denomination.TEN;
import static blackjack.domain.result.Result.DRAW;
import static blackjack.domain.result.Result.LOSE;
import static blackjack.domain.result.Result.WIN;
import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.J;
import static blackjack.domain.card.Denomination.K;
import static blackjack.domain.card.Denomination.THREE;
import static blackjack.domain.card.Denomination.TWO;
import static blackjack.domain.card.Suit.CLOVER;
import static blackjack.domain.card.Suit.DIAMOND;
import static blackjack.domain.card.Suit.HEART;
import static blackjack.domain.card.Suit.SPADE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

final class HandTest {

    private final List<Card> cards = new ArrayList<>(
            List.of(Card.of(ACE, HEART),
                    Card.of(TWO, DIAMOND))
    );
    private Hand hand;

    @BeforeEach
    void setUp() {
        this.hand = new Hand(cards);
    }

    @Test
    @DisplayName("ACE, TWO 카드의 총점을 계산한다.")
    void totalScoreTest_AceTwo() {
        assertThat(hand.totalScore()).isEqualTo(13);
    }

    @Test
    @DisplayName("TWO, THREE 카드의 총점을 계산한다.")
    void totalScoreTest_TwoThree() {
        hand = new Hand(List.of(
                Card.of(TWO, HEART),
                Card.of(THREE, HEART)
        ));

        assertThat(hand.totalScore()).isEqualTo(5);
    }

    @Test
    @DisplayName("ACE, K 카드의 총점을 계산한다.")
    void totalScoreTest_AceK() {
        hand = new Hand(List.of(
                Card.of(ACE, HEART),
                Card.of(K, HEART)
        ));

        assertThat(hand.totalScore()).isEqualTo(21);
    }

    @Test
    @DisplayName("ACE, ACE 카드의 총점을 계산한다.")
    void totalScoreTest_AceAce() {
        hand = new Hand(List.of(
                Card.of(ACE, HEART),
                Card.of(ACE, DIAMOND)
        ));

        assertThat(hand.totalScore()).isEqualTo(12);
    }

    @Test
    @DisplayName("ACE, Ace, Ace 카드의 총점을 계산한다.")
    void totalScoreTest_AceAceAce() {
        hand = new Hand(List.of(
                Card.of(ACE, HEART),
                Card.of(ACE, DIAMOND),
                Card.of(ACE, CLOVER)
        ));

        assertThat(hand.totalScore()).isEqualTo(13);
    }

    @Test
    @DisplayName("새로운 카드를 한 장 추가로 받는다.")
    void addTest() {
        Hand newHand = this.hand.add(Card.of(TWO, CLOVER));

        assertThat(newHand.getHand().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("버스트인지 확인한다.")
    void isBustTest() {
        this.hand = new Hand(List.of(
                Card.of(J, HEART),
                Card.of(K, HEART),
                Card.of(TWO, SPADE)
        ));

        assertThat(this.hand.isBust()).isTrue();
    }

    @Test
    @DisplayName("블랙잭인지 확인한다.")
    void isBlackjackTest() {
        this.hand = new Hand(List.of(
                Card.of(ACE, HEART),
                Card.of(K, HEART)
        ));

        assertThat(this.hand.isBlackjack()).isTrue();
    }

    @Test
    @DisplayName("상대방의 카드와 비교하여 결과를 반환한다.")
    void compareHandToTest_win() {
        Hand anotherHand = new Hand(List.of(
                Card.of(TWO, HEART),
                Card.of(THREE, SPADE)
        ));

        assertThat(this.hand.compareHandTo(anotherHand)).isEqualTo(WIN);
    }

    @Test
    @DisplayName("상대방의 카드와 비교하여 결과를 반환한다.")
    void compareHandToTest_draw() {
        Hand anotherHand = new Hand(List.of(
                Card.of(ACE, HEART),
                Card.of(TWO, SPADE)
        ));

        assertThat(this.hand.compareHandTo(anotherHand)).isEqualTo(DRAW);
    }

    @Test
    @DisplayName("상대방의 카드와 비교하여 결과를 반환한다.")
    void compareHandToTest_lose() {
        Hand anotherHand = new Hand(List.of(
                Card.of(ACE, HEART),
                Card.of(K, SPADE)
        ));

        assertThat(this.hand.compareHandTo(anotherHand)).isEqualTo(LOSE);
    }

    @Test
    @DisplayName("상대방이 버스트인 경우 테스트한다.")
    void compareHandToTest_bust() {
        Hand anotherHand = new Hand(List.of(
                Card.of(TEN, HEART),
                Card.of(K, SPADE),
                Card.of(K, CLOVER)
        ));

        assertThat(this.hand.compareHandTo(anotherHand)).isEqualTo(WIN);
    }
}
