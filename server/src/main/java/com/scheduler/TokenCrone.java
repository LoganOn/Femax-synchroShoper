package com.scheduler;

import com.service.HttpClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class TokenCrone {

    private final String URL_ARENA = "https://arenalazienek.pl/webapi/rest";

    private final String URL_FEMAX = "https://femax.com.pl/webapi/rest";

    private final HttpClient httpClient;

    @PostConstruct
    public void onStartup(){
        updateToken();
    }

    @Scheduled(cron = "0 0 0 14,28 * ?")
    public void onSchedule(){
        updateToken();
    }


    public void updateToken() {
        try {
            httpClient.setToken(URL_ARENA, "TOKEN_ARENA");
            httpClient.setToken(URL_FEMAX, "TOKEN_FEMAX");
        } catch (IOException e) {
            e.printStackTrace();
            log.warn("Update token error : " + e);
        }
    }
}
