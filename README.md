# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

## UC1: Initialize Train and Display Consist Summary

+ Initializes the Train Consist Management Application and displays a welcome banner when the program starts.
+ Creates a dynamic data structure using ArrayList to store train bogies.
+ Demonstrates the use of the Java Collections Framework with List<String>.
+ Initializes the train consist as an empty list, representing a newly created train.
+ Sets the initial bogie count to 0 to indicate that no bogies are attached yet.
+ Displays the initial state of the train consist to the user.
+ Uses Scanner to prepare the application for future user input operations.
+ Illustrates basic program startup flow and system initialization.
+ Provides a simple foundation for future train consist operations such as adding or removing bogies.
+ Confirms that the system is ready for further management operations.

## UC2: Add Passenger Bogies to Train (ArrayList Operations)

+ Demonstrates dynamic management of passenger bogies using ArrayList.
+ Initializes an empty List<String> to represent passenger bogies in the train.
+ Adds different bogie types such as Sleeper, AC Chair, and First Class using add().
+ Displays the train consist after adding bogies to show list insertion.
+ Removes a bogie (AC Chair) using the remove() method.
+ Prints the updated list after removal to reflect the change.
+ Uses the contains() method to check if a specific bogie type exists.
+ Demonstrates basic CRUD operations (Create, Read, Update, Delete) with ArrayList.
+ Displays the final passenger bogie configuration of the train.
+ Confirms that all train consist operations executed successfully.

## UC3: Track Unique Bogie IDs (Set – HashSet)

+ Demonstrates how unique bogie IDs can be managed using the HashSet collection.
+ Initializes a Set<String> to store bogie identifiers for the train.
+ Adds bogie IDs such as BG101, BG102, and BG103 using the add() method
+ Displays the set of bogie IDs after initial insertion.
+ Attempts to insert duplicate bogie IDs into the set.
+ Shows that HashSet automatically prevents duplicate entries.
+ Ensures data uniqueness and integrity in the train consist.
+ Demonstrates the Set data structure property of storing unique elements only.
+ Prints informative messages explaining how duplicates are handled.
+ Confirms that the bogie ID tracking operations completed successfully.

## UC4: Maintain Ordered Bogie IDs (TreeSet & SortedSet)

+ Demonstrates how ordered train bogies can be managed using a LinkedList.
+ Initializes a LinkedList to represent the sequential structure of a train consist.
+ Adds bogies such as Engine, Sleeper, AC, Cargo, and Guard using add().
+ Displays the initial train consist to show the insertion order.
+ Inserts a Pantry Car at a specific position using indexed insertion.
+ Shows how LinkedList supports positional operations efficiently.
+ Removes the first and last bogies using removeFirst() and removeLast().
+ Prints the updated train consist after modifications.
+ Demonstrates dynamic restructuring of train bogies similar to real train coupling and decoupling.
+ Confirms that all train consist operations executed successfully

## UC5: Preserve Insertion Order of Bogies (LinkedHashSet)

+ Demonstrates the use of LinkedHashSet to manage train bogies while preserving insertion order.
+ Initializes a Set<String> using LinkedHashSet to store the train formation.
+ Adds bogies such as Engine, Sleeper, Cargo, and Guard to the formation.
+ Attempts to add duplicate bogies to illustrate how duplicates are handled.
+ Shows that LinkedHashSet automatically prevents duplicate entries.
+ Maintains the exact order in which bogies were inserted.
+ Displays the final train formation with unique and ordered elements.
+ Demonstrates a combination of Set uniqueness and List-like ordering behavior.
+ Helps simulate real-world train attachment order management.
+ Confirms that the ordered uniqueness operations completed successfully.

## UC6: Map Bogie to Capacity (HashMap)

+ Demonstrates how bogie capacity information can be managed using a HashMap.
+ Initializes a Map<String, Integer> to represent bogie type and its capacity.
+ Uses the key–value mapping structure where the bogie name is the key and capacity is the value.
+ Adds entries such as First Class, Cargo, Sleeper, and AC Chair using put().
+ Stores seating or load capacity values associated with each bogie type.
+ Displays the complete bogie–capacity mapping stored in the HashMap.
+ Demonstrates how HashMap enables fast lookup and retrieval of values using keys.
+ Illustrates the concept of associative data storage in Java Collections.
+ Provides a simple model for managing train resource information efficiently.
+ Confirms that the bogie capacity mapping operations completed successfully.

## UC7: Sort Bogies by Capacity (Comparator)

