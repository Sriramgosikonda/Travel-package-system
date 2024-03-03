import java.util.ArrayList;
import java.util.List;

// The Activity class represents a specific activity that can be part of a travel package.

class Activity {
    // Private member variable to store the name of the activity.
    private String name;

    // Public member variable to store the description of the activity.
    public String description;

    // Private member variable to store the cost of the activity.
    private double cost;

    // Private member variable to store the maximum capacity of participants for the
    // activity.
    private int capacity;

    // Private member variable to store the destination associated with the
    // activity.
    private Destination destination;

    // Constructor to initialize the Activity object with provided details.
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    // Getter method to retrieve the name of the activity.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the cost of the activity.
    public double getCost() {
        return cost;
    }

    // Getter method to retrieve the maximum capacity of participants for the
    // activity.
    public int getCapacity() {
        return capacity;
    }

    // Getter method to retrieve the destination associated with the activity.
    public Destination getDestination() {
        return destination;
    }
}

// The Destination class represents a travel destination with a name and a list
// of activities available at that destination.

class Destination {
    // Private member variable to store the name of the destination.
    private String name;

    // Private member variable to store a list of activities associated with the
    // destination.
    private List<Activity> activities;

    // Constructor to initialize a Destination object with the provided name.
    public Destination(String name) {
        this.name = name;

        // Initialize the activities list as an empty ArrayList when creating a new
        // destination.
        this.activities = new ArrayList<>();
    }

    // Getter method to retrieve the name of the destination.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the list of activities associated with the
    // destination.
    public List<Activity> getActivities() {
        return activities;
    }
}

// The Passenger class represents an individual participating in a travel
// package with a name, unique passenger number, balance, passenger type, and
// signed-up activities.

class Passenger {
    // Private member variable to store the name of the passenger.
    private String name;

    // Private member variable to store the unique passenger number.
    private int passengerNumber;

    // Private member variable to store the balance associated with the passenger.
    private double balance;

    // Private member variable to store the type of the passenger (Standard, Gold,
    // Premium).
    private PassengerType type;

    // Private member variable to store a list of activities that the passenger has
    // signed up for.
    private List<Activity> signedUpActivities;

    // Constructor to initialize a Passenger object with the provided name,
    // passenger number, and type.
    public Passenger(String name, int passengerNumber, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;

        // Initialize the signedUpActivities list as an empty ArrayList when creating a
        // new passenger.
        this.signedUpActivities = new ArrayList<>();

        // Set the balance to zero for non-Premium passengers.
        if (type != PassengerType.PREMIUM) {
            this.balance = 0.0;
        }
    }

    // Getter method to retrieve the name of the passenger.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the unique passenger number.
    public int getPassengerNumber() {
        return passengerNumber;
    }

    // Getter method to retrieve the balance associated with the passenger.
    public double getBalance() {
        return balance;
    }

    // Getter method to retrieve the list of signed-up activities for the passenger.
    public List<Activity> getSignedUpActivities() {
        return signedUpActivities;
    }

    // Getter method to retrieve the type of the passenger (Standard, Gold,
    // Premium).
    public PassengerType getType() {
        return type;
    }

    // Method to allow a passenger to sign up for a specific activity.
    public void signUpForActivity(Activity activity) {
        // Implement signing up logic based on passenger type and available balance
        // Update balance, add activity to the signedUpActivities list, etc.
    }
}

// Enumeration defining possible passenger types.
enum PassengerType {
    STANDARD,
    GOLD,
    PREMIUM
}

