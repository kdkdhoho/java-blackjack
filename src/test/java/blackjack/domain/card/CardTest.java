package blackjack.domain.card;

import static blackjack.domain.card.Denomination.ACE;
import static blackjack.domain.card.Denomination.TEN;
import static blackjack.domain.card.Denomination.TWO;
import static blackjack.domain.card.Suit.DIAMOND;
import static blackjack.domain.card.Suit.HEART;
import static blackjack.domain.card.Suit.SPADE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

class CardTest {

    @ParameterizedTest(name = "{0} 카드의 점수를 반환한다.")
    @CsvSource(value = {"ACE:1", "TWO:2", "J:10", "Q:10", "K:10"}, delimiter = ':')
    void scoreTest(final Denomination denomination, final int expect) {
        Card card = Card.of(denomination, HEART);

        assertThat(card.score()).isEqualTo(expect);
    }

    @Test
    @DisplayName("카드 52장을 캐시한다.")
    void 카드_52장을_캐시한다() {
        List<Card> deck = Card.getDeck();

        assertThat(deck.size()).isEqualTo(52);
    }

    @Test
    @DisplayName("Denomination과 Suit를 통해 카드를 반환한다.")
    void Denomination과_Suit를_통해_카드를_반환한다() {
        Card card = Card.of(TEN, SPADE);

        assertAll(
                () -> assertThat(card.getDenomination()).isEqualTo(TEN),
                () -> assertThat(card.getSuit()).isEqualTo(SPADE)
        );
    }

    @Test
    @DisplayName("카드의 점수를 반환한다.")
    void 카드의_점수를_반환한다() {
        Card card = Card.of(TEN, DIAMOND);

        assertThat(card.score()).isEqualTo(10);
    }

    @Test
    @DisplayName("카드가 Ace인지 반환한다")
    void 카드가_Ace인지_반환한다_false() {
        Card card = Card.of(ACE, DIAMOND);

        assertThat(card.isAce()).isTrue();
    }

    @Test
    @DisplayName("카드가 Ace인지 반환한다")
    void 카드가_Ace인지_반환한다_true() {
        Card card = Card.of(TWO, DIAMOND);

        assertThat(card.isAce()).isFalse();
    }

    @Test
    @DisplayName("캐시 데이터인 Deck을 복사하여 반환한다")
    void 캐시_데이터인_Deck을_복사하여_반환한다() {
        List<Card> deckBefore = Card.getDeck();
        deckBefore.add(Card.of(ACE, HEART));

        List<Card> deckAfter = Card.getDeck();

        assertThat(deckBefore.size()).isNotEqualTo(deckAfter.size());
    }

    @Test
    @DisplayName("논리적으로 같은 객체가 된다")
    void 논리적으로_같은_객체가_된다() {
        Card card = Card.of(ACE, HEART);
        Card otherCard = Card.of(ACE, HEART);

        assertThat(card.equals(otherCard)).isTrue();
    }
}
