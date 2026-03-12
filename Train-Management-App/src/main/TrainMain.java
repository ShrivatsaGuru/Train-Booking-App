package main;
/**
 * UC6 :
 *  - Map each bogie to its capacity using HashMap<String, Integer>.
 *  - Insert entries with put(), then iterate using entrySet() to print "bogie = capacity".
 *  - Demonstrates key–value association and fast lookup by key.
 *  
 *  @author Shrivatsa Guru
 *  @version 6.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // ===== UC6: Map Bogie -> Capacity using HashMap =====
        java.util.Map<String, Integer> bogieCapacity = new java.util.HashMap<>();

        // 1) Insert (key, value) pairs using put().
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);

        // 2) Iterate using entrySet(): gives us Map.Entry<String, Integer> for each pair.
        System.out.println("\nUC6: <Bogie:Capacity> using HashMap:");
        for (java.util.Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            String bogieName = entry.getKey();
            Integer capacity = entry.getValue();
            System.out.println(bogieName + " : " + capacity + " seats");
        }
    }
}