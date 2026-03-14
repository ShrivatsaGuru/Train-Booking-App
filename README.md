# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

## UC12: Safety Compliance Check for Goods Bogies

+ This module demonstrates safety rule validation for goods bogies using Java Streams.
+ Each GoodsBogie object contains attributes such as bogie type and cargo type.
+ A list of goods bogies is created using List.of().
+ The program first displays all goods bogies along with their cargo details.
+ The list is converted into a stream using the stream() method.
+ A safety rule is applied to check invalid combinations of bogie type and cargo.
+ The allMatch() method verifies whether all bogies satisfy the safety condition.
+ If any unsafe combination is found, the system flags a safety compliance warning.
+ This use case demonstrates real-world rule validation using Java Streams and functional programming concepts.
