package main;

/**
 * UC8:
 *  - Use Java Streams to FILTER passenger bogies.
 *  - Condition: capacity > 60.
 *  - Collect the filtered bogies into a new List and print them.
 *@author Shrivatsa Guru
 *@version 8.0
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
		java.util.List<Bogie> passengerBogies = new java.util.ArrayList<>();
		passengerBogies.add(new Bogie("Sleeper", 72));
		passengerBogies.add(new Bogie("AC Chair", 56));
		passengerBogies.add(new Bogie("First Class", 24));
		// ===== UC8: FILTER passenger bogies using Streams (capacity > 60) =====
		// Steps:
		// 1) Convert the existing list (passengerBogies) into a stream.
		// 2) Apply filter(...) with the condition: capacity > 60.
		// 3) Collect the result back into a new List using Collectors.toList().
		java.util.List<Bogie> highCapacityBogies = passengerBogies
				.stream()                               // make a stream from the list
				.filter(b -> b.capacity > 60)           // keep only bogies with capacity > 60
				.collect(java.util.stream.Collectors.toList()); // turn the stream back into a List

		// 4) Display the filtered bogies:
		System.out.println("\nUC8: Filtered passenger bogies (capacity > 60):");
		if (highCapacityBogies.isEmpty()) {
			System.out.println("No bogies match the filter.");
		} else {
			for (Bogie b : highCapacityBogies) {
				System.out.println(b.name + " - " + b.capacity + " seats");
			}
		}


	}
}