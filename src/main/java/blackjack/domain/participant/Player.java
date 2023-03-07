package blackjack.domain.participant;

import blackjack.domain.card.Cards;

public final class Player extends Participant {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        super(new Cards());
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (MAX_NAME_LENGTH < name.length() || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름 길이는 최소 " + MIN_NAME_LENGTH + "글자에서 최대 " + MAX_NAME_LENGTH + "글자 입니다. 입력값: " + name);
        }
    }

    public boolean isBust() {
        return this.cards.isBust();
    }

    public String getName() {
        return this.name;
    }
}
