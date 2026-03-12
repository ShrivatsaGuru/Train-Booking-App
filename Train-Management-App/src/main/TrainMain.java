package main;
/**
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
