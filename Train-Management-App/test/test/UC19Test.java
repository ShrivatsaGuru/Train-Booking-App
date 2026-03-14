package test;
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC19 Test (main-only, output-based)
 * - Runs TrainMain.main()
 * - Verifies binary search output for the given data (BG108 should be found at index 7)
 */
public class UC19Test {

    @Test
    void uc19_shouldReportFoundIndexForBinarySearch() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC19 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Since the sorted array includes BG108 at index 7,
        // the program should print this exact message.
        assertTrue(
            console.contains("Bogie ID BG108 found at index 7."),
            "Expected UC19 to report that BG108 is found at index 7."
        );
    }
}