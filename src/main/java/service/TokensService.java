package service;

import lombok.RequiredArgsConstructor;
import model.Tokens;
import org.springframework.stereotype.Service;
import repository.TokensRepository;

@Service
@RequiredArgsConstructor
public class TokensService {

    private final TokensRepository tokensRepository;

    public Tokens save(Tokens tokens){
        return tokensRepository.save(tokens);
    }

    public boolean authorization(String apiName, String apiKey){
        return false;
    }
}
