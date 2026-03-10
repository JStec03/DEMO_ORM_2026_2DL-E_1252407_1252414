package isep.eapli.demo_orm.domain.repo;

import isep.eapli.demo_orm.domain.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends  BaseRepository<Car, Long> {
    Optional<Car> findByLicensePlate(String licensePlate);
    List<Car> findByBrand(String brand);
}
