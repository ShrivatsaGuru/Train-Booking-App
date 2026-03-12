package main;
/**
 * UC4 (this step):
 *  - Use LinkedList<String> to maintain a PHYSICAL sequence of bogies.
 *  - Add: Engine, Sleeper, AC, Cargo, Guard.
 *  - Insert "Pantry Car" at index 2 (0-based).
 *  - Remove first and last bogie.
 *  - Display the final ordered consist.
 *
 *@author Shrivatsa Guru
 *@version 4.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // ===== UC4: Maintain ORDERED train consist using LinkedList =====
        java.util.LinkedList<String> orderedConsist = new java.util.LinkedList<>();

        // 1) Add bogies in sequence. We can use addLast() (same as add at end).
        orderedConsist.addLast("Engine"); 
        orderedConsist.addLast("Sleeper");
        orderedConsist.addLast("AC");
        orderedConsist.addLast("Cargo");
        orderedConsist.addLast("Guard");   

        System.out.println("\nUC4: Ordered consist after initial additions:");
        System.out.println(orderedConsist);

        // 2) Insert "Pantry Car" at position 2 (0-based: 0-Engine, 1-Sleeper, 2-AC)
     
        orderedConsist.add(2, "Pantry Car");
        System.out.println("\nAfter inserting 'Pantry Car' at index 2:");
        System.out.println(orderedConsist);

        // 3) Remove the first and last bogie to simulate detach operations.
        String removedFirst = orderedConsist.removeFirst(); 
        String removedLast  = orderedConsist.removeLast();  

        System.out.println("\nRemoved first bogie: " + removedFirst);
        System.out.println("Removed last bogie : " + removedLast);

        // 4) Display the final ordered consist
        System.out.println("\nFinal ordered train consist: ");
        System.out.println(orderedConsist);

    }
}