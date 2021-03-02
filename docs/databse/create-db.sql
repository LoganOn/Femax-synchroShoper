DROP DATABASE IF EXISTS server_db;
CREATE DATABASE server_db;
CREATE USER IF NOT EXISTS 'server'@'localhost' IDENTIFIED BY 'server';
GRANT ALL PRIVILEGES ON server_db.* TO 'server'@'localhost';
FLUSH PRIVILEGES;

USE server_db;
ALTER DATABASE server_db CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `Tokens` (

    `ApiKeyId` Integer NOT NULL AUTO_INCREMENT,
    `ApiName` VARCHAR (255),
    `ApiKey` VARCHAR (255),
    PRIMARY KEY (`ApiKeyId`)
    );

CREATE TABLE IF NOT EXISTS `DeliveryOrders` (
    `DeliveryOrderId` Integer NOT NULL AUTO_INCREMENT,
    `DocEntry` Varchar(64) NOT NULL,
    `BaseRef` Varchar(64) NOT NULL,
    `UserId` VARCHAR(10) NOT NULL,
    `CreationDate` Timestamp NOT NULL,
    PRIMARY KEY (`DeliveryOrderId`)
    );
#zweryfikowac czy są wszystkie niezbedne pola
CREATE TABLE IF NOT EXISTS `Synchronization` (
    `SynchronizationId` Integer NOT NULL AUTO_INCREMENT,
    `ProductId` Integer,
    `ProducerId` Integer,
    `GroupId` Integer,
    `TaxId` Integer,
    `CategoryId` Integer,
    `OtherPrice` numeric (10,2),
    `PKWIU` Varchar(100),
    `UnitId` Integer,
    `DimensionW` numeric (10,2),
    `DimensionH` numeric (10,2),
    `DimensionL` numeric (10,2),
    `VolWeight` numeric (10,2),
    `CurrencyId` Integer,
    `GaugeId` Integer,
    `Code` Varchar(255),
    `CreationDate` Timestamp NOT NULL,
    `ModifyDate` Timestamp NOT NULL,
    PRIMARY KEY (`SynchronizationId`)
    );

CREATE TABLE IF NOT EXISTS `Emails` (
    `EmailId` Integer NOT NULL AUTO_INCREMENT,
    `Receiver` Varchar(255),
    `DeliveryOrderId` Integer,
    `CreationDate` Timestamp NOT NULL,
    PRIMARY KEY (`EmailId`),
    FOREIGN KEY (`DeliveryOrderId`)
     REFERENCES DeliveryOrders(DeliveryOrderId)
    );

