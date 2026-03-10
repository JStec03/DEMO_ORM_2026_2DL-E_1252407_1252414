package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.CarGroup;
import isep.eapli.demo_orm.persistance.CarGroupRepository;
import java.util.List;

/**
 *
 * @author eapli
 */
public class CarGroupController {

    public CarGroup registerCarGroup(String nome, int portas,
                                     String classe) {

        CarGroup grupo1 = new CarGroup(nome, portas, classe);
        CarGroupRepository repo = new isep.eapli.demo_orm.persistance.CarGroupRepositoryJPAImpl();
        return repo.add(grupo1);
    }
    
    public List<CarGroup> listCarGroups() {
		throw new UnsupportedOperationException("Ainda não implementada");
	}

	public CarGroup searchCarGroup(long id) {
		throw new UnsupportedOperationException("Ainda não implementada");
	}

}
