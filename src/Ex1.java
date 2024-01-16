import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Introduction to Computer Science, Ariel University, Ex1 (manual Example + a Template for your solution)
 * See: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 *
 * Ex1 Bulls & Cows - Automatic solution.
 * **** Add a general readme text here ****
 * Add your explanation here:
 *
 *
 * **** General Solution (algorithm) ****
 * Add your explanation here:
 *
 *
 *
 * **** Results ****
 * Make sure to state the average required guesses
 * for 2,3,4,5,6 digit code:
 *
 * Average required guesses 2: ___
 * Average required guesses 3: ___
 * Average required guesses 4: ___
 * Average required guesses 5: ___
 * Average required guesses 6: ___
 *
 */
public class Ex1 {
    public static final String Title = "Ex1 demo: manual Bulls & Cows game";
    private static ArrayList<Integer> SpecialNums = new ArrayList<>();
    public static void main(String[] args) {
   BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 123456789L;             // Your ID should be written here
        int numOfDigits = 2;                // Number of digits [2,6]
        game.startGame(myID, numOfDigits);  // Starting a game
        System.out.println(Title+" with code of "+numOfDigits+" digits");
//        ArrayList <Integer> all=new ArrayList<>();
//        ArrayList <Integer> toRemove=new ArrayList<>();
//        int[] res={1,1};
//        for (int i = 0; i < 100; i++) {
//            all.add(i);
//
//        }
//        toRemove=NumberRemover(10,2,res);
//        System.out.println(toRemove);


        //manualEx1Game(game);
        // Example usage of HasCommonNumbers
//        int num1 = 123;
//        ArrayList<Integer> numbersList = new ArrayList<>();
//        numbersList.add(100);
//        numbersList.add(000);
//        numbersList.add(000);
//
//        int numOfDigits2 = 3;
//
//        boolean hasCommonNumbers = HasCommonNumbers(num1, numbersList, numOfDigits);
//
//        System.out.println("num1: " + num1);
//        System.out.println("Numbers List: " + numbersList);
//        System.out.println("Has Common Numbers: " + hasCommonNumbers);
          autoEx1Game(game); // you should implement this function )and any additional required functions).
//        int totalTries = 50;
//        int totalWins = 0;
//
//        for (int i = 0; i < totalTries; i++) {
//            BP_Server game = new BP_Server();
//            game.startGame(123456789L, 2); // Replace with your actual ID and numOfDigits
//            int roundsToWin = Ex1.autoEx1Game(game);
//
//            if (!game.isRunning()) {
//                totalWins++;
//            }
//        }
//
//        System.out.println("Number of wins: " + totalWins);
    }
    public static void manualEx1Game(BP_Server game) {
        Scanner sc = new Scanner(System.in);
        int ind=1;      // Index of the guess
        int numOfDigits = game.getNumOfDigits();
        double max = Math.pow(10,numOfDigits);
        while(game.isRunning()) {           // While the game is running (the code has not been found yet
            System.out.println(ind+") enter a guess: ");
            int g = sc.nextInt();
            if(g>=0 && g<max) {
                int[] guess = toArray(g, numOfDigits); // int to digit array
                int[] res = game.play(guess); // Playing a round and getting the B,C
                if (game.isRunning()) {     // While the game is running
                    System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
                    ind += 1;               // Increasing the index

                }
            }
            else {
                System.out.println("ERR: wrong input, try again");
            }
        }
        System.out.println(game.getStatus());
    }


    /**
     * Simple parsing function that gets an int and returns an array of digits
     * @param a - a natural number (as a guess)
     * @param size  - number of digits (to handle the 00 case).
     * @return an array of digits
     */
    private static int[] toArray(int a, int size){
        int[] c = new int[size];
        for(int j=0;j<c.length;j+=1) {
            c[j] = a%10;
            a=a/10;
        }
        return c;
    }
    private static int[] toArrayReverse(int a, int size) {
        int[] c = new int[size];
        for (int j = c.length - 1; j >= 0; j--) {
            c[j] = a % 10;
            a = a / 10;
        }
        return c;
    }

