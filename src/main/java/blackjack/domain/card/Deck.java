package blackjack.domain.card;

import static java.util.Collections.shuffle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public final class Deck {

    private final Deque<Card> deck;

    public Deck() {
        List<Card> cards = Card.getDeck();
        shuffle(cards);
        deck = new ConcurrentLinkedDeque<>(cards);
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("현재 남아있는 카드가 존재하지 않습니다.");
        }
        return deck.pop();
    }

    public List<Card> drawTwoCard() {
        return new ArrayList<>(List.of(drawCard(), drawCard()));
    }

    public List<Card> getDeck() {
        return List.copyOf(deck);
    }
}
