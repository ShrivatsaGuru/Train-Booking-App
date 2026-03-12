package test;
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC15 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies runtime exception handling with try-catch-finally
 */
public class UC15Test {

    @Test
    void uc15_shouldHandleUnsafeCargoAssignmentSafely() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC15 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) UC15 header
        assertTrue(console.contains(
                "UC15: Safe cargo assignment (Rectangular + Petroleum should FAIL)"));

        // 2) Unsafe assignment must be blocked
        assertTrue(console.contains(
                "Unsafe assignment blocked: Unsafe assignment: 'Rectangular' bogie cannot carry 'Petroleum'."));

        // 3) finally block must run after unsafe attempt
        assertTrue(console.contains(
                "[finally] Assignment attempt finished (logged/cleaned up)."));

        // 4) Safe assignment to Rectangular bogie must succeed
        assertTrue(console.contains(
                "Assignment OK. Current: Rectangular carrying Wheat"));

        // 5) Safe assignment to Cylindrical bogie must succeed
        assertTrue(console.contains(
                "Assignment OK. Current: Cylindrical carrying Petroleum"));
    }
}