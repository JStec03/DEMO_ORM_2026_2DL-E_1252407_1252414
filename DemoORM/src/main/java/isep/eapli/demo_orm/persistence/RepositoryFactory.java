package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.domain.repo.CarRepository;

public class RepositoryFactory {
    public CarGroupRepository createCarGroupRepository() {
        return new CarGroupRepositoryJPAImpl();
    }
    public CarRepository createCarRepository() {
        return new CarRepositoryJPAImpl();
    }
}
