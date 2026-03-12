package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC11 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies REGEX validation output for Train ID and Cargo Code
 */
public class UC11Test {

    @Test
    void uc11_shouldValidateTrainIdAndCargoCodeFormats() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC11 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // ---- Train ID validation checks ----
        assertTrue(console.contains("UC11: Train ID format check"));
        assertTrue(console.contains("TRN-1234 -> VALID"));
        assertTrue(console.contains("TRAIN12 -> INVALID"));
        assertTrue(console.contains("TRN12A -> INVALID"));
        assertTrue(console.contains("1234-TRN -> INVALID"));
        assertTrue(console.contains("TRN-0001 -> VALID"));

        // ---- Cargo Code validation checks ----
        assertTrue(console.contains("UC11: Cargo Code format check"));
        assertTrue(console.contains("PET-AB -> VALID"));
        assertTrue(console.contains("PET-12 -> INVALID"));
        assertTrue(console.contains("pet-AB -> INVALID"));
        assertTrue(console.contains("PET-ABC -> INVALID"));
        assertTrue(console.contains("PET-ZZ -> VALID"));
    }
}