+ This module demonstrates sorting of train bogie objects using a custom Comparator in Java.
+ Each Bogie object contains attributes such as bogie name and seating capacity.
+ Multiple bogie objects are stored in a List collection (ArrayList).
+ The program first displays the bogie details in their original insertion order.
+ A Comparator implementation is then used to define custom sorting logic.
+ Bogies are sorted based on their seating capacity in ascending order.
+ The sorted list is displayed to verify the correct ordering of bogies.
+ This use case highlights the use of Collections.sort() with Comparator for object sorting.
+ It demonstrates practical usage of Java Collections Framework and custom ordering of objects.

## UC8: Filter Passenger Bogies Using Streams

+ This module demonstrates filtering of bogie objects using the Java Stream API.
+ Each Bogie object contains attributes such as bogie name and seating capacity.
+ Multiple bogie objects are stored in an ArrayList collection.
+ The program first displays all passenger bogies present in the list.
+ The list is then converted into a stream using stream().
+ A filter condition is applied to select bogies with capacity greater than 60.
+ The filtered results are collected into a new list using toList().
+ Only bogies meeting the condition are displayed as the filtered output.
+ This use case demonstrates functional-style data processing using Java Streams and lambda expressions.

## UC9: Group Bogies by Type (Collectors.groupingBy)

+ This module demonstrates grouping of bogie objects using Java Stream Collectors.
+ Each Bogie object contains attributes such as bogie name and seating capacity.
+ Multiple bogie objects are stored in an ArrayList collection.
+ The program first displays all passenger bogies present in the list.
+ The list is converted into a stream using the stream() method.
+ The Collectors.groupingBy() function is applied to group bogies based on their type (name).
+ The grouped result is stored in a Map structure where the key represents the bogie type.
+ Each group of bogies is displayed along with their capacity details.
+ This use case demonstrates data classification using Java Streams and grouping operations.

## UC10: Count Total Seats in Train (reduce)

+ This module demonstrates aggregation of bogie capacities using the Java Stream API.
+ Each Bogie object contains attributes such as bogie name and seating capacity.
+ Multiple bogie objects are stored in an ArrayList collection.
+ The program first displays all passenger bogies along with their capacities.
+ The list is converted into a stream using the stream() method.
+ Each bogie object is mapped to its seating capacity using map().
+ The capacities are combined into a single value using the reduce() operation.
+ The final result represents the total seating capacity of the entire train.
+ This use case demonstrates aggregation and functional data processing using Java Streams.

## UC11: Validate Train ID & Cargo Codes (Regex)

+ This module demonstrates input validation using Regular Expressions (Regex) in Java.
+ The program accepts Train ID and Cargo Code inputs from the user using the Scanner class.
+ The expected format for Train ID is TRN-1234, where the last four characters are digits.
+ The expected format for Cargo Code is PET-AB, where the last two characters are uppercase letters.
+ The matches() method is used to validate the input against predefined regex patterns.
+ Regex pattern TRN-\\d{4} ensures the Train ID follows the required numeric format.
+ Regex pattern PET-[A-Z]{2} ensures the Cargo Code contains two uppercase letters.
+ The program displays whether each input is valid or invalid based on pattern matching.
+ This use case demonstrates data validation using Java Regular Expressions and user input handling.

## UC12: Safety Compliance Check for Goods Bogies

+ This module demonstrates safety rule validation for goods bogies using Java Streams.
+ Each GoodsBogie object contains attributes such as bogie type and cargo type.
+ A list of goods bogies is created using List.of().
+ The program first displays all goods bogies along with their cargo details.
+ The list is converted into a stream using the stream() method.
+ A safety rule is applied to check invalid combinations of bogie type and cargo.
+ The allMatch() method verifies whether all bogies satisfy the safety condition.
+ If any unsafe combination is found, the system flags a safety compliance warning.
+ This use case demonstrates real-world rule validation using Java Streams and functional programming concepts.

## UC13: Performance Comparison (Loops vs Streams)

+ This module demonstrates performance benchmarking between traditional loops and Java Streams.
+ Each Bogie object contains attributes such as bogie type and seating capacity.
+ A dataset of bogie objects is created to simulate train consist data processing.
+ The program measures execution time using System.nanoTime() for high-resolution timing.
+ A traditional for loop is used to filter passenger bogies with capacity greater than 100.
+ The same filtering logic is implemented using the Java Stream API with filter().
+ Execution time for both approaches is calculated by subtracting start and end timestamps.
+ The results display loop-based and stream-based processing durations in nanoseconds.
+ This use case demonstrates performance comparison and benchmarking techniques in Java.


