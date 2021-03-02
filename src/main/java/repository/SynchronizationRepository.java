package repository;

import model.Synchronization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SynchronizationRepository extends CrudRepository<Synchronization, Long> {
}
