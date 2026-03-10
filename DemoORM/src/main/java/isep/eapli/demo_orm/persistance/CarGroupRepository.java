package isep.eapli.demo_orm.persistance;

import isep.eapli.demo_orm.domain.CarGroup;
import java.util.List;

/**
 *
 * @author eapli
 */
public interface CarGroupRepository {

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public CarGroup add(CarGroup entity);

    /**
     * reads an entity given its ID
     *
     * @param id
     * @return
     */
    public CarGroup findById(Long id);

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    public List<CarGroup> findAll();
}
