package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*;
/**
 * UC8 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies filtering condition: capacity > 60
 * - Ensures only qualifying bogies are printed
 */
public class UC8Test {

    @Test
    void uc8_shouldPrintOnlyHighCapacityBogies() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC8 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) Header must be printed
        assertTrue(console.contains(
                "UC8: Filtered passenger bogies (capacity > 60):"));

        // 2) Sleeper (72) must be present
        assertTrue(console.contains("Sleeper - 72 seats"));

        // 3) AC Chair (56) must NOT be present
        assertFalse(console.contains("AC Chair - 56 seats"));

        // 4) First Class (24) must NOT be present
        assertFalse(console.contains("First Class - 24 seats"));
    }
}