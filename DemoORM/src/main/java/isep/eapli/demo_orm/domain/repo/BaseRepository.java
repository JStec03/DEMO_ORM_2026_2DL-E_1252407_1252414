package isep.eapli.demo_orm.domain.repo;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {
    T add(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
}
