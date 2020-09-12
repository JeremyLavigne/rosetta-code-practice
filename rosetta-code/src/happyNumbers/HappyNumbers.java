package happyNumbers;

import java.util.ArrayList;

/*
    From Wikipedia, the free encyclopedia:

    A happy number is defined by the following process:
    Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals   1   (where it will stay),   or it loops endlessly in a cycle which does not include   1.


    Those numbers for which this process end in 1 are happy numbers,
    while those numbers that do not end in 1 are unhappy numbers.


    Task
    Find and print the first 8 happy numbers.

 */
public class HappyNumbers {

    public static void solveProblem() {

        ArrayList<Integer> happyNumbers = new ArrayList<>();
        int testNumber = 1;

        while (happyNumbers.size() < 8) {

            if (isHappyNumber(testNumber)){
                happyNumbers.add(testNumber);
            }
            testNumber ++;

            // Prevent too long loop
            if (testNumber > 50){
                break;
            }
        }

        System.out.println("The first 8 happy numbers are : " + happyNumbers);
    }

    /*
        Test if it is a happy number, return true or false
     */
    private static boolean isHappyNumber(int testNumber) {

        ArrayList<Integer> resultsHistory = new ArrayList<>();
        int squareSum = 0;

        while (squareSum != 1){
            // Separate into digits
            ArrayList<Integer> digits = separateDigits(testNumber);

            // Find sum of square of each digits
            squareSum = digits.stream()
                    .map(number -> number * number)
                    .reduce(0, (sum, previous) -> sum += previous);

            // Prevent infinite loop
            // If sum is already met, it will be doing always the same cycle
            if (resultsHistory.contains(squareSum)){ return false;}

            resultsHistory.add(squareSum);
            testNumber = squareSum;
        }

        return true;
    }

    /*
        Transform an Integer into a list of Integer, i.e. its digits
     */
    private static ArrayList<Integer> separateDigits(int number) {
        ArrayList<Integer> digits = new ArrayList<>();

        while (number > 0){
            int rest = number % 10;
            number = (number - rest) / 10;
            digits.add(rest);
        }

        return digits;
    }
}
