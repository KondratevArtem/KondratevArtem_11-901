package my.servlet.repositories;

import java.util.List;
import java.util.Optional;

public interface CrubRepository<T> {
    Optional<T> findById(Long id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    void deleteDyId(Long id);
}