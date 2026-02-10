Drop table if exists SiteDetails;
Drop table if exists OwnerDetails;
Create table SiteDetails(Type Varchar(20),Size_X Int,Size_Y Int,Maintainence Int,Paid Int,SiteId Int GENERATED ALWAYS AS IDENTITY (START WITH 100),  Primary Key(SiteId));
select * from SiteDetails;
Create table OwnerDetails(Name Varchar(20),PaidAmount Int,id Int GENERATED ALWAYS AS IDENTITY (START WITH 1000),SiteId INT,Constraint siteid_foreign_key FOREIGN KEY (SiteId) REFERENCES SiteDetails(SiteId),Primary Key(id));
ALTER TABLE OwnerDetails
ADD Status VARCHAR(10) DEFAULT 'PENDING';

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

Insert into OwnerDetails(Name ,PaidAmount, siteId,Status) Values
('b',100,101,'APPROVED'),
('c',100,102,'APPROVED'),
('d',100,103,'APPROVED'),
('e',100,104,'APPROVED'),
('f',100,105,'APPROVED'),
('g',100,106,'APPROVED'),
('h',100,107,'APPROVED'),
('i',100,108,'PENDING'),
('j',100,109,'PENDING'),
('k',100,110,'PENDING'),
('m',100,112,'PENDING'),
('n',100,113,'PENDING'),
('o',100,114,'PENDING'),
('p',100,115,'PENDING'),
('q',100,116,'PENDING'),
('r',100,117,'PENDING'),
('s',100,118,'PENDING'),
('t',100,119,'PENDING'),
('u',100,120,'PENDING'),
('v',100,121,'PENDING'),
('w',100,122,'PENDING'),
('x',100,123,'PENDING'),
('y',100,124,'PENDING'),
('z',100,125,'PENDING'),
('abc',100,126,'PENDING'),
('bcd',100,127,'PENDING'),
('cde',100,128,'PENDING'),
('def',100,129,'PENDING'),
('efg',100,130,'PENDING');
select * from OwnerDetails;

