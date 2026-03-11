package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.model.Car;
import isep.eapli.demo_orm.domain.model.CarGroup;
import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.domain.repo.CarRepository;

import java.util.List;
import java.util.Optional;

public class CarController {
    private final CarRepository repo;
    private final CarGroupRepository carGroupRepo;
    public CarController(CarRepository repo, CarGroupRepository carGroupRepo) {
        this.repo = repo;
        this.carGroupRepo = carGroupRepo;
    }

    public List<Car> searchCarByBrand(String brand) {
        return repo.findByBrand(brand);
    }

    public Optional<Car> searchCarByLicensePlate(String licensePlate) {
        return repo.findByLicensePlate(licensePlate);
    }

    public  void registerCar(String licensePlate, String brand, String model, String color, Long groupId) {
        Optional<CarGroup> carGroup = carGroupRepo.findById(groupId);
        if (!carGroup.isPresent()) {
            throw new IllegalArgumentException("Car group with ID " + groupId + " not found.");
        }
        Car car = new Car(
                brand,
                model,
                licensePlate,
                color,
                carGroup.get()
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
