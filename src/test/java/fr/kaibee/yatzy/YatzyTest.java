package fr.kaibee.yatzy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @ParameterizedTest
    @MethodSource("chanceScoringRuleUseCaseProvider")
    void should_score_sum_of_all_dices_when_is_placed_on_chances(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.chance();
        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> chanceScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(2, 3, 4, 5, 1, 15),
                Arguments.of(3, 3, 4, 5, 1, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("yatzyScoringRuleUseCaseProvider")
    void should_score_50_when_all_dice_have_the_same_number(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.yatzy();
        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> yatzyScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(4, 4, 4, 4, 4, 50),
                Arguments.of(6, 6, 6, 6, 6, 50),
                Arguments.of(6, 6, 6, 6, 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("oneScoringRuleUseCaseProvider")
    void should_score_the_sum_of_dice_that_read_one(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.ones();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> oneScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 4, 5, 1),
                Arguments.of(1, 2, 1, 4, 5, 2),
                Arguments.of(6, 2, 2, 4, 5, 0),
                Arguments.of(1, 2, 1, 1, 1, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("twosScoringRuleUseCaseProvider")
    void should_score_the_sum_of_dice_that_read_two(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.twos();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> twosScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2, 6, 4),
                Arguments.of(2, 2, 2, 2, 2, 10),
                Arguments.of(1, 5, 3, 4, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threeScoringRuleUseCaseProvider")
    void should_score_the_sum_of_dice_that_read_three(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.threes();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> threeScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2, 3, 6),
                Arguments.of(2, 3, 3, 3, 3, 12),
                Arguments.of(2, 5, 4, 6, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fourScoringRuleUseCaseProvider")
    void should_score_the_sum_of_dice_that_read_four(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.fours();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> fourScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(4, 4, 4, 5, 5, 12),
                Arguments.of(4, 4, 5, 5, 5, 8),
                Arguments.of(4, 5, 5, 5, 5, 4),
                Arguments.of(5, 2, 3, 1, 5, 0)
        );
    }


    @ParameterizedTest
    @MethodSource("fiveScoringRuleUseCaseProvider")
    void should_score_the_sum_of_dice_that_read_five(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.fives();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> fiveScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(4, 4, 4, 5, 5, 10),
                Arguments.of(4, 4, 5, 5, 5, 15),
                Arguments.of(4, 5, 5, 5, 5, 20),
                Arguments.of(4, 3, 2, 6, 6, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("sixesScoringRuleUseCaseProvider")
    void should_score_the_sum_of_dice_that_read_six(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.sixes();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> sixesScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(4, 4, 4, 5, 5, 0),
                Arguments.of(4, 4, 6, 5, 5, 6),
                Arguments.of(6, 5, 6, 6, 5, 18)
        );
    }

    @ParameterizedTest
    @MethodSource("scorePairScoringRuleUseCaseProvider")
    void should_score_sum_of_the_two_highest_matching_dice_when_placed_on_pair(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scorePair();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scorePairScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(3, 4, 3, 5, 6, 6),
                Arguments.of(5, 3, 3, 3, 5, 10),
                Arguments.of(5, 3, 6, 6, 5, 12),
                Arguments.of(5, 6, 6, 6, 5, 12),
                Arguments.of(2, 1, 3, 6, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scoreTwoPairsScoringRuleUseCaseProvider")
    void should_score_sum_of_dice_of_two_pairs_with_same_number_when_placed_on_two_pairs(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scoreTwoPairs();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scoreTwoPairsScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(3, 3, 5, 4, 5, 16),
                Arguments.of(3, 3, 5, 5, 5, 16),
                Arguments.of(1, 2, 3, 1, 4, 0),
                Arguments.of(3, 3, 1, 3, 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scoreThreeOfKindScoringRuleUseCaseProvider")
    void should_score_sum_of_three_dice_with_the_same_number_when_placed_on_three_of_kind(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scoreThreeOfKind();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scoreThreeOfKindScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(3, 3, 3, 4, 5, 9),
                Arguments.of(5, 3, 5, 4, 5, 15),
                Arguments.of(3, 3, 3, 3, 5, 9),
                Arguments.of(3, 3, 3, 3, 3, 9),
                Arguments.of(3, 5, 4, 3, 6, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scoreFourOfKindScoringRuleUseCaseProvider")
    void should_score_sum_of_four_dice_with_the_same_number_when_placed_on_four_of_kind(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scoreFourOfKind();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scoreFourOfKindScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(3, 3, 3, 3, 5, 12),
                Arguments.of(5, 5, 5, 4, 5, 20),
                Arguments.of(5, 2, 2, 5, 5, 0),
                Arguments.of(5, 1, 4, 6, 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scoreSmallStraightScoringRuleUseCaseProvider")
    void should_score_sum_of_all_dice_when_it_is_placed_on_small_straight(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scoreSmallStraight();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scoreSmallStraightScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 4, 5, 15),
                Arguments.of(2, 3, 4, 5, 1, 15),
                Arguments.of(1, 2, 2, 4, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scoreLargeStraightScoringRuleUseCaseProvider")
    void should_score_sum_of_all_dice_when_it_is_placed_on_large_straight(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scoreLargeStraight();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scoreLargeStraightScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(6, 2, 3, 4, 5, 20),
                Arguments.of(2, 3, 4, 5, 6, 20),
                Arguments.of(1, 2, 2, 4, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("scoreFullHouseScoringRuleUseCaseProvider")
    void should_score_sum_of_all_dice_when_the_dice_are_two_and_three_of_kind_and_placed_on_fullHouse(int d1, int d2, int d3, int d4, int d5, int expectedScore) {
        Yatzy yatzy = new Yatzy(d1, d2, d3, d4, d5);
        int actualScore = yatzy.scoreFullHouse();

        assertEquals(expectedScore, actualScore);
    }

    private static Stream<Arguments> scoreFullHouseScoringRuleUseCaseProvider() {
        return Stream.of(
                Arguments.of(6, 2, 2, 2, 6, 18),
                Arguments.of(2, 2, 3, 3, 4, 0),
                Arguments.of(4, 4, 4, 4, 4, 0)
        );
    }
}
