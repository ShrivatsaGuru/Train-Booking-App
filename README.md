# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.
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
