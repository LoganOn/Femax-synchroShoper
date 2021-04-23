package com.controller;

import com.exception.BadRequestException;
import com.exception.UnathorizedClient;
import com.model.DeliveryOrders;
import com.model.Tokens;
import com.repository.TokensRepository;
import com.service.DeliveryOrdersService;
import com.service.HttpClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/delivery", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Slf4j
public class DeliveryOrdersController {

    private final String ORDERID_IS_EMPTY = "Order id cant be empty";

    private final String TOKEN_NOT_EXIST = "Wrong token";

    private final String URL_ARENA = "https://arenalazienek.pl/webapi/rest";

    private final String URL_FEMAX = "https://femax.com.pl/webapi/rest";

    private final String TOKEN_ARENA = "TOKEN_ARENA";

    private final String TOKEN_FEMAX = "TOKEN_FEMAX";

    private final String TOKEN_SAP = "TOKEN_SAP";

    private final TokensRepository tokensRepository;

    private final PasswordEncoder passwordEncoder;

    private final DeliveryOrdersService deliveryOrdersService;

    private final HttpClient httpClient;

    @PostMapping
    public ResponseEntity<?> addDetailsDeliveryOrders(@RequestParam(required = true) String apiKey, @RequestParam(required = true) String user, @RequestParam(required = true) String shoperOrderId,
                                                      @RequestParam(required = true) String baseRef, @RequestParam(required = true) String status) throws IOException {
        List<Integer> id = new ArrayList<Integer>();
        Optional<Tokens> sapToken = tokensRepository.findByApiName(TOKEN_SAP);
        Optional<Tokens> tokensOptional;
        String url;
        String[] str = shoperOrderId.replaceAll("\\s", "").split(":");

        if (passwordEncoder.matches(apiKey, sapToken.get().getApiKey())) {
            if (!shoperOrderId.isEmpty()) {
                tokensOptional = (!str[1].isEmpty() && str[1].startsWith("1")) ? tokensRepository.findByApiName(TOKEN_ARENA) : tokensRepository.findByApiName(TOKEN_FEMAX);
                url = (!str[1].isEmpty() && str[1].startsWith("1")) ? URL_ARENA: URL_FEMAX;
                if(httpClient.changeStatus(url, tokensOptional.get().getApiKey(), str[1], status)) {
                    deliveryOrdersService.save(new DeliveryOrders(shoperOrderId, baseRef, user));
                }
                else
                    //TODO repeter
                    log.warn("We need REPETER");
            } else
                throw new BadRequestException(ORDERID_IS_EMPTY);
        } else
            throw new UnathorizedClient(TOKEN_NOT_EXIST);
        return new ResponseEntity<>(
                id, id == null ?
                HttpStatus.NOT_FOUND : id.isEmpty() ?
                HttpStatus.NO_CONTENT : HttpStatus.OK
        );
    }
}
