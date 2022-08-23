INSERT INTO location (title, subtitle, postal_code) VALUES ('Kraljevica','Ul. Josipa Juraja Strossmayera 5',51262);
INSERT INTO location (title, subtitle, postal_code) VALUES ('Jadranovo','Perhati 22',51264);
INSERT INTO location (title, subtitle, postal_code) VALUES ('Crikvenica','Tina Ujevica',51260);
INSERT INTO location (title, subtitle, postal_code) VALUES ('Krk','Vinogradska ulica',51500);
INSERT INTO location (title, subtitle, postal_code) VALUES ('Malinska','Klarina ul. 922',51511);
INSERT INTO location (title, subtitle, postal_code) VALUES ('Opatija','Ul. Jurja Dobrile 6',51410);



INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Apartment Rose','Luxury apartment','This is one of the best choice to experience life by the sea',
 5, 'APARTMENT',10,'www.randomUrl.com',450,'Raul','www.link1.com','www.link2.com',true,1);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Hostel Krk','Small hostel on the coastline','Come and sea us!',
4,'ROOM',15,'www.randomUrl.com',70,'David ','www.link01.com','www.link92.com',true,4);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Camp Ostro','Camp for everyone','Bring your tent or just reserve a mobile home',
2,'MOBILE_HOME',4,'www.randomUrlCamp.com',30,'Ivana ','www.link0190.com','www.lin89k92.com',false,1);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Hotel Imagination','Imagine having a room','You can have a room, but not in this hotel',
3,'ROOM',2,'www.randomUrlCamp.com',50,'Branimir ','www.link0190.com','www.lin89k92.com',true,1);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Mobile Life','Life on a road','Do you want to travel and sleep, rent with us for a best experience this
summer',
5,'MOBILE_HOME',8,'www.randomUrlM-Life.com',100,'Dragana ','www.link0190.com','www.lin89k92.com',true,5);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Camp Malinska','Regular camp in Malinska','Really its only a camp',
4,'MOBILE_HOME',10,'www.randomUrlMalinska.com',60,'Marko ','www.link0190.com','www.lin89k92.com',false,5);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Hotel Crikvenica','Its a hotel in Crikvenica, right?','Visit us today!',
3,'ROOM',4,'www.randomUrlCRIKVENICA.com',90,'Marin ','www.link0190.com','www.lin89k92.com',true,3);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Apartment Iva','Summer in Opatija','All inclusive',
5,'APARTMENT',12,'www.randomUrlIva.com',200,'Iva ','www.link0190.com','www.lin89k92.com',true,6);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Apartment Nina','Apartments','Exclusive',
3,'APARTMENT',5,'www.randomUrlNINA.com',20,'Nina ','www.link0190.com','www.lin89k92.com',false,2);

INSERT INTO accommodation (title,subtitle,description,categorization,type,person_count,image,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation,location_id)
VALUES ('Apartments Jadranovo','Best you can wish for','I hope',
5,'APARTMENT',15,'www.Jakov.com',150,'Jakov ','www.link0190.com','www.lin89k92.com',true,2);

INSERT INTO reservation (id,type,check_in,check_out,person_count,submitted) VALUES (1,'PERMANENT','2022-08-10',
'2022-08-22', 10, FALSE);
INSERT INTO reservation_history (id,entry_timestamp,from_type,to_type) VALUES (1,'2022-08-09 13:20:54', 'TEMPORARY', 'CANCELED');