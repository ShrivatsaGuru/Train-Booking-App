package main;

/**
 * UC9:
 *  - Group bogies by TYPE using Collectors.groupingBy(...)
 *  - Output: Map<String, List<Bogie>> where key = type, value = bogies of that type
 *  
 *@author Shrivatsa Guru
 *@version 9.0
 */
public class TrainMain {


	 static class Bogie {
	        String name;
	        int capacity;
	        String type; // NEW for UC9 (e.g., "Passenger" or "Goods")

	        // Old constructor kept for backward compatibility (UC7/UC8):
	        Bogie(String name, int capacity) {
	            this.name = name;
	            this.capacity = capacity;
	            this.type = null; // type is unknown in older UCs
	        }

	        // New constructor with type (for UC9 grouping):
	        Bogie(String name, int capacity, String type) {
	            this.name = name;
	            this.capacity = capacity;
	            this.type = type;
	        }

	        String getName()     { return name; }
	        int    getCapacity() { return capacity; }
	        String getType()     { return type; }

	        @Override
	        public String toString() {
	            // Show name and capacity; type is evident from the group header
	            return name + " (" + capacity + " seats)";
	        }
	    }

	public static void main(String[] args) {
		// ===== UC9: GROUP bogies by TYPE using Collectors.groupingBy(...) =====
		// We'll create a mixed list with both Passenger and Goods bogies.
		java.util.List<Bogie> bogiesForGrouping = new java.util.ArrayList<>();
		bogiesForGrouping.add(new Bogie("Sleeper", 72, "Passenger"));
		bogiesForGrouping.add(new Bogie("AC Chair", 56, "Passenger"));
		bogiesForGrouping.add(new Bogie("First Class", 24, "Passenger"));
		bogiesForGrouping.add(new Bogie("Rectangular", 2, "Goods")); 
		bogiesForGrouping.add(new Bogie("Cylindrical", 5, "Goods"));

		java.util.Map<String, java.util.List<Bogie>> groupedByType =
				bogiesForGrouping
				.stream()
				.collect(java.util.stream.Collectors.groupingBy(b -> b.type));

		// Display the grouped structure in a readable way
		System.out.println("\nUC9: Grouped bogies by TYPE (Map<String, List<Bogie>>):");
		for (java.util.Map.Entry<String, java.util.List<Bogie>> entry : groupedByType.entrySet()) {
			String typeKey = entry.getKey();
			java.util.List<Bogie> list = entry.getValue();
			System.out.println("> " + typeKey + ":");
			for (Bogie b : list) {
				System.out.println("   - " + b);
			}
		}
	}
}