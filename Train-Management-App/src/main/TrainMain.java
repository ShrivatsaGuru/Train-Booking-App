package main;
/**
 * UC10:
 *  - Compute TOTAL seating capacity using Stream:
 *      stream() -> map(b -> b.capacity) -> reduce(0, Integer::sum)
 *  - Print the total seats across passenger bogie
 *  
 *@author Shrivatsa Guru
 *@version 10.0
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
		java.util.List<Bogie> passengerBogies = new java.util.ArrayList<>();
		passengerBogies.add(new Bogie("Sleeper", 72));
		passengerBogies.add(new Bogie("AC Chair", 56));
		passengerBogies.add(new Bogie("First Class", 24));
		// ===== UC10: TOTAL seating capacity using map(...) + reduce(...) =====
		// Steps:
		// 1) We already have a List<Bogie> named 'passengerBogies' from UC7.
		// 2) Convert it into a stream.
		// 3) map(...) to extract integer capacities.
		// 4) reduce(0, Integer::sum) to add them all up into a single total.
		int totalSeatingCapacity = passengerBogies
				.stream()                       
				.map(b -> b.capacity)          
				.reduce(0, Integer::sum);      

		// 5) Print the total seating capacity
		System.out.println("UC10: Total seating capacity across passenger bogies:");
		System.out.println(totalSeatingCapacity + " seats total");




	}
}