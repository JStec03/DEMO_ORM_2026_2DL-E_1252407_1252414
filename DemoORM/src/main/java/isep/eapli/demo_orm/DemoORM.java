package isep.eapli.demo_orm;

import isep.eapli.demo_orm.application.CarGroupController;
import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.presentation.CarGroupUI;
import isep.eapli.demo_orm.presentation.MainMenu;
public class DemoORM {
    public static void main(String[] args) {
        CarGroupRepository carGroupRepository = new isep.eapli.demo_orm.persistence.CarGroupRepositoryJPAImpl();
        CarGroupController carGroupController = new CarGroupController(carGroupRepository);
        CarGroupUI carGroupUI = new CarGroupUI(carGroupController);
        MainMenu mainMenu = new MainMenu(carGroupUI);
        mainMenu.mainLoop();
    }
}