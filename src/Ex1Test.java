import org.junit.jupiter.api.Test;
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



            assertFalse(game.isRunning());
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



            assertFalse(game.isRunning());
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



            assertFalse(game.isRunning());
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



            assertFalse(game.isRunning());
        }

        // Calculate the average
        double averageRounds = (double) totalRounds / numOfRuns;

        System.out.println("Average Rounds: " + averageRounds);
    }
    public void testAnotherMethod() {
        // Test another method in Ex1
    }
}
