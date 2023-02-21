package fr.kaibee.yatzy;

import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void should_score_sum_of_all_dices_when_is_placed_on_chances() {
        int expected = 15;
        int actual = new Yatzy(2, 3, 4, 5, 1).chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
    }

    @Test
    public void should_score_50_when_all_dice_have_the_same_number() {
        int expected = 50;
        int actual = new Yatzy(4, 4, 4, 4, 4).yatzy();
        assertEquals(expected, actual);
        assertEquals(expected, new Yatzy(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void should_score_the_sum_of_dice_that_read_one() {
        assertEquals(1, new Yatzy(1, 2, 3, 4, 5).ones());
        assertEquals(2, new Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void should_score_the_sum_of_dice_that_read_two() {
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
        assertEquals(0, new Yatzy(1, 5, 3, 4, 5).twos());
    }

    @Test
    public void should_score_the_sum_of_dice_that_read_three() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
        assertEquals(0, new Yatzy(2, 5, 4, 6, 1).threes());
    }

    @Test
    public void should_score_the_sum_of_dice_that_read_four() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
        assertEquals(0, new Yatzy(5, 2, 3, 1, 5).fours());
    }

    @Test
    public void should_score_the_sum_of_dice_that_read_five() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
        assertEquals(0, new Yatzy(4, 3, 2, 6, 6).fives());
    }

    @Test
    public void should_score_the_sum_of_dice_that_read_six() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void should_score_sum_of_the_two_highest_matching_dice_when_placed_on_pair() {
        assertEquals(6, new Yatzy(3, 4, 3, 5, 6).scorePair());
        assertEquals(10, new Yatzy(5, 3, 3, 3, 5).scorePair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).scorePair());
        assertEquals(12, new Yatzy(5, 6, 6, 6, 5).scorePair());
        assertEquals(0, new Yatzy(2, 1, 3, 6, 5).scorePair());
    }

    @Test
    public void should_score_sum_of_dice_of_two_pairs_with_same_number_when_placed_on_two_pairs() {
        assertEquals(16, new Yatzy(3, 3, 5, 4, 5).scoreTwoPairs());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).scoreTwoPairs());
        assertEquals(0, new Yatzy(1, 2, 3, 1, 4).scoreTwoPairs());
        assertEquals(0, new Yatzy(3, 3, 1, 3, 3).scoreTwoPairs());
    }

    @Test
    public void should_score_sum_of_three_dice_with_the_same_number_when_placed_on_three_of_kind() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).scoreThreeOfKind());
        assertEquals(15, new Yatzy(5, 3, 5, 4, 5).scoreThreeOfKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 5).scoreThreeOfKind());
        assertEquals(9, new Yatzy(3, 3, 3, 3, 3).scoreThreeOfKind());
        assertEquals(0, new Yatzy(3, 5, 4, 3, 6).scoreThreeOfKind());
    }

    @Test
    public void should_score_sum_of_four_dice_with_the_same_number_when_placed_on_four_of_kind() {
        assertEquals(12, new Yatzy(3, 3, 3, 3, 5).scoreFourOfKind());
        assertEquals(20, new Yatzy(5, 5, 5, 4, 5).scoreFourOfKind());
        assertEquals(0, new Yatzy(5, 2, 2, 5, 5).scoreFourOfKind());
        assertEquals(0, new Yatzy(5, 1, 4, 6, 3).scoreFourOfKind());
    }

    @Test
    public void should_score_sum_of_all_dice_when_it_is_placed_on_small_straight() {
        assertEquals(15, new Yatzy(1, 2, 3, 4, 5).scoreSmallStraight());
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).scoreSmallStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).scoreSmallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