    public static int[] generateGuess(int numOfDigits) {
        int[] guess = new int[numOfDigits];
        for (int i = 0; i < numOfDigits; i++) {
            guess[i] = i;
        }
        return guess;

    }
////////////////////////////////////////////////////
    /**
     * This function solves the Bulls & Cows game automatically.
     * You should implement
     * **** Add a specific explanation for each function ****
     *
     */
    public static int autoEx1Game(BP_Server game) {
        int ind = 1;  // Index of the guess
        int numOfDigits = game.getNumOfDigits();
        double max = Math.pow(10, numOfDigits);
        ArrayList<Integer> AllNumbers = new ArrayList<>();
        ArrayList<Integer> toRemove = new ArrayList<>();
        int[] guess = generateGuess(numOfDigits);ArrayList<Integer> SpecialNums=new ArrayList<>();
        System.out.println("Guess: "+IntFromArray(guess));

        for (int i = 0; i < max; i++) {
            AllNumbers.add(i);
        }
        while (game.isRunning() && !AllNumbers.isEmpty()) {
            int[] res = game.play(guess); // Playing a round and getting the B,C
            int index=AllNumbers.indexOf(IntFromArray(guess));
            AllNumbers.remove(index);
            toRemove = NumberRemover(IntFromArray(guess), numOfDigits, res);

            AllNumbers.removeAll(toRemove);

            if(!AllNumbers.isEmpty()) guess = toArrayReverse(getRandomFromWithPriority(AllNumbers, numOfDigits), numOfDigits);

            if (game.isRunning()) {
                System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]);
                System.out.println("toRemove: " + toRemove);

                System.out.println("AllNumbers size after removal: " + AllNumbers.size());
                System.out.println("New guess: " + Arrays.toString(guess));
                ind += 1;
            } else {
                break;
            }
        }
        System.out.println(game.getStatus());

        return ind;
    }

    private static int IntFromArray(int[] digitArray) {
        String a = "";
        for (int i = 0; i < digitArray.length; i++) {
            a += Integer.toString(digitArray[i]);
        }
        return Integer.parseInt(a); // Parse string to int
    }

    public static ArrayList <Integer> NumberRemover(int guess, int numOfDigits, int[] res){
        ArrayList<Integer> toRemove = new ArrayList<>();
        double max = Math.pow(10, numOfDigits);
        int B = res[0];
        int C = res[1];
        // Conditions for removing elements from AllNumbers
        for (int i = 0; i < max; i++) {
            if (numOfDigits >= 2 && numOfDigits <= 6) {
                if ((B + C == 0)&&HasCommonNumbers(i,guess,numOfDigits)
                        || ((B == 1 && C == 0) && !HasCommonDigits(i, guess, numOfDigits))
                        || (B == 0 && C == 1 &&!HasCorrectCows(i,guess,numOfDigits))
                        ||(B+C==numOfDigits&&!AreAnagrams(i,guess,numOfDigits))) {
                    toRemove.add(i);
                }

            }
        }

        return toRemove;
    }
    public static boolean HasCommonNumbers(int num1, ArrayList <Integer>Numbers,int numOfDigits) {
         if(Numbers.isEmpty()||Numbers==null)return true;
        int tempnum=num1;

        for (int i = 0; i <Numbers.size() ; i++) {
            int count=0;
            for (int j = 0; j < numOfDigits; j++) {
                if(HasCommonNumbers(num1%10,Numbers.get(i),numOfDigits))count++;
                num1=num1/10;

            }
            if(count==0)return false;
            num1=tempnum;


        }
        return true;
    }
    private static int countEliminatedOptions(int[] guess, int guessNum, int outcome, ArrayList<Integer> options, int numOfDigits) {
        int eliminated = 0;

        for (int option : options) {
            int[] optionArray = toArray(option, numOfDigits);
            int[] simulatedRes = simulateGuess(guess, optionArray);
            int simulatedOutcome = getOutcomeFromResult(simulatedRes, numOfDigits);

            if (simulatedOutcome != outcome) {
                eliminated++;
            }
        }

        return eliminated;
    }
    private static int getOutcomeFromResult(int[] result, int numOfDigits) {
        int B = result[0];
        int C = result[1];

        if (numOfDigits == 2) {
            int[] mapping = {20, 10, 01, 00, 02}; // Map desired outcomes to encoded outcomes
            int desiredOutcome = B * 10 + C;
            for (int i = 0; i < mapping.length; i++) {
                if (mapping[i] == desiredOutcome) {
                    return i;
                }
            }
        } else if (numOfDigits == 3) {
            int[] mapping = {30, 20, 00, 01, 02, 03, 10, 12, 11}; // Map desired outcomes to encoded outcomes
            int desiredOutcome = B * 10 + C;
            for (int i = 0; i < mapping.length; i++) {
                if (mapping[i] == desiredOutcome) {
                    return i;
                }
            }
        } else if (numOfDigits == 4) {
            int[] mapping = {40, 30, 20, 21, 22, 00, 01, 02, 03, 04, 10, 20, 12, 13}; // Map desired outcomes to encoded outcomes
            int desiredOutcome = B * 10 + C;
            for (int i = 0; i < mapping.length; i++) {
                if (mapping[i] == desiredOutcome) {
                    return i;
                }
            }
        } else if (numOfDigits == 5) {
            int[] mapping = {00, 01, 02, 03, 04, 05, 10, 11, 12, 13, 14, 20, 21, 22, 23, 30, 31, 32, 40, 50}; // Map desired outcomes to encoded outcomes
            int desiredOutcome = B * 10 + C;
            for (int i = 0; i < mapping.length; i++) {
                if (mapping[i] == desiredOutcome) {
                    return i;
                }
            }
        } else if (numOfDigits == 6) {
            int[] mapping = {00, 01, 02, 03, 04, 05, 10, 11, 12, 13, 14, 20, 21, 22, 23, 30, 31, 32, 40, 50, 41, 42, 33, 24, 15, 06, 60};
            int desiredOutcome = B * 10 + C;
            for (int i = 0; i < mapping.length; i++) {
                if (mapping[i] == desiredOutcome) {
                    return i;
                }
            }
        }

        return -1;


    }
    public static int MinEliminations(int[] guess, int numOfDigits, ArrayList<Integer> AllNumbers) {
        int minEliminated = Integer.MAX_VALUE;
        int bestOutcome = -1;
        int AllOutcomes;
        if (numOfDigits == 2) AllOutcomes = 5;
        if (numOfDigits == 3) AllOutcomes = 9;
        if (numOfDigits == 4) AllOutcomes = 14;
        if (numOfDigits == 5) AllOutcomes = 20;
        if (numOfDigits == 6) AllOutcomes = 27;
        else {
            AllOutcomes = 1;
        }
        ;


        for (int outcome = 0; outcome < AllOutcomes; outcome++) {
            int eliminated = countEliminatedOptions(guess, IntFromArray(guess), outcome, AllNumbers, numOfDigits);
            if (eliminated < minEliminated) {
                minEliminated = eliminated;
                bestOutcome = outcome;
            }
        }
        return minEliminated;

    }

    // Helper function to simulate a guess and get the result
    private static int[] simulateGuess(int[] guess, int[] option) {
        int B = 0, C = 0;

        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == option[i]) {
                B++;
            } else if (containsDigit(option, guess[i])) {
                C++;
            }
        }

        return new int[]{B, C};
    }
    private static boolean containsDigit(int[] array, int digit) {
        for (int num : array) {
            if (num == digit) {
                return true;
            }
        }
        return false;
    }
    public static int getRandomFromWithPriority(ArrayList<Integer> nums, int numOfDigits) {
        if (nums == null || nums.isEmpty()) {
            return -1;
        }
        double max=Math.pow(10,numOfDigits);
        int[] priorities = new int[(int) max];
        ArrayList<Integer> AllNumbers2=new ArrayList<>();
        for (int i = 0; i <max; i++) {
            AllNumbers2.add(i);

        }

        for (int i = 0; i < max; i++) {
            priorities[i] = MinEliminations(toArray(i, numOfDigits), numOfDigits, AllNumbers2);
        }

        // Find the maximum priority value
        int maxPriority = Integer.MIN_VALUE;
        for (int priority : priorities) {
            maxPriority = Math.max(maxPriority, priority);
        }

        // Create a list to store numbers with the maximum priority
        ArrayList<Integer> maxPriorityNums = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (priorities[nums.get(i)] == maxPriority) {
                maxPriorityNums.add(nums.get(i));
            }
        }

        // If there are numbers with the maximum priority, randomly choose from them
        if (!maxPriorityNums.isEmpty()) {
            return maxPriorityNums.get((int) (Math.random() * maxPriorityNums.size()));
        }

        // If there are no numbers with the maximum priority, choose from the next priority level
        for (int currentPriority = maxPriority - 1; currentPriority >= 0; currentPriority--) {
            ArrayList<Integer> currentPriorityNums = new ArrayList<>();
            for (int i = 0; i < nums.size(); i++) {
                if (priorities[nums.get(i)] == currentPriority) {
                    currentPriorityNums.add(nums.get(i));
                }
            }
            if (!currentPriorityNums.isEmpty()) {
                return currentPriorityNums.get((int) (Math.random() * currentPriorityNums.size()));
            }
        }

        // If there are no numbers in the list, return a random number (this should not happen)
        return nums.get((int) (Math.random() * nums.size()));
    }

    private static boolean HasCorrectCows(int num1, int num2, int numOfDigits) {
        int count = 0;
        int[] number1=toArray(num1,numOfDigits);
        int[] number2=toArray(num2,numOfDigits);
        for (int i = 0; i <numOfDigits ; i++) {
            for (int j = 0; j < numOfDigits; j++) {
                if(i==j&& number1[i] == number2[j])return false;
                if (i != j && number1[i] == number2[j])count++;
            }
        }
        return count>=1;

    }
    public static boolean AreAnagrams(int num1, int num2, int numOfDigits) {
        int[] colors1 = new int[10];
        int[] colors2 = new int[10];

        // Initialize arrays
        Arrays.fill(colors1, 0);
        Arrays.fill(colors2, 0);

        // Count occurrences of each digit in num1
        for (int i = 0; i < numOfDigits; i++) {
            colors1[num1%10]++;
            colors2[num2%10]++;
        }

        // Compare arrays
        return Arrays.equals(colors1, colors2);
    }

    public static boolean HasCommonNumbers(int num1, int num2, int numOfDigits) {
        int[] number1=toArray(num1,numOfDigits);
        int[] number2=toArray(num2,numOfDigits);
        for (int i = 0; i < numOfDigits; i++) {
            for (int j = 0; j <numOfDigits ; j++) {
                if(number1[i]==number2[j])return true;
            }
        }
        return false;
    }
    public static boolean HasCommonDigits(int num1, int num2, int numOfDigits) {
        for (int i = 0; i < numOfDigits; i++) {
            if(num1%10==num2%10)return true;
            num1/=10;
            num2/=10;
        }
        return false;
    }
}
