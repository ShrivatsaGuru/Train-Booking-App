package main;
/**
 * UC19:
 *  - Use BINARY SEARCH on a SORTED array of bogie IDs to find a specific ID.
 *  - Initialize low/high indexes, compute mid, compare using compareTo(), and
 *    narrow the search range until found or exhausted.
 *  - Display whether the bogie ID exists.
 *@author Shrivatsa Guru
 *@version 19.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // 1) Prepare a SORTED array of bogie IDs (lexicographic order).
        String[] sortedBogieIds = {
                "BG101", "BG102", "BG103", "BG104", "BG105",
                "BG106", "BG107", "BG108", "BG109", "BG110"
        };

        // 2) Define the bogie ID we want to search for.
        String searchKey = "BG108";

        // 3) Initialize the search bounds: low (start index) and high (end index).
        int low = 0;
        int high = sortedBogieIds.length - 1;

        // 4) Variable to remember whether we found the key (and at which index).
        int foundIndex = -1; // stays -1 if not found

        // 5) Binary Search loop:

        while (low <= high) {
            // Compute middle index safely:
            int mid = low + (high - low) / 2;

            int comparison = searchKey.compareTo(sortedBogieIds[mid]);

            if (comparison == 0) {
                // Found the key at index 'mid'
                foundIndex = mid;
                break; // Stop the search immediately
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // 6) Display the result.
        if (foundIndex != -1) {
            System.out.println("Bogie ID " + searchKey + " found at index " + foundIndex + ".");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT found in the train.");
        }
    }
}