package main;
/**
 * UC13:
 *  - Compare LOOP vs STREAM filtering performance using System.nanoTime().
 *  - Steps:
 *      1) Prepare a large-ish list of passenger bogies (name + capacity).
 *      2) Measure time for loop-based filtering (capacity > 60).
 *      3) Measure time for stream-based filtering (same condition).
 *      4) Print sizes of results and durations.
 *      
 *@author Shrivatsa Guru
 *@version 13.0
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
	static class GoodsBogie {
		String shape; // e.g., "Rectangular" or "Cylindrical"
		String cargo; // e.g., "Coal", "Petroleum"

		GoodsBogie(String shape, String cargo) {
			this.shape = shape;
			this.cargo = cargo;
		}

		@Override
		public String toString() {
			return shape + " carrying " + cargo;
		}
	}
	public static void main(String[] args) {
		// ===== UC13: Performance Comparison (Loops vs Streams) =====
		// 1) Prepare a larger list so timing differences are visible.
		int N = 100_000; // number of passenger bogies to generate
		java.util.List<Bogie> bigPassengerBogies = new java.util.ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			// Capacity cycles from 1..100 so we have some > 60 and some <= 60
			int capacity = (i % 100) + 1;
			bigPassengerBogies.add(new Bogie("PB-" + i, capacity));
		}
		// 2) LOOP-BASED filtering: capacity > 60
		long loopStart = System.nanoTime();
		java.util.List<Bogie> loopFiltered = new java.util.ArrayList<>();
		for (Bogie b : bigPassengerBogies) {
			if (b.capacity > 60) {
				loopFiltered.add(b);
			}
		}
		long loopEnd = System.nanoTime();
		long loopElapsedNanos = loopEnd - loopStart;

		// 3) STREAM-BASED filtering: capacity > 60
		long streamStart = System.nanoTime();
		java.util.List<Bogie> streamFiltered = bigPassengerBogies
				.stream()
				.filter(b -> b.capacity > 60)
				.collect(java.util.stream.Collectors.toList());
		long streamEnd = System.nanoTime();
		long streamElapsedNanos = streamEnd - streamStart;

		// 4) Print results and durations (convert nanos to millis for readability)
		System.out.println("\nUC13: Performance Comparison (Loop vs Stream)");
		System.out.println("Total bogies: " + bigPassengerBogies.size());
		System.out.println("Loop-based filtered count   : " + loopFiltered.size());
		System.out.println("Stream-based filtered count : " + streamFiltered.size());
		System.out.println("Loop time   : " + loopElapsedNanos + " ns (" + (loopElapsedNanos / 1_000_000.0) + " ms)");
		System.out.println("Stream time : " + streamElapsedNanos + " ns (" + (streamElapsedNanos / 1_000_000.0) + " ms)");


	}
}