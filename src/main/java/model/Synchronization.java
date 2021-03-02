package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Synchronization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SynchronizationId")
    private Long synchronizationId;

    @Column(name = "ProductId")
    private Long productId;

    @Column(name = "ProducerId")
    private Long producerId;

    @Column(name = "GroupId")
    private Long groupId;

    @Column(name = "TaxId")
    private Long taxId;

    @Column(name = "CategoryId")
    private Long categoryId;

    @Column(name = "OtherPrice")
    private double otherPrice;

    @Column(name = "PKWIU", length = 100)
    private String pKWIU;

    @Column(name = "Code")
    private String code;

    @Column(name = "UnitId")
    private Long unitId;

    @Column(name = "DimensionW")
    private double dimensionW;

    @Column(name = "DimensionH")
    private double dimensionH;

    @Column(name = "DimensionL")
    private double dimensionL;

    @Column(name = "VolWeight")
    private double volWeight;

    @Column(name = "GaugeId")
    private Long gaugeId;

    @Column(name = "CurrencyId")
    private Long currencyId;

    @Column(name = "CreationDate")
    private Long creationDate;
}
