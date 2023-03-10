package blackjack.card;

import static blackjack.card.Suit.HEART;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CardTest {

    @ParameterizedTest(name = "{0} 카드의 점수를 반환한다.")
    @CsvSource(value = {"ACE:1", "TWO:2", "J:10", "Q:10", "K:10"}, delimiter = ':')
    void scoreTest(Denomination denomination, int expect) {
        Card card = new Card(denomination, HEART);

        assertThat(card.score()).isEqualTo(expect);
    }
}
