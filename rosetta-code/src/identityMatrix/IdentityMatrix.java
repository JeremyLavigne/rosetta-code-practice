package identityMatrix;

/*
    Task
    Build an   identity matrix   of a size known at run-time.


    An identity matrix is a square matrix of size n × n,
    where the diagonal elements are all 1s (ones),
    and all the other elements are all 0s (zeroes).

    1 0 0
    0 1 0
    0 0 1

 */
public class IdentityMatrix {

    public static void solveProblem() {

        System.out.println("Identity Matrix size 3");
        buildMatrix(3);
        System.out.println("\n\nIdentity Matrix size 15");
        buildMatrix(15);
    }

    private static void buildMatrix(int size) {

        if (size < 1) return;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (i == j) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }

            }
            System.out.println("\n");
        }
    }

}
