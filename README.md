# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

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
