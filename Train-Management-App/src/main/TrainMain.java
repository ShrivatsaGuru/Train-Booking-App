package main;
/**
 * UC1: Initialize Train and Display Consist Summary
 * -------------------------------------------------
 * What this program does (UC1 only):
 * 1) Prints a welcome message to the console.
 * 2) Initializes an EMPTY train consist using an ArrayList (a dynamic list).
 * 3) Displays the initial bogie count (which should be 0 because the list is empty).
 * @author Shrivatsa Guru
 * @version 1.0
 */
public class TrainMain {

    public static void main(String[] args) {
        // 1) Print a welcome banner.
        System.out.println("=== Train Consist Management App ===");
        // 2) Initialize an EMPTY train consist.
        
        java.util.List<String> trainConsist = new java.util.ArrayList<>();
        
        // 3) Display the initial bogie count using size().
        System.out.println("Initial bogie count: " + trainConsist.size());
        
        System.out.print("Current train consists: ");
        System.out.println(trainConsist);
    }
}