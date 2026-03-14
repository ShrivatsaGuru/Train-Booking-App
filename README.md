# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

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
alidation and safe error handling in Java applications.
