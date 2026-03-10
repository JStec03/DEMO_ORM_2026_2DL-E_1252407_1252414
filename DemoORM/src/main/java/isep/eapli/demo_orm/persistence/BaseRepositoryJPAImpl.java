package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.repo.BaseRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;


public  abstract  class BaseRepositoryJPAImpl<T, ID>  implements BaseRepository<T, ID> {

    @PersistenceUnit
    private static EntityManagerFactory emFactory;
    private final Class<T> entityClass;
    private EntityManager _entityManager;

    protected EntityManagerFactory entityManagerFactory() {
        if (emFactory == null) {
            emFactory = Persistence
                    .createEntityManagerFactory(persistenceUnitName());
        }
        return emFactory;
    }

    @SuppressWarnings("unchecked")
    public BaseRepositoryJPAImpl() {
        ParameterizedType genericSuperclass
                = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass
                = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected EntityManager entityManager() {
        if (_entityManager == null || !_entityManager.isOpen()) {
            _entityManager = entityManagerFactory().createEntityManager();
        }
        return _entityManager;
    }

    /**
     * inserts an entity and commits
     *
     * @param entity
     * @return the persisted entity
     */
    public T add(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = entityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();

        return entity;
    }

    /**
     * reads an entity given its ID
     *
     * @param id
     * @return
     */
    public Optional<T> findById(ID id) {
        T var =  this.entityManager().find(entityClass, id);
        return Optional.ofNullable(var);
    }

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    //@SuppressWarnings("unchecked")
    public List<T> findAll() {
        Query query = entityManager().createQuery(
                "SELECT e FROM " + entityClass.getSimpleName() + " e");
        List<T> list = query.getResultList();
        return list;
    }

    /**
     * derived classes should implement this method to return the name of the
     * persistence unit
     *
     * @return the name of the persistence unit
     */
    protected  String persistenceUnitName(){return "DEMO_ORM";}
}
