package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*;

/**
 * UC5 Test (main-only, output-based)
 * - Runs TrainMain.main(...)
 * - Verifies the header and the final LinkedHashSet formation string.
 */
public class UC5Test {

    @Test
    void uc5_shouldPrintInsertionOrderNoDuplicates_viaMainOutput() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            // Run UC5 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Header line
        assertTrue(
            console.contains("UC5: Final formation using LinkedHashSet (order preserved + no duplicates):"),
            "Expected UC5 header to be printed"
        );

        // Final formation must be exactly in insertion order with no duplicate 'Sleeper'
        assertTrue(
            console.contains("[Engine, Sleeper, Cargo, Guard]"),
            "Expected final formation: [Engine, Sleeper, Cargo, Guard]"
        );
    }
}