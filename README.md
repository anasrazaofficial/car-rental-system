# Car Rental System

## Overview

This repository contains the code for a Car Rental System. The system includes functionalities for managing car rentals,
including handling owners, customers, vehicles, and bookings. It calculates the total price for a rental and the owner's
commission based on the commission percentage. The application is built using Java, Swing for the graphical user
interface, and SQL for database management.

## Database Schema

### Owner

- **name**: VARCHAR
- **cnic**: VARCHAR
- **phone**: VARCHAR
- **address**: VARCHAR
- **commissionPercent**: INT
- **totalCommission**: INT

### Customer

- **name**: VARCHAR
- **phone**: VARCHAR
- **cnic**: VARCHAR
- **address**: VARCHAR

### Vehicle

- **name**: VARCHAR
- **color**: VARCHAR
- **status**: VARCHAR
- **pricePerDay**: INT
- **ownerId**: INT (Foreign Key referencing Customer)

### Booking

- **customerId**: INT (Foreign Key referencing Customer)
- **vehicleId**: INT (Foreign Key referencing Vehicle)
- **startDate**: DATE
- **completeDate**: DATE
- **totalDays**: INT
- **totalPrice**: INT
- **status**: VARCHAR

## Features

- **Owner Management**: Add and manage owners, including their commission percentages.
- **Customer Management**: Add and manage customers.
- **Vehicle Management**: Add and manage vehicles, including their price per day.
- **Booking Management**: Create bookings with a start date, customer ID, and vehicle ID. Calculate the total price and
  owner's commission upon booking completion.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/anasrazaofficial/car-rental-system.git
    ```
2. Navigate to the project directory:
    ```bash
    cd car-rental-system
    ```
3. Set up the SQL database:
    - Create a database named `car_rental_system`.
    - Run the provided SQL scripts in the `sql` directory to create the necessary tables.
4. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
5. Configure your database credentials in DBConnection. You can do this by either creating a config.properties file with
   your database details or directly replacing the placeholder values with your own credentials.
6. Build and run the project.

## Usage

1. Launch the application from your IDE.
2. Use the graphical user interface to manage owners, customers, vehicles, and bookings.
3. Create new bookings and complete them to see the calculations for total price and owner's commission.