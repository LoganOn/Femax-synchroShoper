package com.repository;

import com.model.Tokens;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokensRepository extends CrudRepository<Tokens, Long> {

    Optional<Tokens> findByApiName(String apiName);
}
