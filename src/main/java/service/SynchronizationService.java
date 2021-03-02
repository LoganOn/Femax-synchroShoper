package service;

import lombok.RequiredArgsConstructor;
import model.Synchronization;
import org.springframework.stereotype.Service;
import repository.SynchronizationRepository;

@Service
@RequiredArgsConstructor
public class SynchronizationService {

    private final SynchronizationRepository synchronizationRepository;

    public Synchronization save(Synchronization synchronization){
        return synchronizationRepository.save(synchronization);
    }
}
