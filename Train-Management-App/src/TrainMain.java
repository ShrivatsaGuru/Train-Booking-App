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
 * UC5:
 *  - Use LinkedHashSet<String> to preserve insertion order + uniqueness.
 *  - Add: Engine, Sleeper, Cargo, Guard.
 *  - Try to add "Sleeper" again (duplicate ignored).
 *  - Print the final formation (in insertion order, no duplicates).
 *
 * UC6 :
 *  - Map each bogie to its capacity using HashMap<String, Integer>.
 *  - Insert entries with put(), then iterate using entrySet() to print "bogie = capacity".
 *  - Demonstrates key–value association and fast lookup by key.

 * UC7:
 *  - Create a simple Bogie class (name + capacity).
 *  - Store passenger bogies in a List<Bogie>.
 *  - Sort them by capacity using Comparator.comparingInt(...).
 *  - Print BEFORE and AFTER sorting for clarity.
 *@author Shrivatsa Guru
 *@version 7.0
 */
public class TrainMain {

    static class Bogie {
        // Fields (data we store for each bogie)
        String name;
        int capacity; // number of seats

        // Constructor: runs when we write "new Bogie(name, capacity)"
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        // Getters (handy if we want method references later)
        String getName()     { return name; }
        int    getCapacity() { return capacity; }

        // toString() helps print a bogie nicely
        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        // ===== UC1: Initialize and display summary =====
        System.out.println("=== Train Consist Management App ==="); // welcome message
        java.util.List<String> trainConsist = new java.util.ArrayList<>(); // dynamic list for bogies
        System.out.println("Initial bogie count: " + trainConsist.size()); // should be 0

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
        // Note: HashSet is unordered, so printed order may look random.

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
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate ignored

        System.out.println("\nUC5: Final formation using LinkedHashSet (order preserved, no duplicates):");
        System.out.println(formation);

        int pos = 0;
        for (String bogie : formation) {
            System.out.println(++pos + ". " + bogie);
        }

        // ===== UC6: Map Bogie -> Capacity using HashMap =====
        java.util.Map<String, Integer> bogieCapacity = new java.util.HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);

        System.out.println("\nUC6: Bogie -> Capacity (using HashMap and entrySet):");
        for (java.util.Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " seats");
        }
        System.out.println("Quick lookup - Sleeper capacity: " + bogieCapacity.get("Sleeper") + " seats");

        // ===== UC7: Sort passenger bogies by capacity (Comparator) =====
        // 1) Create a list of Bogie objects (with name and capacity).
        java.util.List<Bogie> passengerBogies = new java.util.ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        // 2) Sort by capacity (ascending) using Comparator.comparingInt(...)
        passengerBogies.sort(java.util.Comparator.comparingInt(b -> b.capacity));

        // 3) Show the list AFTER sorting.
        System.out.println("\nUC7: Passenger bogies AFTER sorting by capacity (ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b.name + " - " + b.capacity + " seats");
        }

    }
}