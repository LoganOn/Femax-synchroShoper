package com.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Emails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmailId")
    private Long emailId;

    @Column(name = "Receiver")
    private String receiver;

    @Column(name = "DeliveryOrderId")
    private Long deliveryOrderId;

    @Column(name = "CreationDate")
    private Timestamp creationDate;
}
