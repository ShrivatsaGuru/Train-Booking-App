package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*
;/**
 * UC17 Test (main-only, output-based)
 * - Runs TrainMain.main()
 * - Verifies the "before" and "after" sorting prints
 */
public class UC17Test {

    @Test
    void uc17_shouldPrintAlphabeticallySortedBogieNames() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC17 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) "Before Sorting" header and initial array print should appear
        assertTrue(console.contains("Before Sorting:"));
        assertTrue(console.contains("[Sleeper, AC Chair, First Class, Cargo, Guard, Engine]"));

        // 2) "Sorted bogie names" header must appear
        assertTrue(console.contains("Sorted bogie names:"));

        // 3) Final sorted order must be alphabetical
        assertTrue(console.contains("[AC Chair, Cargo, Engine, First Class, Guard, Sleeper]"));
    }
}