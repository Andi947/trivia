
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.Game;

import java.io.FileNotFoundException;
import java.util.Random;


public class GoldenMasterImproved {
    private static boolean notAWinner;

    public void main(int seed) throws FileNotFoundException {

        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Random rand = new Random(seed);

        do {

            int roll = rand.nextInt(5);
            int answer = rand.nextInt(9);

            aGame.roll(roll + 1);

            if (answer == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }

        } while (notAWinner);
    }
}
