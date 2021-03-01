package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DeliveryOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeliveryOrderId")
    private Long deliveryOrderId;

    @Column(name = "DocEntry", length = 64)
    private String docEntry;

    @Column(name = "BaseRef", length = 64)
    private String baseRef;

    @Column(name = "UserId", length = 10)
    private String userId;

    @Column(name = "CreationDate")
    private Timestamp creationDate;
}
