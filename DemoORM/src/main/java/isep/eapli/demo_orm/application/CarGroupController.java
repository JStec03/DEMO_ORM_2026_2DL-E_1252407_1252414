package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.model.CarGroup;
import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import isep.eapli.demo_orm.persistence.CarGroupRepositoryJPAImpl;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author eapli
 */
public class CarGroupController {
    private final CarGroupRepository repo;

    public CarGroupController(CarGroupRepository repo) {
        this.repo = repo;
    }

    public CarGroup registerCarGroup(String nome, int portas,
                                     String classe) {
        CarGroup grupo1 = new CarGroup(nome, portas, classe);
        return repo.add(grupo1);
    }
    
    public List<CarGroup> listCarGroups() {
        return  repo.findAll();

	}

	public Optional<CarGroup> searchCarGroupById(Long id) {
        return repo.findById(id);
    }

    public List<CarGroup> searchCarGroupByName(String name) {
        return repo.findByName(name);
    }

    public List<CarGroup> searchCarGroupByDoors(int doors) {
        return repo.findByDoors(doors);
    }

    public List<CarGroup> searchCarGroupByClass(String carClass) {
        return repo.findByClass(carClass);
    }

}
