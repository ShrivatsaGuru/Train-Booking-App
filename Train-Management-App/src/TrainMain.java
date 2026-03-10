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
 *  - Enforce UNIQUE bogie IDs using HashSet<String>.
 *  - Add duplicate IDs intentionally; HashSet removes duplicates automatically.
 *  - Print unique IDs (order is not guaranteed).
 *
 * UC4:
 *  - Use LinkedList<String> to model a physical sequence.
 *  - Add: Engine, Sleeper, AC, Cargo, Guard.
 *  - Insert "Pantry Car" at index 2.
 *  - Remove first and last bogie.
 *  - Display final ordered consist.
 *
 * UC5 (this step):
 *  - Use LinkedHashSet<String> to preserve insertion order + uniqueness.
 *  - Add: Engine, Sleeper, Cargo, Guard.
 *  - Try to add "Sleeper" again (duplicate ignored automatically).
 *  - Print the final formation in the same order as inserted, with no duplicates.
 *  @author Shrivatsa Guru
 *  @version 5.0
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
        uniqueBogieIds.add("BG101");
        uniqueBogieIds.add("BG102");
        uniqueBogieIds.add("BG103");
        uniqueBogieIds.add("BG101"); // duplicate (ignored)
        uniqueBogieIds.add("BG102"); // duplicate (ignored)

        System.out.println("\nUC3: Unique bogie IDs (HashSet):");
        System.out.println("All IDs (duplicates auto-removed): " + uniqueBogieIds);

        // ===== UC4: Maintain ORDERED train consist using LinkedList =====
        java.util.LinkedList<String> orderedConsist = new java.util.LinkedList<>();
        orderedConsist.addLast("Engine");
        orderedConsist.addLast("Sleeper");
        orderedConsist.addLast("AC");
        orderedConsist.addLast("Cargo");
        orderedConsist.addLast("Guard");

        System.out.println("\nUC4: Ordered consist after initial additions:");
        System.out.println(orderedConsist);

        orderedConsist.add(2, "Pantry Car"); // insert at index 2
        System.out.println("\nAfter inserting 'Pantry Car' at index 2:");
        System.out.println(orderedConsist);

        String removedFirst = orderedConsist.removeFirst();
        String removedLast  = orderedConsist.removeLast();
        System.out.println("\nRemoved first bogie: " + removedFirst);
        System.out.println("Removed last bogie : " + removedLast);

        System.out.println("\nFinal ordered train consist (LinkedList):");
        System.out.println(orderedConsist);

        // ===== UC5: PRESERVE insertion order + ENFORCE uniqueness using LinkedHashSet =====
        java.util.Set<String> formation = new java.util.LinkedHashSet<>();

        // 1) Attach bogies in order
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // 2) Try to attach a duplicate bogie ("Sleeper") — will be ignored automatically
        formation.add("Sleeper"); 

        // 3) Display the final formation
        System.out.println("\nUC5: Final formation using LinkedHashSet (order preserved + no duplicates):");
        System.out.println(formation); 

    }
}
