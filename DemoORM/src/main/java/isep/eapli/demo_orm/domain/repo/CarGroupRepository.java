package isep.eapli.demo_orm.domain.repo;

import isep.eapli.demo_orm.domain.model.CarGroup;

import java.util.List;

/**
 *
 * @author eapli
 */
public interface CarGroupRepository extends  BaseRepository<CarGroup, Long> {
    List<CarGroup> findByName(String name);
    List<CarGroup> findByDoors(int doors);
        List<CarGroup> findByClass(String carClass);

}
