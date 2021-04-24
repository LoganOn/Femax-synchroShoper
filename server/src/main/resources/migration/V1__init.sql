CREATE TABLE IF NOT EXISTS Tokens (

    ApiKeyId Integer NOT NULL AUTO_INCREMENT,
    ApiName VARCHAR (255),
    ApiKey VARCHAR (255),
    PRIMARY KEY (`ApiKeyId`)
    );

INSERT INTO Tokens
(ApiName, ApiKey)
VALUES
( 'TOKEN_SAP', '$2y$12$Y7kuwjovx4Jweiliu4mbrOylnDD0mX7ybfXjaJduL2vimflhXsnZu'),
( 'TOKEN_ARENA', '$2y$12$MVfbLuJ.tukNsoysbCfs9uSxdpZMJMH6d4Iv6QMYw7umVr17EpL3G'),
( 'TOKEN_FEMAX', '$2y$12$VKRnH1h.LNhifBBsFvs6Ze5lIQZh9JQp/MU4v8IrokvrBj78Ecu42');

CREATE TABLE IF NOT EXISTS DeliveryOrders (
    DeliveryOrderId BIGINT NOT NULL AUTO_INCREMENT,
    ShoperOrderId Varchar(64) NOT NULL,
    BaseRef Varchar(64) NOT NULL,
    UserId VARCHAR(10) NOT NULL,
    CreationDate Timestamp NOT NULL,
    PRIMARY KEY (DeliveryOrderId)
    );

CREATE TABLE IF NOT EXISTS Synchronization (
    SynchronizationId BIGINT NOT NULL AUTO_INCREMENT,
    ProductId BIGINT,
    ProducerId BIGINT,
    GroupId BIGINT,
    TaxId BIGINT,
    CategoryId BIGINT,
    OtherPrice numeric (10,2),
    PKWIU Varchar(100),
    UnitId BIGINT,
    DimensionW numeric (10,2),
    DimensionH numeric (10,2),
    DimensionL numeric (10,2),
    VolWeight numeric (10,2),
    CurrencyId BIGINT,
    GaugeId BIGINT,
    Code Varchar(255),
    CreationDate Timestamp NOT NULL,
    ModifyDate Timestamp NOT NULL,
    PRIMARY KEY (SynchronizationId)
    );


