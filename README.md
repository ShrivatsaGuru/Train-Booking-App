# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

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

+ The result indicates whether the specified bogie ID was found or not found.
+ This use case demonstrates fail-fast validation and safe error handling in Java applications.
