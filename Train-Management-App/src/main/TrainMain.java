package main;
/**
 * UC3:
 *  - We need UNIQUE bogie IDs (no duplicates allowed).
 *  - Use a Set (HashSet implementation) to auto-remove duplicates.
 *  - Add IDs with intentional duplicates and print the final unique set.
 *  @author Shrivatsa Guru
 *  @version 3.0
 */
public class TrainMain {

    public static void main(String[] args) {

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