## UC14: Handle Invalid Bogie Capacity (Custom Exception)

+ This module demonstrates error handling using a custom exception in Java.
+ A custom exception class InvalidCapacityException is defined to handle invalid seating capacities.
+ The PassengerBogie class validates seating capacity within its constructor.
+ If the seating capacity is less than or equal to zero, the custom exception is thrown.
+ This ensures that invalid passenger bogies cannot be created in the system.
+ The program attempts to create both valid and invalid bogie objects.
+ The invalid case triggers the custom exception, preventing incorrect object creation.
+ The exception is handled using a try-catch block to maintain safe program execution.
+ This use case demonstrates fail-fast validation and robust error handling using checked exceptions.

## UC15: Safe Cargo Assignment Using try-catch-finally

+ This module demonstrates runtime safety validation using structured exception handling in Java.
+ A custom runtime exception CargoSafetyException is defined for unsafe cargo assignments.
+ The GoodsBogie class represents a goods wagon with attributes such as shape and cargo type.
+ The assignCargo() method validates cargo assignments based on predefined safety rules.
+ If an unsafe combination is detected, the method throws a CargoSafetyException.
+ The program attempts to assign multiple cargo types to different bogies.
+ The try-catch block captures and handles unsafe cargo assignments gracefully.
+ The finally block executes after every attempt to log the cargo assignment process.
+ This use case demonstrates robust runtime validation using custom exceptions and try-catch-finally blocks.

## UC16: Sort Passenger Bogies by Capacity (Bubble Sort – Algorithm Intro)

+ This module demonstrates manual sorting using the Bubble Sort algorithm in Java.
+ A list of passenger bogie seating capacities is created using List.of().
+ The list is converted into an array to perform element swapping during sorting.
+ The Bubble Sort algorithm compares adjacent elements in each pass.
+ If a value is greater than the next value, the elements are swapped.
+ Multiple passes are performed until all elements are arranged in ascending order.
+ The algorithm ensures that larger capacities gradually move to the end of the array.
+ The program finally displays the sorted passenger bogie capacities.
+ This use case demonstrates basic sorting algorithm implementation and understanding of algorithmic logic in Java.

## UC17: Sort Bogie Names Using Arrays.sort()

+ This module demonstrates alphabetical sorting using Java’s built-in sorting utilities.
+ A collection of bogie type names is created using an ArrayList.
+ The program first displays the original order of bogie names.
+ The list is converted into a String array for sorting operations.
+ The Arrays.sort() method is used to sort the bogie names alphabetically.
+ This method uses optimized internal sorting algorithms provided by Java.
+ After sorting, the program displays the bogie names in ascending alphabetical order.
+ This approach simplifies sorting by leveraging Java’s standard library functions.
+ This use case demonstrates efficient data sorting using built-in Java utility methods.

## UC18: Linear Search for Bogie ID (Array-Based Searching)

+ This module demonstrates searching for a bogie name using the Linear Search algorithm.
+ A list of bogie names is created using an ArrayList collection.
+ The program first displays all available bogie names in the system.
+ A search key is defined to represent the bogie that needs to be located.
+ The program performs a sequential traversal through the list.
+ Each element is compared with the search key using the equals() method.
+ If a match is found, the search terminates immediately.
+ The program then displays whether the bogie was found or not found in the list.
+ This use case demonstrates basic searching logic using sequential traversal in Java.

## UC19: Binary Search for Bogie ID (Optimized Searching)

+ This module demonstrates efficient searching using the Binary Search algorithm.
+ A list of bogie names is created to represent sorted train consist data.
+ The program first displays all available bogie names in the list.
+ A search key is defined to identify the bogie that needs to be located.
+ Binary Search works by dividing the search range into two halves repeatedly.
+ The middle element is compared with the search key to determine the next search range.
+ If the key is greater than the middle value, the right half of the list is searched.
+ If the key is smaller, the left half of the list is searched.
+ This use case demonstrates optimized searching using the divide-and-conquer technique in Java.

## UC20: Exception Handling During Search Operations

+ This module demonstrates defensive programming using runtime exceptions in Java.
+ A collection of bogie IDs is created to represent train consist data.
+ The program defines a search ID that needs to be located in the list.
+ Before performing the search, the system validates whether bogie data exists.
+ If the collection is empty, the program throws an IllegalStateException.
+ This prevents execution of invalid search operations on empty data.
+ If data exists, the program performs a sequential search through the bogie IDs.
+ The result indicates whether the specified bogie ID was found or not found.
+ This use case demonstrates fail-fast validation and safe error handling in Java applications.
