package model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Tokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApiKeyId")
    private Long apiKeyId;

    @Column(name = "ApiName")
    private String apiName;

    @Column(name = "ApiKey")
    private String apiKey;
}
