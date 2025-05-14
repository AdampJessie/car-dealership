import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface() {}

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        boolean displaying = true;
        while (displaying) {
            displayMenu();
            int userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                case 9:
                case 99:
                    displaying = false;
                    break;

            }
            scanner.close();
        }

    }
    private void init(){
        DealershipFileManager loader = new DealershipFileManager();
        this.dealership = loader.getDealership();
    }
    public void processGetByPriceRequest() {}
    public void processGetByMakeModelRequest() {}
    public void processGetByYearRequest() {}
    public void processGetByColorRequest() {}
    public void processGetByMileageRequest() {}
    public void processGetByVehicleTypeRequest() {}
    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}

    private void displayMenu(){
        System.out.print("""
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
                Please select an option:\s""");

    }
    private void displayVehicles(ArrayList<Vehicle> inventory){

        System.out.println("=".repeat(140));
        for (Vehicle i : inventory) {
            System.out.println(i);
        }


    }


}
