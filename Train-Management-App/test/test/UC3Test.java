package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*;
/**
 * UC3 Test (main-only)
 * - Runs TrainMain.main(...)
 * - Verifies header line
 * - Verifies BG101, BG102, BG103 are present exactly once (order doesn't matter)
 */
public class UC3Test {

    @Test
    void uc3_shouldPrintUniqueIdsOnce_onlyViaMainOutput() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            // Run UC3 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) Header present
        assertTrue(console.contains("UC3: Unique bogie IDs (HashSet):"));

        // 2) Set output contains all three IDs (order is not guaranteed)
        assertTrue(console.contains("BG101"));
        assertTrue(console.contains("BG102"));
        assertTrue(console.contains("BG103"));

        // 3) Each ID appears only once in the printed set (duplicates ignored)
        assertEquals(console.indexOf("BG101"), console.lastIndexOf("BG101"));
        assertEquals(console.indexOf("BG102"), console.lastIndexOf("BG102"));
        assertEquals(console.indexOf("BG103"), console.lastIndexOf("BG103"));
    }
}