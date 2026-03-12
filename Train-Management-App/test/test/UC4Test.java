package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*;
/**
 * UC4 Test (main-only, output-based)
 * - Runs TrainMain.main(...)
 * - Verifies the printed lists and removed bogies exactly as per UC4.
 */
public class UC4Test {

    @Test
    void uc4_shouldMaintainOrderedConsistAndReportRemovals_viaMainOutput() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            // Run UC4 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) After initial additions
        assertTrue(console.contains("UC4: Ordered consist after initial additions:"));
        assertTrue(console.contains("[Engine, Sleeper, AC, Cargo, Guard]"));

        // 2) After inserting Pantry Car at index 2
        assertTrue(console.contains("After inserting 'Pantry Car' at index 2:"));
        assertTrue(console.contains("[Engine, Sleeper, Pantry Car, AC, Cargo, Guard]"));

        // 3) Removed first and last bogie
        assertTrue(console.contains("Removed first bogie: Engine"));
        assertTrue(console.contains("Removed last bogie : Guard"));

        // 4) Final ordered consist
        assertTrue(console.contains("Final ordered train consist:"));
        assertTrue(console.contains("[Sleeper, Pantry Car, AC, Cargo]"));
    }
}