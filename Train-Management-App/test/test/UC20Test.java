package test;
import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UC20 Test (main-only)
 * - Runs TrainMain.main()
 * - Verifies IllegalStateException is thrown for empty bogie list
 */
public class UC20Test {

    @Test
    void uc20_shouldThrowExceptionWhenSearchingEmptyTrain() {
        // UC20 must FAIL FAST when no bogies exist
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> TrainMain.main(new String[]{})
        );

        // Verify the exception message
        assertEquals(
                "Search operation failed: No bogies available in the train.",
                exception.getMessage()
        );
    }
}