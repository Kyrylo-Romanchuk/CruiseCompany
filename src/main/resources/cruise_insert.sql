
insert into cruise.user values(1,"admin","admin1", "Admin" , "Admin", "admin@gmail.com", "ADMIN" , "2019-01-01 22:36:54");
insert into cruise.user values(2,"user1","user1", "Oleh" , "Kovalenko", "user1@gmail.com", "USER" , "2019-01-01 22:36:54");
insert into cruise.user values(3,"user2","user2", "Olexandr" , "Marchenko", "user2@gmail.com", "USER" , "2019-01-01 22:36:54");
insert into cruise.user values(4,"user3","user3", "Dima" , "Gumenuk", "user3@gmail.com", "USER" , "2019-01-01 22:36:54");

insert into cruise.country values( 0,'','');
UPDATE `country` SET country_id = 0 WHERE country_id = 1;
insert into cruise.country values( 1,"Finland", "Helsinki");
insert into cruise.country values( 2,"Denmark", "Copengagen");
insert into cruise.country values( 3,"Ukraine", "Odessa");
insert into cruise.country values( 4,"Turkey", "Islamabad");
insert into cruise.country values( 5,"Spain", "La Línea de la Concepción");
insert into cruise.country values( 6,"Sweeden", "Stockholm");
insert into cruise.country values( 7,"Belgium", "Antwerpen");
insert into cruise.country values( 8,"Germany", "Hamburg");
insert into cruise.country values( 9,"Netherlands", "Amsterdam");
insert into cruise.country values( 10,"Netherlands" , "Rotterdam");
insert into cruise.country values( 11,"Norway", "Oslo");
insert into cruise.country values( 12,"France", "Nance");
insert into cruise.country values( 13,"France", "Marcel");
insert into cruise.country values( 14,"Italy", "Genoa");

insert into cruise.ship values( 1,"Titanic", 2500);
insert into cruise.ship values( 2,"Oasis of the Seas", 2200);
insert into cruise.ship values( 3,"Queen Elizabeth", 1500);
insert into cruise.ship values( 4,"Freedom of the Seas", 3000);
insert into cruise.ship values( 5,"Celebrity Reflection", 2000);
insert into cruise.ship values( 6,"Celebrity Silhouette", 1800);

insert into cruise.shipimage values( 1,"http://i63.tinypic.com/2rc2y3m.jpg", 1);
insert into cruise.shipimage values( 2,"http://i63.tinypic.com/bjh7qu.jpg", 2);
insert into cruise.shipimage values( 3,"http://i68.tinypic.com/v4udjd.jpg", 3);
insert into cruise.shipimage values( 4,"http://i64.tinypic.com/14wgo8.jpg", 4);
insert into cruise.shipimage values( 5,"http://i67.tinypic.com/2e2dlpw.jpg", 5);
insert into cruise.shipimage values( 6,"http://i68.tinypic.com/2nm3950.jpg", 6);

insert into cruise.excursion values( 0,0, '' , '', 0);
UPDATE `excursion` SET excursion_id = 0 WHERE excursion_id = 1;
insert into cruise.excursion values( 1,1, "Tallinn Day Cruise from Helsinki" , "Discover picturesque Tallinn, Estonia’s capital, on a small-group day trip from Helsinki by ferry..." , 235);
insert into cruise.excursion values(2, 2, "Sightseeing by boat in Copenhagen" , "Get onboard one of our Hop On - Hop Off boat tours for an audio guided sightseeing tour through the harbor and idyllic canals..." , 200);
insert into cruise.excursion values( 3,3, "Pearl of the Black Sea" , "Though most famous for the Potemkin Steps leading down the Black Sea coast, Odessa welcomes visitors with several other attractions...",100);
insert into cruise.excursion values(4, 9, "olendam, Marken & Windmills with Free 1-Hour Canal Cruise", "Explore the Dutch countryside and leave Amsterdam behind for a half-day tour with free canal cruise included..." , 300);
insert into cruise.excursion values( 5,6, "City Sightseeing Stockholm Hop-On Hop-Off Tour" ,"See the spectacular sights of Stockholm during a City Sightseeing hop-on, hop-off bus tour...",50);
insert into cruise.excursion values(6, 11, "Oslo Highlights 3-Hour Bike Tour" ,"Cycle the flat city center streets of Oslo exploring all the major highlights...",200);

insert into cruise.excursionimage values(1,"http://i64.tinypic.com/t9ba5y.jpg",1);
insert into cruise.excursionimage values(2,"http://i65.tinypic.com/2jg5lp3.jpg",2);
insert into cruise.excursionimage values(3,"http://i66.tinypic.com/a1l503.jpg",3);
insert into cruise.excursionimage values(4,"http://i63.tinypic.com/34rizwz.jpg",4);
insert into cruise.excursionimage values(5,"http://i67.tinypic.com/211teag.jpg",5);
insert into cruise.excursionimage values(6,"http://i64.tinypic.com/2vtps7r.jpg",6);


insert into cruise.cruise values( 1,"DREAM1",1, 12,3, "2018-08-26 22:36:54" , "2018-10-26 22:36:54" , "VIP" ,2,100);
insert into cruise.cruise values( 2,"DREAM2",2, 11,13, "2018-09-26 22:36:54" , "2018-11-28 22:36:54" , "VIP" ,1,150);
insert into cruise.cruise values( 3,"DREAM3",4, 12,3, "2018-08-27 22:36:54" , "2018-09-26 22:36:54" , "ECONOM" ,3,1200);
insert into cruise.cruise values( 4,"DREAM4",3, 7,3, "2018-11-16 22:36:54" , "2018-08-16 22:36:54" , "BUSSINES" ,4,1300);
insert into cruise.cruise values( 5,"DREAM5",6, 5,9, "2018-02-16 22:36:54" , "2018-08-22 22:36:54" , "BUSSINES" ,6,1400);
