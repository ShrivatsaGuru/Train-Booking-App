# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.



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
