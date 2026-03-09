package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.domain.CarGroup;
import isep.eapli.demo_orm.util.Console;

import java.util.List;

/**
 *
 * @author mcn
 */
public class CarGroupUI {

    private final isep.eapli.demo_orm.application.CarGroupController controller = new isep.eapli.demo_orm.application.CarGroupController();
    
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

	public void searchGAPorID(long id) {
        System.out.println("*** Searching for group with id: " + id + " ***\n");
        CarGroup carGroup = controller.searchCarGroup(id);

        if(carGroup != null) {
            System.out.println("Found: " + carGroup);
        } else {
            System.out.println("Car group with given id not found.");
        }
	}
}
