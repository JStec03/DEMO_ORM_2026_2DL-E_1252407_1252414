package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.model.Car;
import isep.eapli.demo_orm.domain.repo.CarRepository;

import java.util.List;
import java.util.Optional;

public class CarController {
    private final CarRepository repo;
    public CarController(CarRepository repo) {
        this.repo = repo;
    }

    public List<Car> searchCarByBrand(String brand) {
        return repo.findByBrand(brand);
    }

    public Optional<Car> searchCarByLicensePlate(String licensePlate) {
        return repo.findByLicensePlate(licensePlate);
    }

    public  void registerCar(String licensePlate, String brand, String model, String color) {
        Car car = new Car(
                brand,
                model,
                licensePlate,
                color
        );
        repo.add(car);
    }

    public List<Car> listAllCars() {
        return repo.findAll();
    }

    public Optional<Car> searchCarById(Long id) {
        return repo.findById(id);
    }


}
