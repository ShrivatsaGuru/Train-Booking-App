package main;

/**
 * UC15 (this step):
 *  - Custom RUNTIME exception: CargoSafetyException (extends RuntimeException).
 *  - Validate at assignment time:
 *      Rule for demo: If shape == "Rectangular" AND cargo == "Petroleum" -> UNSAFE.
 *  - Use try-catch-finally around assignment attempts:
 *      * try    : attempt assignment
 *      * catch  : show friendly error if unsafe
 *      * finally: log/cleanup; runs whether or not an exception occurred
 *@author Shrivatsa Guru
 *@version 15.0
 */
public class TrainMain {
	static class GoodsBogie {
		String shape;
		String cargo;

		GoodsBogie(String shape, String cargo) {
			this.shape = shape;
			this.cargo = cargo;
		}

		@Override
		public String toString() {
			return shape + " carrying " + cargo;
		}
	}
	static void assignCargoToGoodsBogie(GoodsBogie gb, String newCargo) {
		boolean isRectangular = gb.shape.equalsIgnoreCase("Rectangular");
		boolean isPetroleum   = newCargo.equalsIgnoreCase("Petroleum");

		if (isRectangular && isPetroleum) {
			// Violation -> throw runtime exception (will be caught by caller).
			throw new CargoSafetyException(
					"Unsafe assignment: '" + gb.shape + "' bogie cannot carry '" + newCargo + "'.");
		}
		gb.cargo = newCargo;
	}
	public static void main(String[] args) {
		// ===== UC15: Safe cargo assignment with try-catch-finally =====
		System.out.println("\nUC15: Safe cargo assignment (Rectangular + Petroleum should FAIL)");
		GoodsBogie rect = new GoodsBogie("Rectangular", "Coal"); // starts safe
		// Case 1: UNSAFE assignment -> expect exception, catch it, and run finally
		try {
			System.out.println("Attempting to assign 'Petroleum' to Rectangular bogie...");
			assignCargoToGoodsBogie(rect, "Petroleum"); // should throw
			System.out.println("Assignment succeeded (this line should NOT print). Current: " + rect);
		} catch (CargoSafetyException ex) {
			System.out.println("Unsafe assignment blocked: " + ex.getMessage());
		} finally {
			System.out.println("[finally] Assignment attempt finished (logged/cleaned up).");
		}
		// Case 2: SAFE assignment -> succeeds, finally still runs
		try {
			System.out.println("\nAttempting to assign 'Wheat' to Rectangular bogie...");
			assignCargoToGoodsBogie(rect, "Wheat"); // allowed
			System.out.println("Assignment OK. Current: " + rect);
		} catch (CargoSafetyException ex) {
			System.out.println("Unexpected failure: " + ex.getMessage());
		} finally {
			System.out.println("[finally] Assignment attempt finished (logged/cleaned up).");
		}
		// Case 3: Another SAFE scenario (Cylindrical + Petroleum) to contrast behavior
		GoodsBogie cyl = new GoodsBogie("Cylindrical", "Wheat"); // change later to Petroleum (allowed here)
		try {
			System.out.println("\nAttempting to assign 'Petroleum' to Cylindrical bogie...");
			assignCargoToGoodsBogie(cyl, "Petroleum"); // allowed in UC15 rule demo
			System.out.println("Assignment OK. Current: " + cyl);
		} catch (CargoSafetyException ex) {
			System.out.println("Unexpected failure: " + ex.getMessage());
		} finally {
			System.out.println("[finally] Assignment attempt finished (logged/cleaned up).");
		}
	}
}