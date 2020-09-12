package fibonacciSequence;

import java.sql.SQLOutput;

/*
    The Fibonacci sequence is a sequence   Fn   of natural numbers defined recursively:

      F0 = 0
      F1 = 1
      Fn = Fn-1 + Fn-2, if n>1


    Task
    Write a function to generate the   nth   Fibonacci number.

    Solutions can be iterative or recursive (though recursive solutions are generally considered too slow and are mostly used as an exercise in recursion).

 */
public class FibonacciSequence {

    public static void solveProblem() {

        System.out.println(generateFibonaciNumber(3));
        System.out.println(generateFibonaciNumber(8));
        System.out.println(generateFibonaciNumber(17));

        //System.out.println(recursiveFibonaciNumber(3));
        //System.out.println(recursiveFibonaciNumber(8));
        //System.out.println(recursiveFibonaciNumber(17));

    }

    /*
        Recursive Way
     */
    private static int recursiveFibonaciNumber(int i) {

        if (i == 0){ return 0;}
        if (i == 1){ return 1;}

        return recursiveFibonaciNumber(i-1) + recursiveFibonaciNumber(i-2);
    }

    /*
        Iterative Way
     */
    private static int generateFibonaciNumber(int number) {

        if (number == 0){ return 0;}
        if (number == 1){ return 1;}

        int fibonaciTwoBefore = 0;
        int fibonaciOneBefore = 1;
        int fibonaciNumber = 1;

        for (int i = 2; i <= number; i ++) {
            fibonaciNumber = fibonaciTwoBefore + fibonaciOneBefore;
            fibonaciTwoBefore = fibonaciOneBefore;
            fibonaciOneBefore = fibonaciNumber;
        }

        return fibonaciNumber;
    }

}
