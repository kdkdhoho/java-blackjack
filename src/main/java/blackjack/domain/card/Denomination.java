package blackjack.domain.card;

public enum Denomination {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(10),
    Q(10),
    K(10);

    private final int score;

    Denomination(final int score) {
        this.score = score;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }
}