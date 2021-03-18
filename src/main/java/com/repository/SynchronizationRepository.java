package com.repository;

import com.model.Synchronization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SynchronizationRepository extends CrudRepository<Synchronization, Long> {
}
