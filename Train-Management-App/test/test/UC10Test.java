package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC10 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies total seating capacity calculation output
 */
public class UC10Test {

    @Test
    void uc10_shouldPrintTotalSeatingCapacity() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC10 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) Header must be printed
        assertTrue(console.contains(
                "UC10: Total seating capacity across passenger bogies:"));

        // 2) Total seats must be correct (72 + 56 + 24 = 152)
        assertTrue(console.contains("152 seats total"));
    }
}