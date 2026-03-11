package isep.eapli.demo_orm.application;


import isep.eapli.demo_orm.domain.model.*;
import isep.eapli.demo_orm.domain.repo.CarRepository;
import isep.eapli.demo_orm.domain.repo.ClientRepository;
import isep.eapli.demo_orm.domain.repo.RentalContractRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RentalContractController {

    private final RentalContractRepository rentalContractRepo;
    private final CarRepository carRepo;
    private final ClientRepository clientRepo;

    public RentalContractController(RentalContractRepository rentalContractRepo,
                                    CarRepository carRepo,
                                    ClientRepository clientRepo) {
        this.rentalContractRepo = rentalContractRepo;
        this.carRepo = carRepo;
        this.clientRepo = clientRepo;
    }

    public RentalContract registerRentalContract(Long clientId, Long carId,
                                                 LocalDate startDate, LocalDate endDate,
                                                 List<AuthorizedDriver> drivers, Payment payment) {
        Optional<Client> clientOpt = clientRepo.findById(clientId);
        Optional<Car> carOpt = carRepo.findById(carId);

        if (clientOpt.isEmpty()) {
            throw new IllegalArgumentException("Client not found.");
        }

        if (carOpt.isEmpty()) {
            throw new IllegalArgumentException("Car not found.");
        }

        RentalContract contract = new RentalContract(
                clientOpt.get(),
                carOpt.get(),
                startDate,
                endDate,
                payment
        );

        for (AuthorizedDriver driver : drivers) {
            contract.addAuthorizedDriver(driver);
        }

        return rentalContractRepo.add(contract);
    }

    public List<RentalContract> listRentalContracts() {
        return rentalContractRepo.findAll();
    }

    public Optional<RentalContract> searchRentalContractById(Long id) {
        return rentalContractRepo.findById(id);
    }
}