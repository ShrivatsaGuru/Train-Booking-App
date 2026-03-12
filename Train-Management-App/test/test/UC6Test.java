package test;
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC6 Test (main-only, output-based)
 * - Runs TrainMain.main(...)
 * - Verifies the UC6 header and each bogie -> capacity line.
 */
public class UC6Test {

    @Test
    void uc6_shouldPrintBogieCapacityMapping_viaMainOutput() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            // Run UC6 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Each expected mapping line
        assertTrue(console.contains("Sleeper : 72 seats"));
        assertTrue(console.contains("AC Chair : 56 seats"));
        assertTrue(console.contains("First Class : 24 seats"));
    }
}