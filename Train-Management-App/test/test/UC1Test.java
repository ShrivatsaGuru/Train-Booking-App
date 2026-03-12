package test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*
;/**
 * UC1 Test Cases
 * --------------
 * Tests ONLY what UC1 requires.
 * Simple, small, beginner-friendly.
 */
public class UC1Test {

    @Test
    void testWelcomeMessageIsPrinted() {
        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Run UC1
        TrainMain.main(new String[]{});

        // Check
        assertTrue(output.toString().contains("=== Train Consist Management App ==="));
    }

    @Test
    void testInitialBogieCountIsZero() {
        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Run UC1
        TrainMain.main(new String[]{});

        // Check initial bogie count
        assertTrue(output.toString().contains("Initial bogie count: 0"));
    }
}