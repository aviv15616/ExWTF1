import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int numOfDigits = 5;                // Number of digits [2,6]
        game.startGame(myID, numOfDigits);  // Starting a game
        System.out.println(Title + " with code of " + numOfDigits + " digits");
//        int num1 = 131;
//        int num2 = 343;
//
//
//        // Test the HowMuchCorrectCows method
//        int correctCows = HowMuchCorrectCows(num1, num2, numOfDigits);
//
//        // Print the result
//        System.out.println("Number 1: " + num1);
//        System.out.println("Number 2: " + num2);
//        System.out.println("Correct Cows: " + correctCows);
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
        //
         autoEx1Game(game); // you should implement this function )and any additional required functions).
        //manualEx1Game((game));
//        testAreAnagrams(123, 321, 3); // should print "Are Anagrams: true"
//        testAreAnagrams(123, 456, 3); // should print "Are Anagrams: false"
//        testAreAnagrams(112, 121, 3); // should print "Are Anagrams: true"
//    }
//
//    public static void testAreAnagrams(int num1, int num2, int numOfDigits) {
//        boolean result = AreAnagrams(num1, num2, numOfDigits);
//        System.out.println("Are Anagrams: " + result);
//    }

    }

    // Helper method to convert an array to a string for printing




    public static int SameDigits(int num1,int num2,int numOfDigits) {
    int count=0;
        for (int i = 0; i < numOfDigits; i++) {
            if (num1 % 10 == num2 % 10) count++;
            num1 /= 10;
            num2 /= 10;
        }
            return count;

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
    public static int getRandomExcluding(List<Integer> exclude) {
        if (exclude == null || exclude.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty.");
        }

        int randomNum;
        do {
            randomNum = (int) (Math.random() * 10);
        } while (exclude.contains(randomNum));

        return randomNum;
    }
    public static int[] DifferentGuess(int[] guess,int numOfDigits)
    { int[]DiffGuess=new int[numOfDigits];
        ArrayList <Integer>exclude=new ArrayList<>();
        for (int i = 0; i <numOfDigits ; i++) {
            exclude.add(guess[i]);
        }
        for (int i = 0; i <numOfDigits ; i++) {
          DiffGuess[i]=getRandomExcluding(exclude);
        }
       return DiffGuess;
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

//            int []results=countEliminatedOptions(AllNumbers,numOfDigits);
                if (!AllNumbers.isEmpty()) guess = toArrayReverse(getRandomFrom(AllNumbers), numOfDigits);




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
            if (numOfDigits == 2) {
                if ((B + C == 0) && HasCommonNumbers(i, guess, numOfDigits)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 1))) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 1))) {
                    toRemove.add(i);
                } else if ((C == 2) && !AreAnagrams(i, guess, numOfDigits)) {
                    toRemove.add(i);
                }
            } else if (numOfDigits == 3) {
                if ((B + C == 0) && HasCommonNumbers(i, guess, numOfDigits)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 1))) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 1))) {
                    toRemove.add(i);
                } else if (B == 1 && C == 1 && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 2 && C == 0) && (SameDigits(i, guess, numOfDigits) != 2)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 2)))
                    toRemove.add(i);
                else if ((C == 3 || (B == 1 && C == 2)) && !AreAnagrams(i, guess, numOfDigits)) {
                    toRemove.add(i);

                }
            }


            else if (numOfDigits == 4) {
                if ((B + C == 0) && HasCommonNumbers(i, guess, numOfDigits)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 0) && (SameDigits(i, guess, numOfDigits) != 1)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 1))) {
                    toRemove.add(i);
                } else if (B == 1 && C == 1 && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 2 && C == 0) && (SameDigits(i, guess, numOfDigits) != 2)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 2)))
                    toRemove.add(i);

                else if ((B == 2 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 2) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 2)) {
                    toRemove.add(i);
                } else if ((B == 3 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 3))) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 3) && ((SameDigits(i, guess, numOfDigits) != 0) || HowMuchCorrectCows(i, guess, numOfDigits) < 3)) {
                    toRemove.add(i);
                } else if (((B == 2 && C == 2) || C == 4 || (B == 1 && C == 3)) && !AreAnagrams(i, guess, numOfDigits)) {
                    toRemove.add(i);

                }
            }

            else if (numOfDigits == 5) {
                if ((B + C == 0) && HasCommonNumbers(i, guess, numOfDigits)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 0) && (SameDigits(i, guess, numOfDigits) != 1)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 1))) {
                    toRemove.add(i);
                } else if (B == 1 && C == 1 && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 2 && C == 0) && (SameDigits(i, guess, numOfDigits) != 2)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 2)))
                    toRemove.add(i);

                else if ((B == 2 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 2) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 2)) {
                    toRemove.add(i);
                } else if ((B == 3 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 3))) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 3) && ((SameDigits(i, guess, numOfDigits) != 0) || HowMuchCorrectCows(i, guess, numOfDigits) < 3)) {
                    toRemove.add(i);
                }
                else if ((B == 0 && C == 4) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 4)))
                    toRemove.add(i);

                else if ((B == 4 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 4))) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 3) && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 3)) {
                    toRemove.add(i);
                } else if ((B == 3 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 3) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B ==2 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 2) || HowMuchCorrectCows(i, guess, numOfDigits) < 2)) {
                    toRemove.add(i);
                }
                else if (((B == 3 && C == 2) ||(B == 2 && C == 3) || C == 5 || (B == 1 && C == 4)) && !AreAnagrams(i, guess, numOfDigits)) {
                    toRemove.add(i);

                }
            }
            else if (numOfDigits == 6) {
                if ((B + C == 0) && HasCommonNumbers(i, guess, numOfDigits)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 0) && (SameDigits(i, guess, numOfDigits) != 1)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 1))) {
                    toRemove.add(i);
                } else if (B == 1 && C == 1 && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 2 && C == 0) && (SameDigits(i, guess, numOfDigits) != 2)) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 2)))
                    toRemove.add(i);

                else if ((B == 2 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 2) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 2)) {
                    toRemove.add(i);
                } else if ((B == 3 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 3))) {
                    toRemove.add(i);
                } else if ((B == 0 && C == 3) && ((SameDigits(i, guess, numOfDigits) != 0) || HowMuchCorrectCows(i, guess, numOfDigits) < 3)) {
                    toRemove.add(i);
                }
                else if ((B == 0 && C == 4) && ((SameDigits(i, guess, numOfDigits) != 0) || (HowMuchCorrectCows(i, guess, numOfDigits) < 4)))
                    toRemove.add(i);

                else if ((B == 4 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 4))) {
                    toRemove.add(i);
                } else if ((B == 1 && C == 3) && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 3)) {
                    toRemove.add(i);
                } else if ((B == 3 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 3) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                } else if ((B ==2 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 2) || HowMuchCorrectCows(i, guess, numOfDigits) < 2)) {
                    toRemove.add(i);
                }
                else if ((B ==0 && C == 5) && ((SameDigits(i, guess, numOfDigits) != 0) || HowMuchCorrectCows(i, guess, numOfDigits) < 5)) {
                    toRemove.add(i);
                } else if ((B ==1 && C == 4) && ((SameDigits(i, guess, numOfDigits) != 1) || HowMuchCorrectCows(i, guess, numOfDigits) < 4)) {
                    toRemove.add(i);
                } else if ((B ==2 && C == 3) && ((SameDigits(i, guess, numOfDigits) != 2) || HowMuchCorrectCows(i, guess, numOfDigits) < 3)) {
                    toRemove.add(i);
                } else if ((B ==3 && C == 2) && ((SameDigits(i, guess, numOfDigits) != 3) || HowMuchCorrectCows(i, guess, numOfDigits) < 2)) {
                    toRemove.add(i);
                } else if ((B ==5 && C == 0) && ((SameDigits(i, guess, numOfDigits) != 5))) {
                    toRemove.add(i);
                } else if ((B ==4 && C == 1) && ((SameDigits(i, guess, numOfDigits) != 4) || HowMuchCorrectCows(i, guess, numOfDigits) < 1)) {
                    toRemove.add(i);
                }
                else if (((B == 3 && C == 3) ||(B == 2 && C == 3) || C == 6 || (B == 1 && C == 5)||(B==2&&C==4)||(B==4&&C==2) && !AreAnagrams(i, guess, numOfDigits))) {
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
//        private static int [] countEliminatedOptions( ArrayList<Integer> options, int numOfDigits) {
//
//            int [] outcomes = getOutcome(numOfDigits);
//            int [] results= new int[options.size()];
//            Arrays.fill(results,0);
//            for (int option : options) {
//                int minEliminated = 9999999;
//
//
//                for (int i = 0; i < outcomes.length; i++) {
//                    ArrayList<Integer> temp = new ArrayList<>(options);
//                    ArrayList<Integer> toRemove;
//                    toRemove = NumberRemover(option, numOfDigits, toArray(outcomes[i], 2));
//                    int eliminated = temp.size() - toRemove.size();
//                    if (eliminated < minEliminated) minEliminated = eliminated;
//
//                }
//                results[option]=minEliminated;
//
//
//                }
//
//
//            return results;
//        }
    private static int[] getOutcome(int numOfDigits) {
        if (numOfDigits == 2) {
            return new int[]{20, 10, 01, 00, 02};
        } else if (numOfDigits == 3) {
            return new int[]{30, 20, 00, 01, 02, 03, 10, 12, 11};
        } else if (numOfDigits == 4) {
            return new int[]{40, 30, 20, 21, 22, 00, 01, 02, 03, 04, 10, 20, 12, 13};
        } else if (numOfDigits == 5) {
            return new int[]{00, 01, 02, 03, 04, 05, 10, 11, 12, 13, 14, 20, 21, 22, 23, 30, 31, 32, 40, 50};
        } else if (numOfDigits == 6) {
            return new int[]{00, 01, 02, 03, 04, 05, 10, 11, 12, 13, 14, 20, 21, 22, 23, 30, 31, 32, 40, 50, 41, 42, 33, 24, 15, 06, 60};
        } else {
            return new int[]{0, 1}; // Default or handle other cases as needed
        }
    }

    // Helper function to simulate a guess and get the result


    public static int getRandomFrom(ArrayList<Integer> Nums) {
        if (Nums == null || Nums.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty.");
        }

        int randomInd = (int) (Math.random() * Nums.size());
        int randomNum = Nums.get(randomInd);

        // Ensure that the generated number has distinct digits


        return randomNum;
    }
    public static int getRandomFromWithPriority(ArrayList<Integer> nums, int numOfDigits,int [] priorities) {
        if (nums == null || nums.isEmpty()) {
            return -1;
        }
        double max=Math.pow(10,numOfDigits);




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

    private static int HowMuchCorrectCows(int num1, int num2, int numOfDigits) {
        int count = 0;
        int[] number1 = toArray(num1, numOfDigits);
        int[] number2 = toArray(num2, numOfDigits);
        boolean[] counted = new boolean[numOfDigits];

        for (int i = 0; i < numOfDigits; i++) {
            for (int j = 0; j < numOfDigits; j++) {
                if ((i != j && number1[i] == number2[j]) && !counted[j]) {
                    count++;
                    counted[j] = true;
                    break;
                }
            }
        }

        return count;
    }
    public static boolean AreAnagrams(int num1, int num2, int numOfDigits) {
        int[] digitCount = new int[10];

        // Count occurrences of each digit in num1
        for (int i = 0; i < numOfDigits; i++) {
            digitCount[num1 % 10]++;
            num1 /= 10;
        }

        // Subtract occurrences of each digit in num2
        for (int i = 0; i < numOfDigits; i++) {
            digitCount[num2 % 10]--;
            num2 /= 10;
        }

        // If all counts are zero, the numbers are anagrams
        for (int count : digitCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
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
