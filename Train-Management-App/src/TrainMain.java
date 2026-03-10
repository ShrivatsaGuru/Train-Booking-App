/**
 * UC1:
 *  - Print welcome banner.
 *  - Initialize EMPTY train consist using ArrayList.
 *  - Show initial bogie count (0).
 *
 * UC2:
 *  - Add passenger bogies: "Sleeper", "AC Chair", "First Class".
 *  - Show list after insertion.
 *  - Remove "AC Chair".
 *  - Check contains("Sleeper").
 *  - Show final list state.
 *
 * UC3:
 *  - We need UNIQUE bogie IDs (no duplicates allowed).
 *  - Use a Set (HashSet implementation) to auto-remove duplicates.
 *  - Add IDs with intentional duplicates and print the final unique set.
 *  @author Shrivatsa Guru
 *  @version 3.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // ===== UC1: Initialize and display summary =====
        System.out.println("=== Train Consist Management App ==="); 
        java.util.List<String> trainConsist = new java.util.ArrayList<>(); 
        System.out.println("Initial bogie count: " + trainConsist.size()); 

        // ===== UC2: ArrayList operations for passenger bogies =====
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter adding passenger bogies:");
        System.out.println("Current consist: " + trainConsist);
        System.out.println("Bogie count now: " + trainConsist.size());

        boolean removed = trainConsist.remove("AC Chair");
        System.out.println("\nAttempting to remove 'AC Chair'...");
        System.out.println("Removed? " + removed);

        boolean hasSleeper = trainConsist.contains("Sleeper");
        System.out.println("Does the consist have 'Sleeper'? " + hasSleeper);

        System.out.println("\nFinal consist after removal & checks:");
        System.out.println("Current consist: " + trainConsist);
        System.out.println("Final bogie count: " + trainConsist.size());

        // ===== UC3: Track UNIQUE bogie IDs using HashSet =====

        java.util.Set<String> uniqueBogieIds = new java.util.HashSet<>();

        // 1) Add IDs, including duplicates on purpose
        uniqueBogieIds.add("BG101");
        uniqueBogieIds.add("BG102");
        uniqueBogieIds.add("BG103");
        uniqueBogieIds.add("BG101"); 
        uniqueBogieIds.add("BG102"); 

        // 2) Display the final set of UNIQUE IDs
        System.out.println("\nUC3: Unique bogie IDs (HashSet):");
        System.out.println("All IDs (duplicates auto-removed): " + uniqueBogieIds);

    }
}
