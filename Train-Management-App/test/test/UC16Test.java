package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * UC16 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies Bubble Sort output (ascending order)
 */
public class UC16Test {

    @Test
    void uc16_shouldPrintSortedCapacitiesAscending() {
        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC16 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Expected sorted output from UC16
        assertTrue(console.contains(
                "Sorted capacities (ascending): 24 30 56 60 72 90"));
    }
}