package com.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class HttpClient {

    private final TokensService tokensService;

    private RequestBody formBody;

    private Request request;

    private ResponseBody responseBody;

    private OkHttpClient client;

    public void setToken(String url, String name) throws IOException {
        client = (new OkHttpClient.Builder()).authenticator((route, response) -> {
            if (response.request().header("Authorization") != null)
                return null;
            return response.request().newBuilder().header("Authorization", Credentials.basic("Synchronizacja", "#Synchronizacja1")).build();
        }).build();
        formBody = (new FormBody.Builder()).build();
        request = (new Request.Builder()).url(url + "/auth").post(this.formBody).build();
        responseBody = client.newCall(request).execute().body();
        if (tokensService.updateToken(name, responseBody.string().split(",")[0].replace("{\"access_token\":\"", "").replace("\"", "")))
            log.info("Success update tokens");
        else
            log.warn("Update token failed");
        responseBody.close();
    }

    public boolean changeStatus(String url, String token, String orderId, String status) {
        client = new OkHttpClient();
        request = (new Request.Builder()).url(url + "/orders/" + orderId).header("Authorization", "Bearer " + token).put(RequestBody.create(MediaType.parse("application/json"), "{\"status_id\": " + status + " }")).build();
        try {
            responseBody = client.newCall(request).execute().body();
            if (responseBody.string().equals("1")) {
                //log.info(responseBody.string());
                log.info("Success update orders : " + orderId);
            }
            else {
                //log.warn(responseBody.string());
                log.warn("Failed update orders : " + orderId);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
