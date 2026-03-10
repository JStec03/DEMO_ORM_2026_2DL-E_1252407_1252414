package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.model.Car;
import isep.eapli.demo_orm.domain.repo.CarRepository;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CarRepositoryJPAImpl
        extends BaseRepositoryJPAImpl<Car, Long>
        implements  CarRepository {
    @Override
    public Optional<Car> findByLicensePlate(String licensePlate) {
        TypedQuery<Car> query = entityManager().createQuery(
                "SELECT c FROM Car c WHERE c.licensePlate = :licensePlate",
                Car.class
        );
        query.setParameter("licensePlate", licensePlate);

        List<Car> result = query.getResultList();

        if (result.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(result.get(0));
    }

    @Override
    public List<Car> findByBrand(String brand) {
        TypedQuery<Car> query = entityManager().createQuery(
                "SELECT c FROM Car c WHERE c.brand = :brand",
                Car.class
        );
        query.setParameter("brand", brand);
        return query.getResultList();
    }


}
