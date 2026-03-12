package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*
;/**
 * UC12 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies safety compliance output for goods bogies
 */
public class UC12Test {

    @Test
    void uc12_shouldCheckSafetyComplianceCorrectly() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC12 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) Header must be printed
        assertTrue(console.contains(
                "UC12: Safety Compliance Check (Rule: Cylindrical -> Petroleum only)"));

        // 2) Safe scenario must be compliant
        assertTrue(console.contains("Safe scenario bogies"));
        assertTrue(console.contains("Is train safety compliant? true"));

        // 3) Unsafe scenario must be non-compliant
        assertTrue(console.contains("Unsafe scenario bogies"));
        assertTrue(console.contains("Is train safety compliant? false"));
    }
}