package twentyFourGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
    Same problem, second try:
    Build expressions as String and test them

    Do not consider right now cases with parenthesis

    Auto-feedback : Turn int into String into char into int ... Maybe we can optimize ...

 */

public class TwentyFourGame2 {

    public static void solveProblem() {

        ArrayList<String> digits = generateDigitsRandomly();

        String answer = findExpression(digits);

        System.out.println("With those digits : (" + digits.get(0) + ", " + digits.get(1) + ", " + digits.get(2) + ", " + digits.get(3) + ") : "
                + (answer.equals("") ? "there is no solution" : ("one solution is " + answer)));

    }

    /*
        Main method, follow a specific order to find and return expression, or "" if none possible
     */
    private static String findExpression(ArrayList<String> digits) {
        // Will contain answer to return
        String answer = "";

        // Get all (24) permutations of the 4 digits
        ArrayList<ArrayList<String>> digitsPermutations = permute(digits);

        // Define all (14) permutations of the 4 operators (only available 3 positions)
        ArrayList<ArrayList<String>> operators = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("+", "+", "+")),
                new ArrayList<>(Arrays.asList("+", "+", "-")),
                new ArrayList<>(Arrays.asList("+", "+", "*")),
                new ArrayList<>(Arrays.asList("+", "+", "/")),
                new ArrayList<>(Arrays.asList("+", "-", "/")),
                new ArrayList<>(Arrays.asList("+", "-", "*")),
                new ArrayList<>(Arrays.asList("+", "*", "*")),
                new ArrayList<>(Arrays.asList("+", "*", "/")),
                new ArrayList<>(Arrays.asList("-", "-", "*")),
                new ArrayList<>(Arrays.asList("-", "*", "*")),
                new ArrayList<>(Arrays.asList("-", "*", "/")),
                new ArrayList<>(Arrays.asList("*", "*", "*")),
                new ArrayList<>(Arrays.asList("*", "*", "/")),
                new ArrayList<>(Arrays.asList("*", "/", "/"))
                ));

        // Associate digits (d) and operators (o) into a string "dododod" -> (24*14 = 336) possible expressions
        ArrayList<String> allExpressionsToTest = generateExpressions(digitsPermutations,operators);

        // Now, for each expression, test if result = 24
        for (int i=0 ; i< allExpressionsToTest.size(); i ++) {
            if (!(testExpression(allExpressionsToTest.get(i)).equals(""))) {
                return testExpression(allExpressionsToTest.get(i));
            }
        }

        return answer;
    }


    /*
        Given a String which represent a mathematic expression, transform it and compare result to 24
        return "" if false. return the String if true.
     */
    private static String testExpression(String expression) {
        String answer = "";
        char[] split = expression.toCharArray();

        // Find operator with if else -> many cases..
        int result = 0;

        if (split[1] == '+' && split[3] == '+' && split[5] == '+' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) + Character.getNumericValue(split[4]) + Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '+' && split[5] == '-' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) + Character.getNumericValue(split[4]) - Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '+' && split[5] == '*' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) + Character.getNumericValue(split[4]) * Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '+' && split[5] == '/' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) + Character.getNumericValue(split[4]) / Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '-' && split[5] == '/' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) - Character.getNumericValue(split[4]) / Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '-' && split[5] == '*' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) - Character.getNumericValue(split[4]) * Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '*' && split[5] == '*' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) * Character.getNumericValue(split[4]) * Character.getNumericValue(split[6]);}
        else if (split[1] == '+' && split[3] == '*' && split[5] == '/' ) { result = Character.getNumericValue(split[0]) + Character.getNumericValue(split[2]) * Character.getNumericValue(split[4]) / Character.getNumericValue(split[6]);}
        else if (split[1] == '-' && split[3] == '-' && split[5] == '*' ) { result = Character.getNumericValue(split[0]) - Character.getNumericValue(split[2]) - Character.getNumericValue(split[4]) * Character.getNumericValue(split[6]);}
        else if (split[1] == '-' && split[3] == '*' && split[5] == '*' ) { result = Character.getNumericValue(split[0]) - Character.getNumericValue(split[2]) * Character.getNumericValue(split[4]) * Character.getNumericValue(split[6]);}
        else if (split[1] == '-' && split[3] == '*' && split[5] == '/' ) { result = Character.getNumericValue(split[0]) - Character.getNumericValue(split[2]) * Character.getNumericValue(split[4]) / Character.getNumericValue(split[6]);}
        else if (split[1] == '*' && split[3] == '*' && split[5] == '*' ) { result = Character.getNumericValue(split[0]) * Character.getNumericValue(split[2]) * Character.getNumericValue(split[4]) * Character.getNumericValue(split[6]);}
        else if (split[1] == '*' && split[3] == '*' && split[5] == '/' ) { result = Character.getNumericValue(split[0]) * Character.getNumericValue(split[2]) * Character.getNumericValue(split[4]) / Character.getNumericValue(split[6]);}
        else if (split[1] == '*' && split[3] == '/' && split[5] == '/' ) { result = Character.getNumericValue(split[0]) * Character.getNumericValue(split[2]) / Character.getNumericValue(split[4]) / Character.getNumericValue(split[6]);}

        if (result == 24) {return expression;}
        return answer;
    }


    /*
        Given 4 digits and 3 operators, build expressions as a unique String.
        Example : [3,4,7,5], [*,+,+] -> "3*4+7+5"
        Do it for all 336 cases possible and return the list
     */
    private static ArrayList<String> generateExpressions(ArrayList<ArrayList<String>> digitsPermutations, ArrayList<ArrayList<String>> operators) {
        ArrayList<String> expressions = new ArrayList<>();

        for (int i = 0; i < digitsPermutations.size(); i ++ ) {

            for (int j = 0; j < operators.size(); j ++ ) {

                expressions.add(digitsPermutations.get(i).get(0) +  //  3
                                operators.get(j).get(0) +           //  *
                                digitsPermutations.get(i).get(1) +  //  5
                                operators.get(j).get(1) +           //  +
                                digitsPermutations.get(i).get(2) +  //  2
                                operators.get(j).get(2) +           //  /
                                digitsPermutations.get(i).get(3)    //  8
                );                                                  //  for example

            }

        }

        return expressions;
    }


    // -------------------------------------------------------------------------------------------------------------
    /*
        Permutation Helper -> 24 ways to order 4 digits
        Source : https://java2blog.com/permutations-array-java/
     */
    public static ArrayList<ArrayList<String>> permute(ArrayList<String> digits) {

        String[] arr = new String[4];
        arr[0] = digits.get(0); arr[1] = digits.get(1); arr[2] = digits.get(2); arr[3] = digits.get(3);

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);

        return list;
    }
    private static void permuteHelper(ArrayList<ArrayList<String>> list, ArrayList<String> resultList, String[] arr){
        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<String>(resultList));
        }
        else{
            for(int i = 0; i < arr.length; i++){

                if(resultList.contains(arr[i]))
                {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    /*
        Generate 4 random digits and store them inside a ArrayList
     */
    private static ArrayList<String> generateDigitsRandomly() {
        ArrayList<String> digits = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            digits.add(String.valueOf(new Random().nextInt(9) + 1));
        }

        return digits;
    }


}
