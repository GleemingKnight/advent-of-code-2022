package me.gleeming.aoc.two;

import java.io.File;
import java.util.Scanner;

/**
 * completed in:
 * part 1 - 9:01
 * part 2 - 13:40
 * global rank: 1984
 */

/**
 * Rock = X
 * Paper = Y
 * Scissors = Z

 * Score:
 * 0 for loosing
 * 3 for drawing
 * 6 for winning

 * 1 score for rock
 * 2 score for paper
 * 3 score for scissors
 */
public class DayTwo {

    enum Turn {
        ROCK(1), PAPER(2), SCISSORS(3);

        int score;

        Turn(int score) {
            this.score = score;
        }

        boolean beats(Turn turn) {
            if (this == ROCK) {
                return turn == SCISSORS;
            }

            if (this == PAPER) {
                return turn == ROCK;
            }

            return turn == PAPER;
        }

        static Turn parse(String str) {
            if (str.equals("A") || str.equals("X")) {
                return ROCK;
            }

            if (str.equals("B") || str.equals("Y")) {
                return PAPER;
            }

            return SCISSORS;
        }
    }

    enum Result {
        WIN, LOSS, DRAW;

        static Result parse(String str) {
            if (str.equals("X")) {
                return LOSS;
            }

            if (str.equals("Y")) {
                return DRAW;
            }

            return WIN;
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("input");
        Scanner scanner = new Scanner(file);

        int score = 0;

        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String split[] = nextLine.split(" ");

            Turn opponentTurn = Turn.parse(split[0]);
            Turn yourTurn = Turn.parse(split[1]);

            score += yourTurn.score;

            // draw
            if (!opponentTurn.beats(yourTurn) && !yourTurn.beats(opponentTurn)) {
                score += 3;
                continue;
            }

            // win
            if (yourTurn.beats(opponentTurn)) {
                score += 6;
            }
        }

        // first answer
        System.out.println(score);

        scanner = new Scanner(file);
        score = 0;

        while(scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String split[] = nextLine.split(" ");

            Turn opponentTurn = Turn.parse(split[0]);
            Result neededResult = Result.parse(split[1]);

            Turn chosenTurn = null;

            if (neededResult == Result.DRAW) {
                chosenTurn = opponentTurn;
                score += 3;
            }

            if (neededResult == Result.WIN) {
                score += 6;
                chosenTurn = (opponentTurn == Turn.ROCK ? Turn.PAPER : opponentTurn == Turn.SCISSORS ? Turn.ROCK : Turn.SCISSORS);
            }

            if (neededResult == Result.LOSS) {
                chosenTurn = (opponentTurn == Turn.ROCK ? Turn.SCISSORS : opponentTurn == Turn.SCISSORS ? Turn.PAPER : Turn.ROCK);
            }

            score += chosenTurn.score;
        }

        // second answer
        System.out.println(score);
    }
}
