# TrainConsistManagementApp

The Train Consist Management App is a console-based Java application that simulates how a railway system manages a train’s consist, which is a collection of bogies attached to an engine.  The application supports: 1. Passenger bogies (Sleeper,AC Chair,First Class) with seat capacity tracking. 2. Goods bogies with cargo type and safety constraints.

## UC11: Validate Train ID & Cargo Codes (Regex)

+ This module demonstrates input validation using Regular Expressions (Regex) in Java.
+ The program accepts Train ID and Cargo Code inputs from the user using the Scanner class.
+ The expected format for Train ID is TRN-1234, where the last four characters are digits.
+ The expected format for Cargo Code is PET-AB, where the last two characters are uppercase letters.
+ The matches() method is used to validate the input against predefined regex patterns.
+ Regex pattern TRN-\\d{4} ensures the Train ID follows the required numeric format.
+ Regex pattern PET-[A-Z]{2} ensures the Cargo Code contains two uppercase letters.
+ The program displays whether each input is valid or invalid based on pattern matching.
+ This use case demonstrates data validation using Java Regular Expressions and user input handling.
