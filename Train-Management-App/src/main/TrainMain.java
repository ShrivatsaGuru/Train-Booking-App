package main;

/** 
 * UC12:
 *  - Prepare a list of GOODS bogies (shape + cargo).
 *  - Use Streams + allMatch(...) to enforce a simple safety rule:
 *      If shape == "Cylindrical" -> cargo must be "Petroleum".
 *  - Print whether the goods consist is safety-compliant.
 *@author Shrivatsa Guru
 *@version 12.0
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
		// ===== UC12: Safety Compliance for Goods Bogies (Streams + allMatch) =====
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
	}
}