package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Card {

    private static final List<Card> CACHE = new ArrayList<>();

    private final Denomination denomination;
    private final Suit suit;

    static {
        initCache();
    }

    private static void initCache() {
        for (Denomination denomination : Denomination.values()) {
            fillCards(denomination);
        }
    }

    private static void fillCards(final Denomination denomination) {
        for (Suit suit : Suit.values()) {
            CACHE.add(new Card(denomination, suit));
        }
    }

    private Card(final Denomination denomination, final Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public static Card of(Denomination denomination, Suit suit) {
        Card wantedCard = new Card(denomination, suit);
        int indexOfWantedCard = CACHE.indexOf(wantedCard);
        return CACHE.get(indexOfWantedCard);
    }

    public int score() {
        return denomination.getScore();
    }

    public boolean isAce() {
        return denomination.isAce();
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public static List<Card> getDeck() {
        return new ArrayList<>(CACHE);
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }
}
