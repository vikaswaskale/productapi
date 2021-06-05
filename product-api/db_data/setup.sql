
create table PRODUCTS
(
    id               INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    productId        TEXT,
    productName      TEXT,
    sortCode         TEXT,
    accountNumber    TEXT,
    currentBalance   DECIMAL(19,2),
    availableBalance DECIMAL(19,2)
);

insert into PRODUCTS values (1, 'SA001', 'SAVING A/C', '11-22-11', '012345671', 10000.59, 10000.00);
insert into PRODUCTS values (2, 'CA002', 'CURRENT A/C', '11-22-11', '012345672', 102.00, 102.00);
insert into PRODUCTS values (3, 'PL003', 'PERSONAL LOAN', '11-22-11', '012345673', 10000.00, 10000.00);
insert into PRODUCTS values (4, 'CI004', 'CAR INSURANCE', '11-22-11', '012345674', 100.00, 100.00);
insert into PRODUCTS values (5, 'HM005', 'HOME MORTAGE', '11-22-11', '012345675', 10000000.00, 10000000.00);

create table TRANSACTIONS
(
    id               INT NOT NULL PRIMARY KEY,
    productId        TEXT,
    dateOn           date,
    debitCredit      TEXT,
    transDescription TEXT,
    details          TEXT,
    amount           DECIMAL(19,2)
);

/** TRANSACTION SA001 **/
insert into TRANSACTIONS values (1, 'SA001', '2019-01-01', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (2, 'SA001', '2019-01-01', 'DR', 'MORRISON Shopping', 'Trans at MORRISON Livingston', 10020.20);
insert into TRANSACTIONS values (3, 'SA001', '2019-02-11', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (4, 'SA001', '2019-01-22', 'DR', 'MORRISON Shopping', 'Trans at MORRISON Livingston', 1010.20);
insert into TRANSACTIONS values (5, 'SA001', '2019-01-22', 'CR', 'PRET Shopping', 'Trans at PRET Livingston', 100.20);
insert into TRANSACTIONS values (6, 'SA001', '2019-02-12', 'DR', 'ASDA Shopping', 'Trans at ADSA Livingston', 1001.20);
insert into TRANSACTIONS values (7, 'SA001', '2019-03-11', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (8, 'SA001', '2019-12-11', 'DR', 'PRET Shopping', 'Trans at PRET Livingston', 1000.00);
insert into TRANSACTIONS values (9, 'SA001', '2019-03-11', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (10, 'SA001', '2019-02-15', 'CR', 'SHELL Shopping', 'Trans at SHELL Livingston', 10010.20);
insert into TRANSACTIONS values (11, 'SA001', '2019-02-16', 'DR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10011.20);
insert into TRANSACTIONS values (12, 'SA001', '2019-02-17', 'CR', 'BBQ Shopping', 'Trans at BBQ Livingston', 10010.20);
insert into TRANSACTIONS values (13, 'SA001', '2019-02-15', 'CR', 'BNM Shopping', 'Trans at BNM Livingston', 10030.20);
insert into TRANSACTIONS values (14, 'SA001', '2019-07-11', 'DR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (15, 'SA001', '2019-07-11', 'CR', 'SPORTS Shopping', 'Trans at SPORTS Livingston', 10010.24);
insert into TRANSACTIONS values (16, 'SA001', '2019-11-11', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.40);
insert into TRANSACTIONS values (17, 'SA001', '2019-04-18', 'DR', 'COSTA Shopping', 'Trans at COSTA Livingston', 40010.20);
insert into TRANSACTIONS values (18, 'SA001', '2019-06-19', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (19, 'SA001', '2019-08-11', 'DR', 'PRET Shopping', 'Trans at PRET Livingston', 10010.20);
insert into TRANSACTIONS values (20, 'SA001', '2019-07-21', 'CR', 'RAIL Shopping', 'Trans at RAIL Livingston', 15010.20);

/** TRANSACTION CA002 **/
insert into TRANSACTIONS values (21, 'CA002', '2019-01-01', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (22, 'CA002', '2019-02-01', 'DR', 'MORRISON Shopping', 'Trans at MORRISON Livingston', 10020.20);
insert into TRANSACTIONS values (23, 'CA002', '2019-03-11', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (24, 'CA002', '2019-03-12', 'DR', 'MORRISON Shopping', 'Trans at MORRISON Livingston', 1010.20);
insert into TRANSACTIONS values (25, 'CA002', '2019-03-14', 'CR', 'PRET Shopping', 'Trans at PRET Livingston', 100.20);
insert into TRANSACTIONS values (26, 'CA002', '2019-02-21', 'DR', 'ASDA Shopping', 'Trans at ADSA Livingston', 1001.20);
insert into TRANSACTIONS values (27, 'CA002', '2019-02-22', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (28, 'CA002', '2019-02-22', 'DR', 'PRET Shopping', 'Trans at PRET Livingston', 1000.00);
insert into TRANSACTIONS values (29, 'CA002', '2019-01-12', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (30, 'CA002', '2019-02-13', 'CR', 'SHELL Shopping', 'Trans at SHELL Livingston', 10010.20);
insert into TRANSACTIONS values (31, 'CA002', '2019-01-30', 'DR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10011.20);
insert into TRANSACTIONS values (32, 'CA002', '2019-12-12', 'CR', 'BBQ Shopping', 'Trans at BBQ Livingston', 10010.20);
insert into TRANSACTIONS values (33, 'CA002', '2019-11-22', 'CR', 'BNM Shopping', 'Trans at BNM Livingston', 10030.20);
insert into TRANSACTIONS values (34, 'CA002', '2019-06-08', 'DR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (35, 'CA002', '2019-03-09', 'CR', 'SPORTS Shopping', 'Trans at SPORTS Livingston', 10010.24);
insert into TRANSACTIONS values (36, 'CA002', '2019-07-02', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.40);
insert into TRANSACTIONS values (37, 'CA002', '2019-08-01', 'DR', 'COSTA Shopping', 'Trans at COSTA Livingston', 40010.20);
insert into TRANSACTIONS values (38, 'CA002', '2019-02-22', 'CR', 'ASDA Shopping', 'Trans at ADSA Livingston', 10010.20);
insert into TRANSACTIONS values (39, 'CA002', '2019-01-13', 'DR', 'PRET Shopping', 'Trans at PRET Livingston', 10010.20);
insert into TRANSACTIONS values (40, 'CA002', '2019-01-15', 'CR', 'RAIL Shopping', 'Trans at RAIL Livingston', 15010.20);
