import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {

    // Test method for autoEx1Game
    @Test
    public void testAutoEx1Game2Digit() {
        int totalRounds = 0;
        int numOfRuns = 100;

        for (int i = 0; i < numOfRuns; i++) {
            BP_Server game = new BP_Server();
            int numOfDigits = 2;
            game.startGame(123456789L, numOfDigits);
            Ex1 autoPlayer = new Ex1();

            totalRounds+=autoPlayer.autoEx1Game(game);
            // Get the number of rounds and accumulate




        }


        // Calculate the average
        double averageRounds = (double) totalRounds / numOfRuns;

        System.out.println("Average Rounds: " + averageRounds);
    }
    @Test
    public void testAutoSolvingGame() {
        int totalRounds = 3;
        int totalWins = 0;

        for (int i = 0; i < totalRounds; i++) {
            BP_Server game = new BP_Server();
            game.startGame(123456789L, 2); // Replace with your actual ID and numOfDigits
            int roundsToWin = Ex1.autoEx1Game(game);

            if (game.getStatus().equals("You won!")) {
                totalWins++;
            }
        }

        assertTrue(totalWins == totalRounds);
        System.out.println("Number of wins: " + totalWins);
        logger.info("Number of wins: " + totalWins);

    }
    private static final Logger logger = Logger.getLogger(Ex1Test.class.getName());
    // Additional test methods for other functionalities in Ex1
    @Test
    public void testAutoEx1Game3Digit() {
        int totalRounds = 0;
        int numOfRuns = 100;

        for (int i = 0; i < numOfRuns; i++) {
            BP_Server game = new BP_Server();
            int numOfDigits = 3;
            game.startGame(123456789L, numOfDigits);
            Ex1 autoPlayer = new Ex1();

            totalRounds+=autoPlayer.autoEx1Game(game);
            // Get the number of rounds and accumulate




        }

        // Calculate the average
        double averageRounds = (double) totalRounds / numOfRuns;

        System.out.println("Average Rounds: " + averageRounds);
    }
    @Test
    public void testAutoEx1Game4Digit() {
        int totalRounds = 0;
        int numOfRuns = 100;

        for (int i = 0; i < numOfRuns; i++) {
            BP_Server game = new BP_Server();
            int numOfDigits = 4;
            game.startGame(123456789L, numOfDigits);
            Ex1 autoPlayer = new Ex1();

            totalRounds+=autoPlayer.autoEx1Game(game);
            // Get the number of rounds and accumulate




        }

        // Calculate the average
        double averageRounds = (double) totalRounds / numOfRuns;

        System.out.println("Average Rounds: " + averageRounds);
    }
    @Test
    public void testAutoEx1Game5Digit() {
        int totalRounds = 0;
        int numOfRuns = 100;

        for (int i = 0; i < numOfRuns; i++) {
            BP_Server game = new BP_Server();
            int numOfDigits = 5;
            game.startGame(123456789L, numOfDigits);
            Ex1 autoPlayer = new Ex1();

            totalRounds+=autoPlayer.autoEx1Game(game);
            // Get the number of rounds and accumulate




        }

        // Calculate the average
        double averageRounds = (double) totalRounds / numOfRuns;

        System.out.println("Average Rounds: " + averageRounds);
    }
    @Test
    public void testAutoEx1Game6Digit() {
        int totalRounds = 0;
        int numOfRuns = 100;

        for (int i = 0; i < numOfRuns; i++) {
            BP_Server game = new BP_Server();
            int numOfDigits = 6;
            game.startGame(123456789L, numOfDigits);
            Ex1 autoPlayer = new Ex1();

            totalRounds+=autoPlayer.autoEx1Game(game);
            // Get the number of rounds and accumulate




        }

        // Calculate the average
        double averageRounds = (double) totalRounds / numOfRuns;

        System.out.println("Average Rounds: " + averageRounds);
    }
    public void testAnotherMethod() {
        // Test another method in Ex1
    }
}
