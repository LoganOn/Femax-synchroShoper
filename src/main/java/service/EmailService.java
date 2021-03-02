package service;

import lombok.RequiredArgsConstructor;
import model.Emails;
import org.springframework.stereotype.Service;
import repository.EmailsRepository;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailsRepository emailsRepository;

    public Emails save(Emails emails){
        return emailsRepository.save(emails);
    }
}
