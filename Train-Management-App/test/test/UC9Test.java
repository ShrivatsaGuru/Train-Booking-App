package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC9 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies grouping by TYPE output
 * - Order-independent checks (Map has no fixed order)
 */
public class UC9Test {

    @Test
    void uc9_shouldGroupBogiesByTypeCorrectly() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC9 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // 1) Header must be printed
        assertTrue(console.contains(
                "UC9: Grouped bogies by TYPE"));

        // 2) Passenger group must exist
        assertTrue(console.contains("> Passenger:"));

        // Passenger bogies
        assertTrue(console.contains("Sleeper (72 seats)"));
        assertTrue(console.contains("AC Chair (56 seats)"));
        assertTrue(console.contains("First Class (24 seats)"));

        // 3) Goods group must exist
        assertTrue(console.contains("> Goods:"));

        // Goods bogies
        assertTrue(console.contains("Rectangular (2 seats)"));
        assertTrue(console.contains("Cylindrical (5 seats)"));
    }
}