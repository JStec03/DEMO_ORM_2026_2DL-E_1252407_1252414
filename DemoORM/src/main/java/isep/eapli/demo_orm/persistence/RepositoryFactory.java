package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.domain.repo.CarRepository;
import isep.eapli.demo_orm.domain.repo.RentalContractRepository;

public class RepositoryFactory {
    public CarGroupRepository createCarGroupRepository() {
        return new CarGroupRepositoryJPAImpl();
    }
    public CarRepository createCarRepository() {
        return new CarRepositoryJPAImpl();
    }

    public RentalContractRepository createRentalContractsRepository() {
        return new RentalContractRepositoryJPAImpl();
    }

        public ClientRepositoryJPAImpl createClientRepository() {
            return new ClientRepositoryJPAImpl();
        }
}
