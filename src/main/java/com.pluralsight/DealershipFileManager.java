package com.pluralsight;


import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {

        String fileName = "inventory.csv";
        try {
            // Ensure the file exists – create a blank one if needed.
            File inputFile = new File(fileName);
            if (inputFile.createNewFile()) {
                System.out.println("Created new data file: " + fileName);
            }

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line = reader.readLine();
            String[] fields = line.split("\\|");
            String name = fields[0];
            String address = fields[1];
            String phone = fields[2];
            Dealership firstDealership = new Dealership(name, address, phone);


            while ((line = reader.readLine()) != null) {
                fields = line.split("\\|");             // 8 parts expected
                int vin = Integer.parseInt(fields[0]);
                int year = Integer.parseInt(fields[1]);
                String make = fields[2];
                String model = fields[3];
                String vehicleType = fields[4];
                String vehicleColor = fields[5];
                int odometer = Integer.parseInt(fields[6]);
                double price = Double.parseDouble(fields[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, vehicleColor, odometer, price);
                firstDealership.addVehicle(vehicle);

            }
            reader.close();
            return firstDealership;
        } catch (IOException ioException) {
            System.out.println("Error reading data file: " + ioException.getMessage());
            return null;
        }

    }

    public void saveDealership(Dealership dealership) {

        String fileName = "inventory.csv";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            writer.write(String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone()));

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(String.format("\n%s|%s|%s|%s|%s|%s|%s|%.2f",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e);
        }
    }

}