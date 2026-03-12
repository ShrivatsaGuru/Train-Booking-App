package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UC14Test {

    @Test
    void uc14_shouldValidateCapacityThrowCheckedExceptionAndKeepOnlyValidBogie() {
        // Capture System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            // Run UC14 main()
            TrainMain.main(new String[]{});
        } finally {
            System.setOut(original);
        }

        String console = out.toString();

        // 1) Header line
        assertTrue(console.contains(
            "UC14: Creating PassengerBogie with validation (throws InvalidCapacityException)..."
        ));

        // 2) Two failures for invalid capacities (0 and -5)
        //    Note: The message contains HTML-escaped '>' as '&gt;'
        assertTrue(console.contains(
            "Failed to create passenger bogie: Capacity must be > 0 for passenger bogie 'InvalidZero'. Provided: 0"
        ));
        assertTrue(console.contains(
            "Failed to create passenger bogie: Capacity must be > 0 for passenger bogie 'InvalidNegative'. Provided: -5"
        ));

        // 3) One success for the valid bogie
        assertTrue(console.contains(
            "Created successfully: Sleeper-Validated (72 seats) [validated]"
        ));

        // 4) Final list should contain only the valid bogie
        assertTrue(console.contains(
            "Validated passenger bogies in the consist: [Sleeper-Validated (72 seats) [validated]]"
        ));
    }
}