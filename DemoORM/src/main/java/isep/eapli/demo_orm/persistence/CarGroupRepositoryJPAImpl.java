package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.CarGroup;
import java.util.List;

import jakarta.persistence.*;


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
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(carGroup);
            tx.commit();
        } catch (Exception e) {
            if(tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
        return carGroup;
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
