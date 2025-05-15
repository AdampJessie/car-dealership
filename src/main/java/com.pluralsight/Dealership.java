package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name, address, phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if (vehicle.getPrice()>=min && vehicle.getPrice()<=max)
                results.add(vehicle);

        return results;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model))
                results.add(vehicle);

        return results;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if (vehicle.getYear()>=min && vehicle.getYear()<=max)
                results.add(vehicle);

        return results;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if (vehicle.getColor().equalsIgnoreCase(color))
                results.add(vehicle);

        return results;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if (vehicle.getOdometer()>=min && vehicle.getOdometer()<=max)
                results.add(vehicle);

        return results;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){

        ArrayList<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory)
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                results.add(vehicle);

        return results;
    }
    public ArrayList<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){

        boolean unique = true;
        for (Vehicle i : inventory)
            if (vehicle.getVin() == i.getVin()) {
                unique = false;
                break;
            }
        if (unique) inventory.add(vehicle);


    }
    public void removeVehicle(Vehicle vehicle){

        inventory.removeIf(i -> vehicle.getVin() == i.getVin());

    }




}
