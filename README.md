# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.


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
