package test;
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * UC7 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies bogies are printed in ascending order of capacity
 */
public class UC7Test {

    @Test
    void uc7_shouldPrintBogiesSortedByCapacity() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC7 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Header check
        assertTrue(console.contains(
                "UC7: Passenger bogies AFTER sorting by capacity (ascending):"));

        // Sorted order check (24 -> 56 -> 72)
        int firstClass = console.indexOf("First Class - 24 seats");
        int acChair    = console.indexOf("AC Chair - 56 seats");
        int sleeper    = console.indexOf("Sleeper - 72 seats");

        assertTrue(firstClass < acChair, "First Class should appear before AC Chair");
        assertTrue(acChair < sleeper, "AC Chair should appear before Sleeper");
    }
}