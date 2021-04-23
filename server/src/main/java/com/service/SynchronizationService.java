package com.service;

import lombok.RequiredArgsConstructor;
import com.model.Synchronization;
import org.springframework.stereotype.Service;
import com.repository.SynchronizationRepository;

@Service
@RequiredArgsConstructor
public class SynchronizationService {

    private final SynchronizationRepository synchronizationRepository;

    public Synchronization save(Synchronization synchronization){
        return synchronizationRepository.save(synchronization);
    }
}
