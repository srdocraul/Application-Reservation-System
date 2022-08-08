INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (1,'Apartment Rose','Luxury apartment','This is one of the best choice to experience life by the sea', 5, 'APARTMENT',10,'www.randomUrl.com',450,'Raul','www.link1.com','www.link2.com',true);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (2,'Hostel Krk','Small hostel on the coastline','Come and sea us!',
4,
'ROOM',15,'www.randomUrl.com',70,'David ','www.link01.com','www.link92.com',true);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (3,'Camp Ostro','Camp for everyone','Bring your tent or just reserve a mobile home',
2,'MOBILE_HOME',4,'www.randomUrlCamp.com',30,'Ivana ','www.link0190.com','www.lin89k92.com',false);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (4,'Hotel Imagination','Imagine having a room','You can have a room, but not in this hotel',
3,'ROOM',2,'www.randomUrlCamp.com',50,'Branimir ','www.link0190.com','www.lin89k92.com',true);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (5,'Mobile Life','Life on a road','Do you want to travel and sleep, rent with us for a best experience this
summer',
5,'MOBILE_HOME',8,'www.randomUrlM-Life.com',100,'Dragana ','www.link0190.com','www.lin89k92.com',true);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (6,'Camp Malinska','Regular camp in Malinska','Really its only a camp',
4,'MOBILE_HOME',10,'www.randomUrlMalinska.com',60,'Marko ','www.link0190.com','www.lin89k92.com',false);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (7,'Hotel Crikvenica','Its a hotel in Crikvenica, right?','Visit us today!',
3,'ROOM',4,'www.randomUrlCRIKVENICA.com',90,'Marin ','www.link0190.com','www.lin89k92.com',true);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (8,'Apartment Iva','Summer in Opatija','All inclusive',
5,'APARTMENT',12,'www.randomUrlIva.com',200,'Iva ','www.link0190.com','www.lin89k92.com',true);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (9,'Apartment Nina','Apartments','Exclusive',
3,'APARTMENT',5,'www.randomUrlNINA.com',20,'Nina ','www.link0190.com','www.lin89k92.com',false);
INSERT INTO accommodation (id,title,subtitle,description,categorization,type,person_count,image_url,price,
owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (10,'Apartments Jadranovo','Best you can wish for','I hope',
5,'APARTMENT',15,'www.Jakov.com',150,'Jakov ','www.link0190.com','www.lin89k92.com',true);

INSERT INTO reservation (id,type,check_in,check_out,person_count,submitted) VALUES (1,'PERMANENT','2022-08-10','2022-08-22', 10, FALSE);

INSERT INTO reservation_history (id,entry_timestamp,from_type,to_type) VALUES (1,'2022-08-09 13:20:54', 'TEMPORARY', 'CANCELED');

INSERT INTO location (id,title, subtitle, postal_code,accommodation_id) VALUES (1,'Kraljevica','Ul. Josipa Juraja
Strossmayera',51262,1);