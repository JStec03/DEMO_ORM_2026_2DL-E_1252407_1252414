package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.CarGroup;
import isep.eapli.demo_orm.persistence.CarGroupRepository;
import isep.eapli.demo_orm.persistence.CarGroupRepositoryJPAImpl;

import java.util.List;

/**
 *
 * @author eapli
 */
public class CarGroupController {

    public CarGroup registerCarGroup(String nome, int portas,
                                     String classe) {
        CarGroup grupo1 = new CarGroup(nome, portas, classe);
        CarGroupRepository repo = new isep.eapli.demo_orm.persistence.CarGroupRepositoryJPAImpl();
        return repo.add(grupo1);
    }
    
    public List<CarGroup> listCarGroups() {
		CarGroupRepository repo = new CarGroupRepositoryJPAImpl();
        return repo.findAll();
	}

	public CarGroup searchCarGroup(long id) {
		CarGroupRepository repo = new CarGroupRepositoryJPAImpl();
        return repo.findById(id);
	}

}
