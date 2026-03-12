package main;
/**
 * UC11 :
 *  - Validate Train ID and Cargo Code formats using REGEX with Pattern + Matcher.
 *  - Train ID example pattern: TRN-\\d{4}
 *  - Cargo Code example pattern: PET-[A-Z]{2}
 *  - Use matches() to ensure the ENTIRE input matches the required format.

 *@author Shrivatsa Guru
 *@version 11.0
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
		// ===== UC11: Validate Train ID & Cargo Code using REGEX =====
		// 1) Compile regex patterns with Pattern.
		// 2) Create Matcher for user input.
		// 3) Use matches() to check full-string format validity.
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
	}
}