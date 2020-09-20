package pascalTriangle;

import java.util.ArrayList;

/*
    Pascal's triangle
    Pascal's triangle is an arithmetic and geometric figure often associated with the name of Blaise Pascal, but also studied centuries earlier in India, Persia, China and elsewhere.

    Its first few rows look like this:

        1
       1 1
      1 2 1
     1 3 3 1
    where each element of each row is either 1 or the sum of the two elements right above it.

    For example, the next row of the triangle would be:

      1   (since the first element of each row doesn't have two elements above it)
      4   (1 + 3)
      6   (3 + 3)
      4   (3 + 1)
      1   (since the last element of each row doesn't have two elements above it)
    So the triangle now looks like this:

        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1
    Each row   n   (starting with row   0   at the top) shows the coefficients of the binomial expansion of   (x + y)n.



    Task
    Write a function that prints out the first   n   rows of the triangle.

 */
public class PascalTriangle {

    public static void solveProblem() {

        System.out.println("n = 5\n");
        printRows(5);

        System.out.println("\n---------------------------------------");
        System.out.println("n = 12\n");
        printRows(12);

    }

    private static void printRows(int numberOfRows) {

        if (numberOfRows < 0){ numberOfRows = 0;}
        if (numberOfRows > 20){ numberOfRows = 20;}

        for (int i = 0 ; i < numberOfRows; i++){
            System.out.println(pascalPyRow(i));
        }

    }

    private static ArrayList<Integer> pascalPyRow(int rowNumber) {
        ArrayList<Integer> row = new ArrayList<>();

        for (int i = 0; i < rowNumber + 1; i++) {
            row.add(pascalPyNumber(rowNumber, i)); // Pascal Number is calculate regarding its position, see below
        }

        return row;
    }

    /*
        Consider pascal's triangle in an easier display (as a table) when building it:

            1                   1
           1 1                  1 1
          1 2 1         =>      1 2 1
         1 3 3 1                1 3 3 1
        1 4 6 4 1               1 4 6 4 1

         - Same number of rows / columns
         - First column always = 1
         - Last number of each row always = 1
         - others = top left number + top number
     */
    private static int pascalPyNumber(int rowNumber, int columnNumber) {

        if (columnNumber == 0 || columnNumber == rowNumber) {return 1;}
        return pascalPyNumber(rowNumber-1, columnNumber -1) +
                pascalPyNumber(rowNumber-1, columnNumber);

    }



    /*
    // First try, issue with rowNumber > 10-15
    private static ArrayList<Integer> pascalPyRow2(int rowNumber) {

        ArrayList<Integer> row = new ArrayList<>();

        row.add(1); // All lines start with 1

        for (int i = 1 ; i <= rowNumber-1; i++) {

            // Add the sum of the 2 number above (from previous row)
            row.add(pascalPyRow2(rowNumber-1).get(i-1)+
                    pascalPyRow2(rowNumber-1).get(i));

        }

        if (rowNumber > 0 ){row.add(1);} // All lines (except first) end with 1

        return row;
    }
    */

}
