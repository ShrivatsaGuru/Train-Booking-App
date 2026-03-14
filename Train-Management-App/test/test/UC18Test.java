package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*;
/**
 * UC18 Test (main-only, output-based)
 * - Runs TrainMain.main()
 * - Verifies linear search output for the given data (BG103 should be found)
 */
public class UC18Test {

    @Test
    void uc18_shouldReportSearchKeyExists() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC18 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Since the array includes BG103 and searchKey = "BG103",
        // the program should print that it exists.
        assertTrue(
            console.contains("Bogie ID BG103 exists in the train."),
            "Expected UC18 to report that BG103 exists."
        );
    }
}