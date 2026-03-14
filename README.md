# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.
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
