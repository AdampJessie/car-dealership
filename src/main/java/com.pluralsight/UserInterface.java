package com.pluralsight;


import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface() {
    }

    public void display() {
        init();
        Scanner userInput = new Scanner(System.in);
        boolean displaying = true;
        while (displaying) {
            displayMenu();
            int choice = Integer.parseInt(userInput.nextLine().trim());
            System.out.println("-".repeat(50));

            switch (choice) {
                case 1:
                    try {
                        processGetByPriceRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 2:
                    try {
                        processGetByMakeModelRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 3:
                    try {
                        processGetByYearRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 4:
                    try {
                        processGetByColorRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 5:
                    try {
                        processGetByMileageRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 6:
                    try {
                        processGetByVehicleTypeRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 7:
                    try {
                        processGetAllVehiclesRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 8:
                    try {
                        processAddVehicleRequest();
                    } catch (Exception e) {
                        System.out.println("-".repeat(50));
                        System.out.println("Error, invalid input! Please try again.");
                    }
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    exitSave();
                    displaying = false;
                    break;
            }
        }
        userInput.close();
    }

    private void init() {
        DealershipFileManager loader = new DealershipFileManager();
        this.dealership = loader.getDealership();
    }

    private void exitSave() {
        DealershipFileManager saver = new DealershipFileManager();
        saver.saveDealership(this.dealership);
    }

    public void processGetByPriceRequest() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter a minimum price to search for: ");
        double min = Double.parseDouble(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        System.out.print("Please enter a maximum price to search for: ");
        double max = Double.parseDouble(userInput.nextLine().trim());

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the make to search for: ");
        String make = userInput.nextLine().trim();
        System.out.println("-".repeat(50));
        System.out.print("Please enter the model to search for: ");
        String model = userInput.nextLine().trim();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));


    }

    public void processGetByYearRequest() {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter a minimum year to search for: ");
        int min = Integer.parseInt(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        System.out.print("Please enter a maximum year to search for: ");
        int max = Integer.parseInt(userInput.nextLine().trim());

        displayVehicles(dealership.getVehiclesByYear(min, max));


    }

    public void processGetByColorRequest() {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the color to search for: ");
        String color = userInput.nextLine().trim();


        displayVehicles(dealership.getVehiclesByColor(color));


    }

    public void processGetByMileageRequest() {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter a minimum mileage to search for: ");
        int min = Integer.parseInt(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        System.out.print("Please enter a maximum mileage to search for: ");
        int max = Integer.parseInt(userInput.nextLine().trim());

        displayVehicles(dealership.getVehiclesByMileage(min, max));


    }

    public void processGetByVehicleTypeRequest() {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the vehicle type to search for: ");
        String type = userInput.nextLine().trim();

        displayVehicles(dealership.getVehiclesByType(type));

    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the price of the vehicle: ");
        double price = Double.parseDouble(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        System.out.print("Please enter the make of the vehicle: ");
        String make = userInput.nextLine().trim();
        System.out.println("-".repeat(50));
        System.out.print("Please enter the model of the vehicle: ");
        String model = userInput.nextLine().trim();
        System.out.println("-".repeat(50));
        System.out.print("Please enter the type of the vehicle: ");
        String vehicleType = userInput.nextLine().trim();
        System.out.println("-".repeat(50));
        System.out.print("Please enter the year of the vehicle: ");
        int year = Integer.parseInt(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        System.out.print("Please enter the color of the vehicle: ");
        String color = userInput.nextLine().trim();
        System.out.println("-".repeat(50));
        System.out.print("Please enter the mileage of the vehicle: ");
        int odometer = Integer.parseInt(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        System.out.print("Please enter the unique VIN belonging to the vehicle: ");
        int vin = Integer.parseInt(userInput.nextLine().trim());
        System.out.println("-".repeat(50));

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.inventory.add(newVehicle);
        if (dealership.inventory.contains(newVehicle))
            System.out.println("Success! Vehicle added.");
        else System.out.println("Something went wrong! Vehicle not added.");

    }

    public void processRemoveVehicleRequest() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please enter the VIN to remove a vehicle: ");
        int vin = Integer.parseInt(userInput.nextLine().trim());
        System.out.println("-".repeat(50));
        Vehicle selectedVehicle = null;

        for (Vehicle vehicle : dealership.inventory)
            if (vehicle.getVin() == vin)
                selectedVehicle = vehicle;
        dealership.removeVehicle(selectedVehicle);
        if (!dealership.inventory.contains(selectedVehicle))
            System.out.println("Success! Vehicle removed.");
        else System.out.println("Something went wrong! Vehicle not removed.");
    }

    private void displayMenu() {
        System.out.printf("""
                +---------------------------------------------------+
                |\t\t\t%-40s|
                +---------------------------------------------------+
                | 1 - Find vehicles within a price range            |
                | 2 - Find vehicles by make / model                 |
                | 3 - Find vehicles by year range                   |
                | 4 - Find vehicles by color                        |
                | 5 - Find vehicles by mileage range                |
                | 6 - Find vehicles by type (car, truck, SUV, van)  |
                | 7 - List ALL vehicles                             |
                | 8 - Add a vehicle                                 |
                | 9 - Remove a vehicle                              |
                | 99 - Quit                                         |
                +---------------------------------------------------+
                Please select an option:\s""", "Welcome to " + dealership.getName() + "!");

    }

    private void displayVehicles(ArrayList<Vehicle> inventory) {

        System.out.println("=".repeat(140));
        if (!inventory.isEmpty())
            for (Vehicle i : inventory)
                System.out.println(i);
        else System.out.println("No vehicles to display!");
    }
}
