package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UC13Test {

    @Test
    void uc13_shouldPrintCountsAndTimings_viaMainOutput() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        try {
            // Run UC13 main()
            TrainMain.main(new String[]{});
        } finally {
            // Restore System.out
            System.setOut(original);
        }

        String console = out.toString();

        // Header
        assertTrue(console.contains("UC13: Performance Comparison (Loop vs Stream)"));

        // Totals and counts
        assertTrue(console.contains("Total bogies: 100000"));
        assertTrue(console.contains("Loop-based filtered count   : 40000"));
        assertTrue(console.contains("Stream-based filtered count : 40000"));

        // Timing lines (values vary; just check labels exist)
        assertTrue(console.contains("Loop time   : "));
        assertTrue(console.contains("Stream time : "));
    }
}