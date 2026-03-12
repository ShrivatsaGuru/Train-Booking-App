package main;
/**
 * UC16:
 *  - Create an array of passenger bogie capacities.
 *  - Manually sort the array using the Bubble Sort algorithm (no library sort).
 *  - Display the sorted capacities.
 *
 * @author Shrivatsa Guru
 * @version 16.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // 1) Create an array of passenger bogie capacities (example values).
        //    These numbers represent seat counts of different passenger bogies.
        int[] capacities = {72, 56, 24, 60, 90, 30};
        // 2) Bubble Sort 
        for (int pass = 0; pass < capacities.length - 1; pass++) { // Outer loop: number of passes
            for (int i = 0; i < capacities.length - 1 - pass; i++) { // Inner loop: compare adjacent pairs
                if (capacities[i] > capacities[i + 1]) {
                    // Swap capacities[i] and capacities[i + 1]
                    int temp = capacities[i];
                    capacities[i] = capacities[i + 1];
                    capacities[i + 1] = temp;
                }
            }
        }
        // 3) Display the sorted capacities (ascending).
        System.out.print("Sorted capacities (ascending): ");
        for (int i = 0; i < capacities.length; i++) {
            System.out.print(capacities[i]);
            if (i < capacities.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}