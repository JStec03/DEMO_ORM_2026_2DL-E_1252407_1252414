package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.domain.model.CarGroup;
import isep.eapli.demo_orm.util.Console;
import isep.eapli.demo_orm.application.CarGroupController;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mcn
 */
public class CarGroupUI {

    private final  CarGroupController controller;
    public CarGroupUI(CarGroupController controller) {
        this.controller = controller;
    }

    public void registerCG() {
        System.out.println("*** Registo Grupo Automóvel ***\n");
        String nome = Console.readLine("Nome:");
        int portas = Console.readInteger("Número de portas");
        String classe = Console.readLine("Classe:");
        CarGroup carGroup = controller.
                registerCarGroup(nome, portas, classe);
        System.out.println("Grupo Automóvel" + carGroup);
    }
    public void listGAs() {
        System.out.println("*** Car Groups List ***\n");
        List<CarGroup> list = controller.listCarGroups();

        if(list.isEmpty()) {
            System.out.println("No registered car groups.");
        } else {
            for(CarGroup cg : list) {
                System.out.println(cg);
            }
        }
	}

	public void searchCarGroupById(){
        Long id;
        try{
            id = Long.valueOf(Console.readLine("ID:"));
        } catch(NumberFormatException e){
            System.out.println("Invalid ID format.");
            return;
        }
        Optional<CarGroup> carGroup = controller.searchCarGroupById(id);
        if (carGroup != null) {
            System.out.println("Car Group found: " + carGroup);
        } else {
            System.out.println("No Car Group found with ID: " + id);
        }
    }

    public void searchCarGroupByName(){
        String name = Console.readLine("Name:");
        List<CarGroup> carGroup = controller.searchCarGroupByName(name);
        if (carGroup != null) {
            for(CarGroup cg : carGroup) {
                System.out.println("Car Group found: " + cg);
            }
        } else {
            System.out.println("No Car Group found with name: " + name);
        }
    }

    public void searchCarGroupByDoors(){
        int doors;
        try{
            doors = Console.readInteger("Number of doors:");
        } catch(NumberFormatException e){
            System.out.println("Invalid number format.");
            return;
        }
        List<CarGroup> carGroup = controller.searchCarGroupByDoors(doors);
        if (carGroup != null) {
            for(CarGroup cg : carGroup) {
                System.out.println("Car Group found: " + cg);
            }
        } else {
            System.out.println("No Car Group found with " + doors + " doors.");
        }
    }

    public void searchCarGroupByClass(){
        String carClass = Console.readLine("Car class:");
        List<CarGroup> carGroup = controller.searchCarGroupByClass(carClass);
        if (carGroup != null) {
            for(CarGroup cg : carGroup) {
                System.out.println("Car Group found: " + cg);
            }
        } else {
            System.out.println("No Car Group found with class: " + carClass);
        }
    }


}
