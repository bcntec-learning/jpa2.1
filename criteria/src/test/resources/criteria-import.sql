INSERT INTO PUBLIC.country (id,name) VALUES('UG','UGANDA');
INSERT INTO PUBLIC.country (id,name) VALUES('UA','UKRAINE');
INSERT INTO PUBLIC.country (id,name) VALUES('AE','UNITED ARAB EMIRATES');
INSERT INTO PUBLIC.country (id,name) VALUES('GB','UNITED KINGDOM');
INSERT INTO PUBLIC.country (id,name) VALUES('US','UNITED STATES');
INSERT INTO PUBLIC.country (id,name) VALUES('UM','UNITED STATES MINOR OUTLYING ISLANDS');
INSERT INTO PUBLIC.country (id,name) VALUES('UY','URUGUAY');
INSERT INTO PUBLIC.country (id,name) VALUES('UZ','UZBEKISTAN');
INSERT INTO PUBLIC.country (id,name) VALUES('VU','VANUATU');
INSERT INTO PUBLIC.country (id,name) VALUES('VA','VATICAN CITY STATE (HOLY SEE)');
INSERT INTO PUBLIC.country (id,name) VALUES('VE','VENEZUELA');
INSERT INTO PUBLIC.country (id,name) VALUES('VN','VIET NAM');
INSERT INTO PUBLIC.country (id,name) VALUES('VG','VIRGIN ISLANDS (BRITISH)');
INSERT INTO PUBLIC.country (id,name) VALUES('VI','VIRGIN ISLANDS (U.S.)');
INSERT INTO PUBLIC.country (id,name) VALUES('WF','WALLIS AND FUTUNA ISLANDS');
INSERT INTO PUBLIC.country (id,name) VALUES('EH','WESTERN SAHARA');
INSERT INTO PUBLIC.country (id,name) VALUES('YE','YEMEN');
INSERT INTO PUBLIC.country (id,name) VALUES('ZM','ZAMBIA');
INSERT INTO PUBLIC.country (id,name) VALUES('ZW','ZIMBABWE');


INSERT INTO PUBLIC.company (id,name, country_id) VALUES('A1','APPLE','YE');
INSERT INTO PUBLIC.company (id,name, country_id) VALUES('B1','BCNTEC','YE');
INSERT INTO PUBLIC.company (id,name, country_id) VALUES('A2','IBM','ZM');
INSERT INTO PUBLIC.company (id,name, country_id) VALUES('B2','SETTING','ZM');

INSERT INTO PUBLIC.company (id,name, country_id) VALUES('C1','CORTE INGLES','UZ');
INSERT INTO PUBLIC.company (id,name, country_id) VALUES('C2','ZARA','UZ');
INSERT INTO PUBLIC.company (id,name, country_id) VALUES('C3','FNAC','UZ');


INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('AAAA1','JOBS','A1',55);
INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('AAAA2','COOK','A1',56);
INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('AAAA3','JOBS JR','A1',16);

INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('BBBB1','FRANCISCO','B1',55);
INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('BBBB2','MATEO','B1',3);

INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('CCCC1','ORTEGA','C1',70);
INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('CCCC2','NN1','C1',15);
INSERT INTO PUBLIC.employee (id,name, company_id, age) VALUES('CCCC3','NN2','C2',15);