# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

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
