package fr.kaibee.yatzy;

public enum DiceCategory {
    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6);

    private int category;

    DiceCategory(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }
}
