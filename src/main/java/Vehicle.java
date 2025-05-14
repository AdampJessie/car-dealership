public class Vehicle {
    private String make, model, vehicleType, color;
    private int vin, year, odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    @Override
    public String toString() {
        String stringVehicle = String.format("| Make: %s | Model: %s | Vehicle Type: %s | Color: %s | VIN: %s | Year: %s | Odometer: %s | Price: %s |",
                make, model, vehicleType, color, vin, year, odometer, price);
        String stringBorder = "+" + "-".repeat(stringVehicle.length()-2) + "+";

        return stringVehicle + "\n" + stringBorder;
    }
}
