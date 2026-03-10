/**
 * UC1:
 *  - Print welcome banner
 *  - Initialize EMPTY train consist using ArrayList
 *  - Show initial bogie count (should be 0)
 *
 * UC2:
 *  - Use ArrayList operations to manage PASSENGER bogies
 *  - Add: "Sleeper", "AC Chair", "First Class"
 *  - Display list after insertion
 *  - Remove one bogie (e.g., "AC Chair")
 *  - Check if "Sleeper" exists using contains()
 *  - Display final list state
 *  @author Shrivatsa Guru
 *  @version 2.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // ===== UC1: Initialize and display summary =====
        System.out.println("=== Train Consist Management App ==="); 
        java.util.List<String> trainConsist = new java.util.ArrayList<>(); 
        System.out.println("Initial bogie count: " + trainConsist.size()); 
        // ===== UC2: ArrayList operations for passenger bogies =====
        // 1) Add passenger bogies: "Sleeper", "AC Chair", "First Class"
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // 2) Display the list after insertion (order is preserved)
        System.out.println("\nAfter adding passenger bogies:");
        System.out.println("Current consist: " + trainConsist);
        System.out.println("Bogie count now: " + trainConsist.size());

        // 3) Remove one bogie (example: "AC Chair")
        boolean removed = trainConsist.remove("AC Chair"); // returns true if it found and removed it
        System.out.println("\nAttempting to remove 'AC Chair'...");
        System.out.println("Removed? " + removed);

        // 4) Check whether "Sleeper" exists
        boolean hasSleeper = trainConsist.contains("Sleeper");
        System.out.println("Does the consist have 'Sleeper'? " + hasSleeper);

        // 5) Display final list state
        System.out.println("\nFinal consist after removal & checks:");
        System.out.println("Current consist: " + trainConsist);
        System.out.println("Final bogie count: " + trainConsist.size());

    }
}
