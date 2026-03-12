package main;
/**
 * UC7:
 *  - Create a simple Bogie class (name + capacity).
 *  - Store passenger bogies in a List<Bogie>.
 *  - Sort them by capacity using Comparator.comparingInt(...).
 *  - Print BEFORE and AFTER sorting for clarity.
 *@author Shrivatsa Guru
 *@version 7.0
 */
public class TrainMain {

    static class Bogie {
        // Fields (data we store for each bogie)
        String name;
        int capacity; // number of seats

        // Constructor: runs when we write "new Bogie(name, capacity)"
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        // Getters (handy if we want method references later)
        String getName()     { return name; }
        int    getCapacity() { return capacity; }
        // toString() helps print a bogie nicely
        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        // ===== UC7: Sort passenger bogies by capacity (Comparator) =====
        // 1) Create a list of Bogie objects (with name and capacity).
        java.util.List<Bogie> passengerBogies = new java.util.ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        // 2) Sort by capacity (ascending) using Comparator.comparingInt(...)
        passengerBogies.sort(java.util.Comparator.comparingInt(b -> b.capacity));

        // 3) Show the list AFTER sorting.
        System.out.println("\nUC7: Passenger bogies AFTER sorting by capacity (ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b.name + " - " + b.capacity + " seats");
        }

    }
}