# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

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
