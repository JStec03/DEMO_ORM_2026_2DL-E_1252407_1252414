package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.application.CarController;
import isep.eapli.demo_orm.domain.model.Car;
import isep.eapli.demo_orm.util.Console;

import java.util.List;
import java.util.Optional;

public class CarUI {
    private final CarController controller;
    public CarUI(CarController carController) {
        this.controller = carController;
    }

    public void registerCar() {
        System.out.println("*** Car Registration ***\n");

        String licensePlate = Console.readLine("License plate:");
        String brand = Console.readLine("Brand:");
        String model = Console.readLine("Model:");
        String color = Console.readLine("Color:");
        String groupIdStr = Console.readLine("Car group ID:");

        controller.registerCar(licensePlate, brand, model, color, Long.valueOf(groupIdStr));
        System.out.println("Car registered successfully.");
    }

    public void listCars() {
        System.out.println("*** Cars List ***\n");

        List<Car> list = controller.listAllCars();

        if (list.isEmpty()) {
            System.out.println("No registered cars.");
        } else {
            for (Car car : list) {
                System.out.println(car);
            }
        }
    }

    public void searchCarById() {
        Long id;

        try {
            id = Long.valueOf(Console.readLine("ID:"));
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
            return;
        }

        Optional<Car> car = controller.searchCarById(id);

        if (car.isPresent()) {
            System.out.println("Car found: " + car.get());
        } else {
            System.out.println("No car found with ID: " + id);
        }
    }

    public void searchCarByBrand() {
        String brand = Console.readLine("Brand:");

        List<Car> cars = controller.searchCarByBrand(brand);

        if (cars.isEmpty()) {
            System.out.println("No cars found with brand: " + brand);
        } else {
            for (Car car : cars) {
                System.out.println("Car found: " + car);
            }
        }
    }

    public void searchCarByLicensePlate() {
        String licensePlate = Console.readLine("License plate:");

        Optional<Car> car = controller.searchCarByLicensePlate(licensePlate);

        if (car.isPresent()) {
            System.out.println("Car found: " + car.get());
        } else {
            System.out.println("No car found with license plate: " + licensePlate);
        }
    }
}
