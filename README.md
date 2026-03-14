# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

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