// The TravelPackage class represents a travel package with a name, passenger
// capacity, list of passengers, and list of destinations.
class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Passenger> passengers;
    private List<Destination> destinations;

    // Constructor to initialize a TravelPackage object with the provided name and
    // passenger capacity.
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }

    // Getter method to retrieve the name of the travel package
    public String getName() {
        return name;
    }

    // Getter method to retrieve the maximum passenger capacity of the travel
    // package.
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    // Getter method to retrieve the list of passengers participating in the travel
    // package.
    public List<Passenger> getPassengers() {
        return passengers;
    }

    // Getter method to retrieve the list of destinations included in the travel
    // package.
    public List<Destination> getDestinations() {
        return destinations;
    }

    // Method to add a destination to the list of destinations for the travel
    // package.
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        // Implement logic to check available capacity and add the passenger
    }

    public static void main(String[] args) {
        // Example usage of the classes and methods
        TravelPackage europeTrip = new TravelPackage("Europe Trip", 50);
        Destination paris = new Destination("Paris");
        Destination rome = new Destination("Rome");

        Activity sightseeingParis = new Activity("Sightseeing", "Explore famous landmarks", 50.0, 30, paris);
        Activity museumVisitParis = new Activity("Museum Visit", "Visit Louvre Museum", 20.0, 20, paris);
        Activity colosseumTour = new Activity("Colosseum Tour", "Guided tour of Colosseum", 30.0, 25, rome);

        paris.getActivities().add(sightseeingParis);
        paris.getActivities().add(museumVisitParis);
        rome.getActivities().add(colosseumTour);

        europeTrip.addDestination(paris);
        europeTrip.addDestination(rome);

        Passenger john = new Passenger("John", 1, PassengerType.STANDARD);
        Passenger alice = new Passenger("Alice", 2, PassengerType.GOLD);
        Passenger bob = new Passenger("Bob", 3, PassengerType.PREMIUM);

        europeTrip.addPassenger(john);
        europeTrip.addPassenger(alice);
        europeTrip.addPassenger(bob);

        john.signUpForActivity(sightseeingParis);
        alice.signUpForActivity(colosseumTour);

        // Print itinerary, passenger list, individual passenger details, and available
        // activities
        printItinerary(europeTrip);
        printPassengerList(europeTrip);
        printPassengerDetails(john);
        // printAvailableActivities(europeTrip);
    }

    private static void printItinerary(TravelPackage travelPackage) {
        System.out.println("Itinerary for " + travelPackage.getName());
        for (Destination destination : travelPackage.getDestinations()) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("  Activity: " + activity.getName() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() +
                        ", Description: " + activity.getDestination().getName());
            }
        }
        System.out.println();
    }

    // Method to print the itinerary of a given TravelPackage, including details
    // about destinations and associated activities.
    private static void printPassengerList(TravelPackage travelPackage) {
        // Print the heading for the itinerary, mentioning the name of the travel
        // package.
        System.out.println("Passenger list for " + travelPackage.getName());
        // Iterate over each destination in the travel package.
        System.out.println("Capacity: " + travelPackage.getPassengerCapacity());
        // Print the name of the destination.
        System.out.println("Number of passengers: " + travelPackage.getPassengers().size());
        // Iterate over each activity within the destination.
        for (Passenger passenger : travelPackage.getPassengers()) {
            // Print details of each activity, including name, cost, capacity, and the
            // destination's name.
            System.out.println("  Passenger: " + passenger.getName() +
                    ", Number: " + passenger.getPassengerNumber());
        }
        System.out.println();
    }

    // Method to print detailed information about a specific Passenger, including
    // their name, number, balance, and signed-up activities.
    private static void printPassengerDetails(Passenger passenger) {
        // Print the heading for the passenger details section, mentioning the name of
        // the passenger.
        System.out.println("Details for passenger " + passenger.getName());
        System.out.println("  Number: " + passenger.getPassengerNumber());
        System.out.println("  Balance: " + passenger.getBalance());
        System.out.println("  Activities:");
        // Iterate over each activity signed up by the passenger.
        for (Activity activity : passenger.getSignedUpActivities()) {
            // Print details of each signed-up activity, including name, destination, and
            // price.
            System.out.println("    Activity: " + activity.getName() +
                    ", Destination: " + activity.getDestination().getName() +
                    ", Price: " + calculatePrice(passenger, activity));
        }
        System.out.println();
    }

    // Method to calculate the price for a Passenger signing up for a specific
    // Activity, considering the Passenger's type.
    private static double calculatePrice(Passenger passenger, Activity activity) {
        if (passenger.getType() == PassengerType.PREMIUM) {
            return 0.0; // Premium passengers sign up for free
        } else if (passenger.getType() == PassengerType.GOLD) {
            return activity.getCost() * 0.9; // 10% discount for gold passengers
        } else {
            return activity.getCost(); // Standard passengers pay the full cost
        }
    }
}
