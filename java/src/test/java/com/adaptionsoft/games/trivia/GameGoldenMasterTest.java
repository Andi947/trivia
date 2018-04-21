package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GoldenMasterImproved;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameGoldenMasterTest {

    private int[] seedArray = new int[]{
            1, 5, 7, 20, 60, 50
    };

    @Test
    public void actualStreamOutputTest() throws IOException {
        for(int seed : seedArray){
            generateActual(seed);
            testSeed(seed);
        }

    }

    private static void generateActual(int seed) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new File("goldenMaster_actual.txt"));
        System.setOut(ps);

        GoldenMasterImproved gameRunner = new GoldenMasterImproved();

        gameRunner.main(seed);
    }

    private void testSeed(int seed) throws IOException {
        String fileGame = getFileAsString("", "goldenMaster" + seed + ".txt");
        String actualGame = getFileAsString("", "goldenMaster_actual.txt");

        assertThat(actualGame, is(fileGame));
    }

    private String getFileAsString(String fileGame, String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();

        while (line != null) {
            fileGame += line + "\n";
            line = reader.readLine();
        }
        return fileGame;
    }
}