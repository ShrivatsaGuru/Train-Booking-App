package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import main.*;
/**
 * UC2 JUnit Test
 * --------------
 * - ONLY runs main()
 * - ONLY checks console output
 * - NO logic duplication
 * - NO ArrayList manipulation in test
 */
public class UC2Test {

    @Test
    void uc2_shouldPerformAllArrayListOperationsCorrectly() {
        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        // Run UC2 main()
        TrainMain.main(new String[]{});

        // Restore System.out
        System.setOut(originalOut);

        String console = output.toString();

        // 1) Verify bogies were added
        assertTrue(console.contains("[Sleeper, AC Chair, First Class]"));

        // 2) Verify AC Chair removal
        assertTrue(console.contains("Removed? true"));

        // 3) Verify Sleeper existence check
        assertTrue(console.contains("Does the consist have 'Sleeper'? true"));

        // 4) Verify final bogie count
        assertTrue(console.contains("Final bogie count: 2"));

        // 5) Verify final list state
        assertTrue(console.contains("[Sleeper, First Class]"));
    }
}