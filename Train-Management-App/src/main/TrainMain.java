package main;
/**
 *UC17:
 *  - Create an array of bogie type names.
 *  - Sort the array ALPHABETICALLY using Java's built-in Arrays.sort().
 *  - Display the sorted result.
 *@author Shrivatsa Guru
 *@version 17.0
 */
import java.util.Arrays;

public class TrainMain {

    public static void main(String[] args) {
        // 1) Create an array of bogie type names (unsorted).
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "Cargo",
                "Guard",
                "Engine"
        };
        System.out.println("Before Sorting: ");
        System.out.println(Arrays.toString(bogieNames));
        // 2) Sort the array alphabetically using Arrays.sort().
        //    This uses Java's built-in optimized sorting algorithm.
        Arrays.sort(bogieNames);

        // 3) Display the sorted array.
        //    Arrays.toString() converts the array into a readable String.
        System.out.println("Sorted bogie names:");
        System.out.println(Arrays.toString(bogieNames));
    }
}