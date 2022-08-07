INSERT INTO location (id,title, subtitle, postal_code) VALUES (1,'Kraljevica','Ul. Josipa Juraja Strossmayera',51262);
INSERT INTO accommodations (id,title,subtitle,description,categorization,type,person_count,image_url,price,owner_name,link_for_facebook,link_for_instagram,free_cancellation)
VALUES (1,'Apartment Rose','Luxury apartment','This is one of the best choice to experience life by the sea', 5,
'APARTMENT',10,'www.randomUrl.com',450,'Raul','www.link1.com','www.link2.com',true);
INSERT INTO reservation (id,type,check_in,check_out,person_count,submitted) VALUES (1,'PERMANENT','2022-08-10','2022-08-22', 10, FALSE);
INSERT INTO reservation_history (id,entry_timestamp,from_type,to_type) VALUES (1,'2022-08-09 13:20:54', 'TEMPORARY', 'CANCELED');