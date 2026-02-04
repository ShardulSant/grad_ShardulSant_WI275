Drop table if exists SiteDetails;
Drop table if exists OwnerDetails;
Create table SiteDetails(Type Varchar(20),Size_X Int,Size_Y Int,Maintainence Int,Paid Int,SiteId Int GENERATED ALWAYS AS IDENTITY (START WITH 100),  Primary Key(SiteId));
select * from SiteDetails;
Create table OwnerDetails(Name Varchar(20),PaidAmount Int,id Int GENERATED ALWAYS AS IDENTITY (START WITH 1000),SiteId INT,Constraint siteid_foreign_key FOREIGN KEY (SiteId) REFERENCES SiteDetails(SiteId),Primary Key(id));
Select * from OwnerDetails;
Insert into SiteDetails(Type, Size_X, Size_Y, Maintainence, Paid)
Values
('Villa',40,60,40*60*9,Null),
('Villa',40,60,40*60*9,Null),
('Villa',40,60,40*60*9,Null),
('Villa',40,60,40*60*9,Null),
('Villa',40,60,40*60*9,Null),
('Apartment',40,60,40*60*9,Null),
('Apartment',40,60,40*60*9,Null),
('Apartment',40,60,40*60*9,Null),
('Apartment',40,60,40*60*9,Null),
('Apartment',40,60,40*60*9,Null),
('Apartment',40,60,40*60*9,Null);

Insert into SiteDetails(Type, Size_X, Size_Y, Maintainence, Paid)
Values
('House',30,50,30*50*9,Null),
('House',30,50,30*50*9,Null),
('House',30,50,30*50*9,Null),
('House',30,50,30*50*9,Null),
('House',30,50,30*50*9,Null),
('Apartment',30,50,30*50*9,Null),
('Apartment',30,50,30*50*9,Null),
('Apartment',30,50,30*50*9,Null),
('Apartment',30,50,30*50*9,Null),
('Apartment',30,50,30*50*9,Null),
('Apartment',30,50,30*50*9,Null);


Insert into SiteDetails(Type, Size_X, Size_Y, Maintainence, Paid)
Values
('OpenSite',30,40,30*40*6,Null),
('OpenSite',30,40,30*40*6,Null),
('OpenSite',30,40,30*40*6,Null),
('OpenSite',30,40,30*40*6,Null),
('OpenSite',30,40,30*40*6,Null),
('Apartment',30,40,30*40*9,Null),
('Apartment',30,40,30*40*9,Null),
('Apartment',30,40,30*40*9,Null),
('Apartment',30,40,30*40*9,Null),
('Apartment',30,40,30*40*9,Null),
('Apartment',30,40,30*40*9,Null);

Select * from SiteDetails;









Insert into OwnerDetails(Name ,PaidAmount, siteId) Values
('a',100,100);
select * from OwnerDetails;

Insert into OwnerDetails(Name ,PaidAmount, siteId) Values
('b',100,101),
('c',100,102),
('d',100,103),
('e',100,104),
('f',100,105),
('g',100,106),
('h',100,107),
('i',100,108),
('j',100,109),
('k',100,110),
('m',100,112),
('n',100,113),
('o',100,114),
('p',100,115),
('q',100,116),
('r',100,117),
('s',100,118),
('t',100,119),
('u',100,120),
('v',100,121),
('w',100,122),
('x',100,123),
('y',100,124),
('z',100,125),
('abc',100,126),
('bcd',100,127),
('cde',100,128),
('def',100,129),
('efg',100,130);
select * from OwnerDetails;


