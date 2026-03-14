package main;
/**
 * UC20:
 *  - Prevent search operations when the train has NO bogies.
 *  - Check the state BEFORE searching.
 *  - If the bogie collection is EMPTY, throw IllegalStateException.
 *  - Stop execution immediately and show a meaningful error message.
 *  @author Shrivatsa Guru
 *  @version 20.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // 1) Create an EMPTY array of bogie IDs (no bogies added yet).
        String[] bogieIds = {};

        // 2) Bogie ID we want to search for.
        String searchKey = "BG101";

        // 3) DEFENSIVE CHECK:
        //    If no bogies exist, searching makes no sense.
        if (bogieIds.length == 0) {
            // Throw IllegalStateException as required by UC20.
            throw new IllegalStateException(
                    "Search operation failed: No bogies available in the train."
            );
        }

        // 4) (This code will NOT run if the exception is thrown above)
        boolean found = false;
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break;
            }
        }

        // 5) Display result (only reached if bogieIds was NOT empty).
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }
    }
}
