package repository;

import model.Tokens;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokensRepository extends CrudRepository<Tokens, Long> {
}
