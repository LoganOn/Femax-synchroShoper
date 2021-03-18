package com.service;

import lombok.RequiredArgsConstructor;
import com.model.Emails;
import org.springframework.stereotype.Service;
import com.repository.EmailsRepository;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailsRepository emailsRepository;

    public Emails save(Emails emails){
        return emailsRepository.save(emails);
    }
}
