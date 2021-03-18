package com.service;

import lombok.RequiredArgsConstructor;
import com.model.Tokens;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.commons.codec.Decoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.repository.TokensRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokensService {

    private final TokensRepository tokensRepository;

    private final PasswordEncoder passwordEncoder;

    public Tokens save(Tokens tokens){
        return tokensRepository.save(tokens);
    }

//    public boolean authorization(String apiName, String url, OkHttpClient client, Request request){
//        Optional<Tokens> optionalTokens = tokensRepository.findByApiName(apiName);
//        if(optionalTokens.isEmpty())
//            return false;
//
//        System.out.println(decodeBase64(optionalTokens.get().getApiKey()));
//        request = new Request.Builder().url(url + "/products").header("Authorization", "Bearer " + decodeBase64(optionalTokens.get().getApiKey())).get().build();
//
//        return true;
//    }

    public boolean updateToken(String apiName, String apiKey){
        Optional<Tokens> optionalTokens = tokensRepository.findByApiName(apiName);
        if(optionalTokens.isEmpty())
                return false;
        //optionalTokens.get().setApiKey(encodeBase64(apiKey));
        optionalTokens.get().setApiKey(apiKey);
        tokensRepository.save(optionalTokens.get());
        return true;
    }

    private final static String decodeBase64(String text) {
        return new String(Base64.getDecoder().decode(text.getBytes()));
    }

    private final static String encodeBase64(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}
