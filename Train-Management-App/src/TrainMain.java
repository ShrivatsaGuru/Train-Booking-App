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
 * 
 * UC8:
 *  - Use Java Streams to FILTER passenger bogies.
 *  - Condition: capacity > 60.
 *  - Collect the filtered bogies into a new List and print them.
 *  
 * UC9:
 *  - Group bogies by TYPE using Collectors.groupingBy(...)
 *  - Output: Map<String, List<Bogie>> where key = type, value = bogies of that type
 *  
 *  
 * UC10:
 *  - Compute TOTAL seating capacity using Stream:
 *      stream() -> map(b -> b.capacity) -> reduce(0, Integer::sum)
 *  - Print the total seats across passenger bogie
 *  
 * UC11 :
 *  - Validate Train ID and Cargo Code formats using REGEX with Pattern + Matcher.
 *  - Train ID example pattern: TRN-\\d{4}
 *  - Cargo Code example pattern: PET-[A-Z]{2}
 *  - Use matches() to ensure the ENTIRE input matches the required format.
 *  
 * UC12:
 *  - Prepare a list of GOODS bogies (shape + cargo).
 *  - Use Streams + allMatch(...) to enforce a simple safety rule:
 *      If shape == "Cylindrical" -> cargo must be "Petroleum".
 *  - Print whether the goods consist is safety-compliant.
 *  
 * UC13:
 *  - Compare LOOP vs STREAM filtering performance using System.nanoTime().
 *  - Steps:
 *      1) Prepare a large-ish list of passenger bogies (name + capacity).
 *      2) Measure time for loop-based filtering (capacity > 60).
 *      3) Measure time for stream-based filtering (same condition).
 *      4) Print sizes of results and durations.
 * 
 * UC14:
 *  - Create a custom CHECKED exception: InvalidCapacityException (extends Exception).
 *  - Create PassengerBogie with validation in its constructor.
 *  - If capacity <= 0, throw InvalidCapacityException.
 *  - Demonstrate safe object creation with try/catch so invalid bogies are never added

 *@author Shrivatsa Guru
 *@version 14.0
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



	static class PassengerBogie {
		String name;
		int capacity;

		PassengerBogie(String name, int capacity) throws InvalidCapacityException {
			// Validate as soon as we construct the object.
			if (capacity <= 0) {
				throw new InvalidCapacityException(
						"Capacity must be > 0 for passenger bogie '" + name + "'. Provided: " + capacity);
			}
			this.name = name;
			this.capacity = capacity;
		}

		@Override
		public String toString() {
			return name + " (" + capacity + " seats) [validated]";
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

		// ===== UC8: FILTER passenger bogies using Streams (capacity > 60) =====
		// Steps:
		// 1) Convert the existing list (passengerBogies) into a stream.
		// 2) Apply filter(...) with the condition: capacity > 60.
		// 3) Collect the result back into a new List using Collectors.toList().
		java.util.List<Bogie> highCapacityBogies = passengerBogies
				.stream()
				.filter(b -> b.capacity > 60)          
				.collect(java.util.stream.Collectors.toList()); 

		// 4) Display the filtered bogies:
		System.out.println("\nUC8: Filtered passenger bogies (capacity > 60):");
		if (highCapacityBogies.isEmpty()) {
			System.out.println("No bogies match the filter.");
		} else {
			for (Bogie b : highCapacityBogies) {
				System.out.println(b.name + " - " + b.capacity + " seats");
			}
		}

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

		// ===== UC10: TOTAL seating capacity using map(...) + reduce(...) =====
		// Steps:
		// 1) We already have a List<Bogie> named 'passengerBogies' from UC7.
		// 2) Convert it into a stream.
		// 3) map(...) to extract integer capacities.
		// 4) reduce(0, Integer::sum) to add them all up into a single total.
		int totalSeatingCapacity = passengerBogies
				.stream()                       // make a stream from the list
				.map(b -> b.capacity)           // transform Bogie -> Integer (capacity)
				.reduce(0, Integer::sum);       // sum them all, starting from 0

		// 5) Print the total seating capacity
		System.out.println("\nUC10: Total seating capacity across passenger bogies:");
		System.out.println(totalSeatingCapacity + " seats total");


		// ===== UC11: Validate Train ID & Cargo Code using REGEX =====
		// 1) Compile regex patterns with Pattern.
		// 2) Create Matcher for user input.
		// 3) Use matches() to check full-string format validity.
		// Patterns:
		//   - Train ID: TRN-\\d{4}  (TRN- followed by exactly 4 digits)
		//   - Cargo Code: PET-[A-Z]{2} (PET- followed by exactly 2 uppercase letters)
		java.util.regex.Pattern trainIdPattern = java.util.regex.Pattern.compile("TRN-\\d{4}");
		java.util.regex.Pattern cargoCodePattern = java.util.regex.Pattern.compile("PET-[A-Z]{2}");

		// Sample inputs to test (some valid, some invalid):
		String[] trainIdSamples = { "TRN-1234", "TRAIN12", "TRN12A", "1234-TRN", "TRN-0001" };
		String[] cargoCodeSamples = { "PET-AB", "PET-12", "pet-AB", "PET-ABC", "PET-ZZ" };

		// Validate Train IDs
		System.out.println("\nUC11: Train ID format check (pattern: TRN-\\d{4})");
		for (String input : trainIdSamples) {
			boolean isValid = trainIdPattern.matcher(input).matches(); // matches() -> full-string match
			System.out.println("  " + input + " -> " + (isValid ? "VALID" : "INVALID"));
		}

		// Validate Cargo Codes
		System.out.println("\nUC11: Cargo Code format check (pattern: PET-[A-Z]{2})");
		for (String input : cargoCodeSamples) {
			boolean isValid = cargoCodePattern.matcher(input).matches();
			System.out.println("  " + input + " -> " + (isValid ? "VALID" : "INVALID"));
		}


		// ===== UC12: Safety Compliance for Goods Bogies (Streams + allMatch) =====
		//   - safeGoods: should PASS the rule.
		//   - unsafeGoods: should FAIL because a Cylindrical bogie carries non-Petroleum.
		java.util.List<GoodsBogie> safeGoods = new java.util.ArrayList<>();
		safeGoods.add(new GoodsBogie("Rectangular", "Coal"));       
		safeGoods.add(new GoodsBogie("Cylindrical", "Petroleum")); 

		java.util.List<GoodsBogie> unsafeGoods = new java.util.ArrayList<>();
		unsafeGoods.add(new GoodsBogie("Cylindrical", "Coal"));   
		unsafeGoods.add(new GoodsBogie("Rectangular", "Wheat"));    

		// Define the rule in a single readable predicate:
		// If shape is Cylindrical -> cargo MUST be Petroleum.
		java.util.function.Predicate<GoodsBogie> safetyRule = gb ->
		!gb.shape.equalsIgnoreCase("Cylindrical") || gb.cargo.equalsIgnoreCase("Petroleum");

		// Check both scenarios using allMatch(...):
		boolean safeResult   = safeGoods.stream().allMatch(safetyRule);
		boolean unsafeResult = unsafeGoods.stream().allMatch(safetyRule);

		// Show inputs and results:
		System.out.println("\nUC12: Safety Compliance Check (Rule: Cylindrical -> Petroleum only)");
		System.out.println("Safe scenario bogies: " + safeGoods);
		System.out.println("Is train safety compliant? " + safeResult);	

		System.out.println("\nUnsafe scenario bogies: " + unsafeGoods);
		System.out.println("Is train safety compliant? " + unsafeResult + "  (expected: false)");


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


		// ===== UC14: Custom Exception – Prevent invalid passenger bogies =====
		System.out.println("\nUC14: Creating PassengerBogie with validation (throws InvalidCapacityException)...");

		java.util.List<PassengerBogie> validatedPassengerBogies = new java.util.ArrayList<>();

		// A) Try to create an INVALID passenger bogie (capacity = 0) -> should FAIL and be caught.
		try {
			PassengerBogie invalid = new PassengerBogie("InvalidZero", 0);
			// This line should NOT run, because the constructor throws before this point.
			validatedPassengerBogies.add(invalid);
		} catch (InvalidCapacityException e) {
			System.out.println("Failed to create passenger bogie: " + e.getMessage());
		}

		// B) Try another INVALID case (negative capacity) -> should FAIL.
		try {
			PassengerBogie invalidNeg = new PassengerBogie("InvalidNegative", -5);
			validatedPassengerBogies.add(invalidNeg);
		} catch (InvalidCapacityException e) {
			System.out.println("Failed to create passenger bogie: " + e.getMessage());
		}

		// C) Create a VALID passenger bogie -> should PASS and get added to the list.
		try {
			PassengerBogie valid = new PassengerBogie("Sleeper-Validated", 72);
			validatedPassengerBogies.add(valid);
			System.out.println("Created successfully: " + valid);
		} catch (InvalidCapacityException e) {
			// This won't run for valid input
			System.out.println("Unexpected error: " + e.getMessage());
		}

		// Show what's finally in the validated list (only valid bogies).
		System.out.println("Validated passenger bogies in the consist: " + validatedPassengerBogies);


	}
}