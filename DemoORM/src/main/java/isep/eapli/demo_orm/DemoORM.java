package isep.eapli.demo_orm;

import isep.eapli.demo_orm.application.CarController;
import isep.eapli.demo_orm.application.CarGroupController;
import isep.eapli.demo_orm.application.RentalContractController;
import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.domain.repo.CarRepository;
import isep.eapli.demo_orm.domain.repo.ClientRepository;
import isep.eapli.demo_orm.domain.repo.RentalContractRepository;
import isep.eapli.demo_orm.persistence.RepositoryFactory;
import isep.eapli.demo_orm.presentation.CarGroupUI;
import isep.eapli.demo_orm.presentation.CarUI;
import isep.eapli.demo_orm.presentation.MainMenu;
import isep.eapli.demo_orm.presentation.RentalContractUI;

public class DemoORM {
    public static void main(String[] args) {

        // Repositories
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        CarGroupRepository carGroupRepository = repositoryFactory.createCarGroupRepository();
        CarRepository carRepository = repositoryFactory.createCarRepository();
        RentalContractRepository rentalContractRepository = repositoryFactory.createRentalContractsRepository();
        ClientRepository clientRepository = repositoryFactory.createClientRepository();
        //Controllers
        CarGroupController carGroupController = new CarGroupController(carGroupRepository);
        CarController carController = new CarController(carRepository, carGroupRepository);
        RentalContractController rentalContractController  = new RentalContractController(rentalContractRepository, carRepository, clientRepository);
        // UIs
        CarGroupUI carGroupUI = new CarGroupUI(carGroupController);
        CarUI carUI = new CarUI(carController);
        RentalContractUI rentalContractUI = new RentalContractUI(rentalContractController);
        MainMenu mainMenu = new MainMenu(carGroupUI, carUI, rentalContractUI);


        mainMenu.mainLoop();
    }
}