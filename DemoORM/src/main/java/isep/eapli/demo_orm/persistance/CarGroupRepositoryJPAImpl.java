package isep.eapli.demo_orm.persistance;

import isep.eapli.demo_orm.domain.CarGroup;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


/**
 *
 * @author eapli
 */
public class CarGroupRepositoryJPAImpl implements CarGroupRepository {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("DEMO_ORMPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    /**
     * inserts an entity GrupoAutomovel
     *
     * @param carGroup
     * @return the persisted entity
     */
    @Override
    public CarGroup add(CarGroup carGroup) {
        /*
          Finish implementation
        **/
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    /**
     * reads an entity GrupoAutomovel given its ID
     *
     * @param id
     * @return
     */
    @Override
    public CarGroup findById(Long id) {
        return getEntityManager().find(CarGroup.class, id);
    }

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    @Override
    public List<CarGroup> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM CarGroup e");
        List<CarGroup> list = query.getResultList();
        return list;
    }

}
