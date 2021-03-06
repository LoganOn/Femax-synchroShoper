package repository;

import model.Emails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailsRepository extends CrudRepository<Emails, Long> {
}
