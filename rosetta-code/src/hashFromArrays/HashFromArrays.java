package hashFromArrays;


import java.util.Arrays;
import java.util.HashMap;

/*
    Task
    Using two Arrays of equal length, create a Hash object where the elements from one array (the keys)
    are linked to the elements of the other (the values)
 */
public class HashFromArrays {

    public static void solveproblem() {

        System.out.println("Let's Build an Hash with those two arrays");

        int[] array1 = {1,2,3,4,5,6,7,8,9,10,11,12};
        String[] array2 = {"My", "name", "is", "Luka", ",", "I", "live", "on", "the", "second", "floor"};

        System.out.println("[1,2,3,4,5,6,7,8,9,10,11,12]");
        System.out.println("[\"My\", \"name\", \"is\", \"Luka\", \",\", \"I\", \"live\", \"on\", \"the\", \"second\", \"floor\"]");

        System.out.println("\nHere is the hash object :");
        buildHashFromArrays(array1, array2);
    }

    private static void buildHashFromArrays(int[] array1, String[] array2) {

        HashMap hash = new HashMap();

        for (int i = 0; i < array1.length; i++) {

            if (array2.length > i) {
                hash.put(array1[i], array2[i]);
            }

        }
        System.out.println(hash);
    }
}
