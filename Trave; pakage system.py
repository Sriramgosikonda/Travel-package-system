import tkinter as tk
from tkinter import scrolledtext

class Activity:
    def __init__(self, name, description, cost, capacity, destination):
        self._name = name
        self.description = description
        self._cost = cost
        self._capacity = capacity
        self._destination = destination

    @property
    def name(self):
        return self._name

    @property
    def cost(self):
        return self._cost

    @property
    def capacity(self):
        return self._capacity

    @property
    def destination(self):
        return self._destination


class Destination:
    def __init__(self, name):
        self._name = name
        self._activities = []

    @property
    def name(self):
        return self._name

    @property
    def activities(self):
        return self._activities

    def add_activity(self, activity):
        self._activities.append(activity)


class PassengerType:
    STANDARD = "Standard"
    GOLD = "Gold"
    PREMIUM = "Premium"


class Passenger:
    def __init__(self, name, passenger_number, passenger_type):
        self._name = name
        self._passenger_number = passenger_number
        self._type = passenger_type
        self._signed_up_activities = []
        self._balance = 0.0 if passenger_type != PassengerType.PREMIUM else None

    @property
    def name(self):
        return self._name

    @property
    def passenger_number(self):
        return self._passenger_number

    @property
    def balance(self):
        return self._balance

    @property
    def signed_up_activities(self):
        return self._signed_up_activities

    @property
    def type(self):
        return self._type

    def sign_up_for_activity(self, activity):
        # Implement signing up logic based on passenger type and available balance
        self._signed_up_activities.append(activity)


class TravelPackage:
    def __init__(self, name, passenger_capacity):
        self._name = name
        self._passenger_capacity = passenger_capacity
        self._passengers = []
        self._destinations = []

    @property
    def name(self):
        return self._name

    @property
    def passenger_capacity(self):
        return self._passenger_capacity

    @property
    def passengers(self):
        return self._passengers

    @property
    def destinations(self):
        return self._destinations

    def add_destination(self, destination):
        self._destinations.append(destination)

    def add_passenger(self, passenger):
        if len(self._passengers) < self._passenger_capacity:
            self._passengers.append(passenger)
        else:
            print("No more capacity for additional passengers")

    @staticmethod
    def print_itinerary(travel_package):
        root = tk.Tk()
        root.title("Itinerary")
        text_area = scrolledtext.ScrolledText(root, wrap=tk.WORD, width=50, height=20)
        text_area.grid(column=0, pady=10, padx=10)
        
        text_area.insert(tk.INSERT, f"Itinerary for {travel_package.name}\n")
        for destination in travel_package.destinations:
            text_area.insert(tk.INSERT, f"Destination: {destination.name}\n")
            for activity in destination.activities:
                text_area.insert(tk.INSERT, f"  Activity: {activity.name}, Cost: {activity.cost}, "
                                            f"Capacity: {activity.capacity}, Description: {activity.description}\n")
        
        text_area.config(state=tk.DISABLED)
        root.mainloop()

    @staticmethod
    def print_passenger_list(travel_package):
        root = tk.Tk()
        root.title("Passenger List")
        text_area = scrolledtext.ScrolledText(root, wrap=tk.WORD, width=50, height=20)
        text_area.grid(column=0, pady=10, padx=10)
        
        text_area.insert(tk.INSERT, f"Passenger list for {travel_package.name}\n")
        text_area.insert(tk.INSERT, f"Capacity: {travel_package.passenger_capacity}\n")
        text_area.insert(tk.INSERT, f"Number of passengers: {len(travel_package.passengers)}\n")
        for passenger in travel_package.passengers:
            text_area.insert(tk.INSERT, f"  Passenger: {passenger.name}, Number: {passenger.passenger_number}\n")
        
        text_area.config(state=tk.DISABLED)
        root.mainloop()

    @staticmethod
    def print_passenger_details(passenger):
        root = tk.Tk()
        root.title(f"Passenger Details - {passenger.name}")
        text_area = scrolledtext.ScrolledText(root, wrap=tk.WORD, width=50, height=20)
        text_area.grid(column=0, pady=10, padx=10)
        
        text_area.insert(tk.INSERT, f"Details for passenger {passenger.name}\n")
        text_area.insert(tk.INSERT, f"  Number: {passenger.passenger_number}\n")
        text_area.insert(tk.INSERT, f"  Balance: {passenger.balance}\n")
        text_area.insert(tk.INSERT, "  Activities:\n")
        for activity in passenger.signed_up_activities:
            price = TravelPackage.calculate_price(passenger, activity)
            text_area.insert(tk.INSERT, f"    Activity: {activity.name}, Destination: {activity.destination.name}, Price: {price}\n")
        
        text_area.config(state=tk.DISABLED)
        root.mainloop()

    @staticmethod
    def calculate_price(passenger, activity):
        if passenger.type == PassengerType.PREMIUM:
            return 0.0  # Premium passengers sign up for free
        elif passenger.type == PassengerType.GOLD:
            return activity.cost * 0.9  # 10% discount for gold passengers
        else:
            return activity.cost  # Standard passengers pay the full cost


# Example usage of the classes and methods
if __name__ == "__main__":
    europe_trip = TravelPackage("Europe Trip", 50)
    paris = Destination("Paris")
    rome = Destination("Rome")

    sightseeing_paris = Activity("Sightseeing", "Explore famous landmarks", 50.0, 30, paris)
    museum_visit_paris = Activity("Museum Visit", "Visit Louvre Museum", 20.0, 20, paris)
    colosseum_tour = Activity("Colosseum Tour", "Guided tour of Colosseum", 30.0, 25, rome)

    paris.add_activity(sightseeing_paris)
    paris.add_activity(museum_visit_paris)
    rome.add_activity(colosseum_tour)

    europe_trip.add_destination(paris)
    europe_trip.add_destination(rome)

    john = Passenger("John", 1, PassengerType.STANDARD)
    alice = Passenger("Alice", 2, PassengerType.GOLD)
    bob = Passenger("Bob", 3, PassengerType.PREMIUM)

    europe_trip.add_passenger(john)
    europe_trip.add_passenger(alice)
    europe_trip.add_passenger(bob)

    john.sign_up_for_activity(sightseeing_paris)
    alice.sign_up_for_activity(colosseum_tour)

    TravelPackage.print_itinerary(europe_trip)
    TravelPackage.print_passenger_list(europe_trip)
    TravelPackage.print_passenger_details(john)
