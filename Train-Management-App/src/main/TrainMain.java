package main;

/**
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

	static class InvalidCapacityException extends Exception {
		InvalidCapacityException(String message) {
			super(message);
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
		// ===== UC14: Custom Exception – Prevent invalid passenger bogies =====
		System.out.println("UC14: Creating PassengerBogie with validation (throws InvalidCapacityException)...");

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