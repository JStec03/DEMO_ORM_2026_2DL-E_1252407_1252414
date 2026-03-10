package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.model.CarGroup;
import java.util.List;

import isep.eapli.demo_orm.domain.repo.CarGroupRepository;
import jakarta.persistence.*;


/**
 *
 * @author eapli
 */
public class CarGroupRepositoryJPAImpl
        extends BaseRepositoryJPAImpl< CarGroup, Long>
        implements CarGroupRepository {


    @Override
    public List<CarGroup> findByName(String name) {
        TypedQuery<CarGroup> query = entityManager().createQuery(
                "SELECT cg FROM CarGroup cg WHERE cg.name = :name",
                CarGroup.class
        );
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<CarGroup> findByDoors(int doors) {
        TypedQuery<CarGroup> query = entityManager().createQuery(
                "SELECT cg FROM CarGroup cg WHERE cg.doors = :doors",
                CarGroup.class
        );
        query.setParameter("doors", doors);
        return query.getResultList();
    }

    @Override
    public List<CarGroup> findByClass(String carClass) {
        TypedQuery<CarGroup> query = entityManager().createQuery(
                "SELECT cg FROM CarGroup cg WHERE cg.carClass = :carClass",
                CarGroup.class
        );
        query.setParameter("carClass", carClass);
        return query.getResultList();
    }




}
