package fr.kaibee.yatzy;

import java.util.Arrays;

public class Yatzy {
    private int[] dice;
    private int[] occurrences;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        this.occurrences = computeOccurrences();
    }

    public int chance() {
        return getSumOfAllDice();
    }

    public int yatzy() {
        return isAllDiceHaveTheSameNumber() ? 50 : 0;
    }

    public int ones() {
        return getScoreByCategory(DiceCategory.ONE.getCategory());
    }

    public int twos() {
        return getScoreByCategory(DiceCategory.TWO.getCategory());
    }

    public int threes() {
        return getScoreByCategory(DiceCategory.THREE.getCategory());
    }

    public int fours() {
        return getScoreByCategory(DiceCategory.FOUR.getCategory());
    }

    public int fives() {
        return getScoreByCategory(DiceCategory.FIVE.getCategory());
    }

    public int sixes() {
        return getScoreByCategory(DiceCategory.SIX.getCategory());
    }

    public int scorePair() {
        for (int i = this.occurrences.length - 1; i > 0; i--) {
            if (isPlayerHasAPairOfMatchingDiceAt(i)) {
                return (i + 1) * 2;
            }
        }

        return 0;
    }

    public int scoreTwoPairs() {
        int numberOfMatchingPairs = 0;
        int score = 0;
        for (int i = 0; i < this.occurrences.length; i++) {
            if (isPlayerHasAPairOfMatchingDiceAt(i)) {
                numberOfMatchingPairs++;
                score += (i + 1) * 2;
            }
        }

        return isPlayerHasTwoPairsOfDiceWithTheSameNumber(numberOfMatchingPairs) ? score : 0;
    }

    public int scoreThreeOfKind() {
        for (int i = 0; i < this.occurrences.length; i++) {
            if (this.occurrences[i] >= 3) {
                return (i + 1) * 3;
            }
        }

        return 0;
    }

    public int scoreFourOfKind() {
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] >= 4) {
                return (i + 1) * 4;
            }
        }

        return 0;
    }

    public int scoreSmallStraight() {
        return isSmallStraight() ? getSumOfAllDice() : 0;
    }

    public int scoreLargeStraight() {
        return isLargeStraight() ? getSumOfAllDice() : 0;
    }

    public int scoreFullHouse() {
        boolean isTwoOfKind = Arrays.stream(this.occurrences).anyMatch(occ -> occ == 2);
        boolean isThreeOfKind = Arrays.stream(this.occurrences).anyMatch(occ -> occ == 3);

        return (isTwoOfKind && isThreeOfKind) ? getSumOfAllDice() : 0;
    }

    private int[] computeOccurrences() {
        int[] occurrencesTmp = new int[6];
        for (int die : dice) {
            occurrencesTmp[die - 1]++;
        }

        return occurrencesTmp;
    }

    private int getSumOfAllDice() {
        return Arrays.stream(dice).sum();
    }

    private boolean isAllDiceHaveTheSameNumber() {
        return Arrays.stream(this.occurrences).anyMatch(occ -> occ == 5);
    }

    private int getScoreByCategory(int category) {
        return Arrays.stream(dice).filter(die -> die == category).sum();
    }

    private boolean isPlayerHasAPairOfMatchingDiceAt(int occ) {
        return this.occurrences[occ] >= 2;
    }

    private boolean isPlayerHasTwoPairsOfDiceWithTheSameNumber(int numberOfMatchingPairs) {
        return numberOfMatchingPairs == 2;
    }

    private boolean isSmallStraight() {
        return Arrays.stream(occurrences).limit(5).allMatch(occ -> occ == 1);
    }

    private boolean isLargeStraight() {
        return Arrays.stream(occurrences).skip(1).allMatch(occ -> occ == 1);
    }
}



