INSERT INTO calisma.users (first_name,last_name,email) VALUES ('Ramazan1','Guner1','rguner@gmail.com1');
INSERT INTO calisma.users (first_name,last_name,email) VALUES ('Ramazan2','Guner2','rguner@gmail.com2');
INSERT INTO calisma.users (first_name,last_name,email) VALUES ('Ramazan3','Guner3','rguner@gmail.com3');
INSERT INTO calisma.users (first_name,last_name,email) VALUES ('Ramazan4','Guner4','rguner@gmail.com4');
INSERT INTO calisma.users (first_name,last_name,email) VALUES ('Ramazan5','Guner5','rguner@gmail.com5');

INSERT INTO calisma.product (price,title,description) VALUES ('100','Product1','Product Description1');
INSERT INTO calisma.product (price,title,description) VALUES ('200','Product2','Product Description2');
INSERT INTO calisma.product (price,title,description) VALUES ('300','Product3','Product Description3');
INSERT INTO calisma.product (price,title,description) VALUES ('400','Product4','Product Description4');
INSERT INTO calisma.product (price,title,description) VALUES ('500','Product5','Product Description5');



-- created manual by running this sql..
CREATE TYPE calisma."wallet_type" AS ENUM (
    'postpaid',
    'prepaid');


INSERT INTO calisma.wallet (id, "name", "wallet_type") VALUES(nextval('"calisma".wallet_seq'), 'wallet name 2', 'prepaid'::calisma."wallet_type");


INSERT INTO calisma.wallet (id, "name", "wallet_type") VALUES(nextval('"calisma".wallet_seq'), 'wallet name 3', 'postpaid'::calisma."wallet_type");