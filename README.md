# {{TRAVEL PACKAGE SYSTEM}}

{{Description of your project. Provide a brief overview of what the travel package system does and its key features.}}

## Features

- **Travel Packages:** Create and manage travel packages with destinations, activities, and passenger details.
- **Passenger Types:** Support for different passenger types (Standard, Gold, Premium) with varying privileges.
- **Activity Sign-up:** Passengers can sign up for activities within the travel packages.


## Classes

- **Activity:** Represents an activity within a destination.
- **Destination:** Represents a destination in a travel package.
- **TravelPackage:** Represents a travel package with destinations and passengers.
- **Passenger:** Base class for different types of passengers.
- **StandardPassenger:** Subclass representing a standard passenger.
- **GoldPassenger:** Subclass representing a gold passenger.
- **PremiumPassenger:** Subclass representing a premium passenger.

### Class Descriptions

#### Activity

The `Activity` class represents an activity available within a destination. It includes properties such as name, description, cost, and capacity. Passengers can sign up for these activities.

#### Destination

The `Destination` class represents a specific location within a travel package. It contains a list of activities available at that destination.

#### TravelPackage

The `TravelPackage` class represents an entire travel package, comprising multiple destinations and managing the list of passengers. It also calculates charges based on passenger sign-ups for activities.

#### Passenger

The `Passenger` class serves as the base class for different types of passengers. It includes common attributes like name and passenger number.

#### StandardPassenger

The `StandardPassenger` subclass extends the `Passenger` class, representing passengers with a balance. They pay the full cost of activities, deducting from their balance.

#### GoldPassenger

The `GoldPassenger` subclass extends the `Passenger` class and provides a 10% discount on activity
