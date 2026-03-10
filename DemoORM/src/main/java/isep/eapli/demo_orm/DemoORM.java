package isep.eapli.demo_orm;

import isep.eapli.demo_orm.application.CarController;
import isep.eapli.demo_orm.application.CarGroupController;
import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.domain.repo.CarRepository;
import isep.eapli.demo_orm.presentation.CarGroupUI;
import isep.eapli.demo_orm.presentation.CarUI;
import isep.eapli.demo_orm.presentation.MainMenu;
public class DemoORM {
    public static void main(String[] args) {

        // Repositories
        CarGroupRepository carGroupRepository = new isep.eapli.demo_orm.persistence.CarGroupRepositoryJPAImpl();
        CarRepository carRepository = new isep.eapli.demo_orm.persistence.CarRepositoryJPAImpl();
        //Controllers
        CarGroupController carGroupController = new CarGroupController(carGroupRepository);
        CarController carController = new CarController(carRepository);
        // UIs
        CarGroupUI carGroupUI = new CarGroupUI(carGroupController);
        CarUI carUI = new CarUI(carController);
        MainMenu mainMenu = new MainMenu(carGroupUI, carUI);


        mainMenu.mainLoop();
    }
}