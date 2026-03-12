/**
 * UC18:
 *  - Create an array of bogie IDs (UNSORTED).
 *  - Search for a specific bogie ID using LINEAR SEARCH.
 *  - Compare each element one-by-one using equals().
 *  - Stop searching as soon as a match is found.
 *  - Display whether the bogie exists or not.
 *  @author Shrivatsa Guru
 *  @version 18.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // 1) Create an array of bogie IDs (unsorted).
        String[] bogieIds = {
                "BG105",
                "BG101",
                "BG110",
                "BG103",
                "BG108"
        };

        // 2) Define the bogie ID we want to search for.
        String searchKey = "BG103";

        // 3) Flag to track whether the bogie is found.
        boolean found = false;

        // 4) Linear Search:
        //    Traverse the array from start to end.
        for (int i = 0; i < bogieIds.length; i++) {
            // Compare current element with the search key
            if (bogieIds[i].equals(searchKey)) {
                found = true;     // Match found
                break;            // Stop searching immediately
            }
        }

        // 5) Display the result.
        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the train.");
        } else {
            System.out.println("Bogie ID " + searchKey + " does NOT exist in the train.");
        }
    }
}