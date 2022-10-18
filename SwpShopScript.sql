CREATE DATABASE SWPShop
GO
USE SWPShop
GO
CREATE TABLE [Category] ( Id int IDENTITY(1,1) not null PRIMARY KEY,CategoryName nvarchar(50))
CREATE TABLE [Attribute] (Id int IDENTITY(1,1) not null PRIMARY KEY,AttributeName nvarchar(50), Unit nvarchar(10), 
DisplayIndex int, CategoryID int not null FOREIGN KEY REFERENCES Category(Id))
CREATE TABLE [Role] ( Id int IDENTITY(1,1) not null PRIMARY KEY, RoleName nvarchar(20))
CREATE TABLE [Account] ( Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, UserName nvarchar(255), FullName nvarchar(255),Email nvarchar(320) NOT NULL, Password nvarchar(255), Status BIT, 
Phone nvarchar(255), Address nvarchar(MAX), RoleID int not null FOREIGN KEY REFERENCES [Role](Id))
CREATE TABLE [Product] (Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, ProductName nvarchar(255), ProductPrice numeric(12,0), 
ProductQuantity int, ProductDesc nvarchar(MAX),  Rating float, CategoryID int not null FOREIGN KEY REFERENCES Category(Id),
UserID int not null FOREIGN KEY REFERENCES Account(Id), status bit)
CREATE TABLE [Image] ( Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, ImageLink nvarchar(MAX), 
ProductID int not null FOREIGN KEY REFERENCES Product(Id))
CREATE TABLE [ProductAttribute] (AttributeID int not null FOREIGN KEY REFERENCES Attribute(Id) , 
ProductID int not null FOREIGN KEY REFERENCES Product(Id), Value nvarchar(100), primary key(AttributeID, ProductID))
CREATE TABLE [Wallet]( Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, Amount Float, UserID int not null FOREIGN KEY REFERENCES Account(Id))
CREATE TABLE [Order] (Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, OrderDate Date, ShipDate Date, ShipAddress nvarchar(MAX) ,TotalPrice float, 
UserID int not null FOREIGN KEY REFERENCES Account(Id),
ProductID int not null FOREIGN KEY REFERENCES Product(Id)) 
CREATE TABLE [Payment](Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, PaymentTime smalldatetime, Amount float, PaymentType nvarchar(100), OrderID int not null FOREIGN KEY REFERENCES [Order](Id))
CREATE TABLE [Transaction] ( Id int IDENTITY(1,1) NOT NULL PRIMARY KEY, Amount Float, WalletID int not null FOREIGN KEY REFERENCES Wallet(Id), 
PaymentID int not null FOREIGN KEY REFERENCES Payment(Id))
---ROLES 3
INSERT INTO [Role](RoleName) VALUES ('Admin');
INSERT INTO [Role](RoleName) VALUES ('User');
INSERT INTO [Role](RoleName) VALUES ('Seller');
---ACCOUNTS 4
INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID)
VALUES ('SE162165', 'Le Nguyen Nhat Minh','minhlnnse162165@fpt.edu.vn', '1', 1, 0256489485, '37 Quang Trung, Hoan Kiem, Ha Noi',1);
INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID)
VALUES ('admin', 'Nguyen Viet Hung', 'hungnvse151468@fpt.edu.vn','1', 1, 0264857954, ' 85/32 Tran Dinh Xu, Nguyen Cu Trinh, Ho Chi Minh',1);
INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID)
VALUES ('SE151366', 'Nguyen Hoang Phi Long','longnhpse151366@fpt.edu.vn', '1', 0, 0318465248, '9, Truong Thi, Vinh',2);
INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID)
VALUES ('SE151131', 'Truong Thanh Trung', 'trungttse151131@fpt.edu.vn','1', 1, 0548432154, '202 - 204 Hung Vuong, Tan An',3);
INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID)
VALUES ('SA651651', 'Ton That Bao Giang', 'giangttbsa651651@fpt.edu.vn','1', 1, 0156168943, '316 Hung Vuong, Tay Ninh',3);
---CATEGORY 5
INSERT INTO Category(CategoryName)
VALUES ('Electronics');
INSERT INTO Category(CategoryName)
VALUES ('Fashions');
INSERT INTO Category(CategoryName)
VALUES ('Bike');
INSERT INTO Category(CategoryName)
VALUES ('Books');
INSERT INTO Category(CategoryName)
VALUES ('Hobbies');
INSERT INTO Category(CategoryName)
VALUES ('Stationery');
---ATTRIBUTES 5
INSERT INTO Attribute(AttributeName,Unit,DisplayIndex,CategoryID)
VALUES ('Color','',1,3);
INSERT INTO Attribute(AttributeName,Unit,DisplayIndex,CategoryID)
VALUES ('Size','',2,2);
INSERT INTO Attribute(AttributeName,Unit,DisplayIndex,CategoryID)
VALUES ('Material','Type',3,5);
INSERT INTO Attribute(AttributeName,Unit,DisplayIndex,CategoryID)
VALUES ('Genre','Type',4,4);
INSERT INTO Attribute(AttributeName,Unit,DisplayIndex,CategoryID)
VALUES ('Model','Number',5,1);
---PRODUCT 20
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Surface Laptop Studio', 445, 1, 'The latest surface model of Microsoft-class design, luxury, fashion, powerful configuration for graphics, heavy applications.', 
5, 1, 1 ,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Samsung Galaxy Note 10 Plus 5G 256GB', 63, 3, 'Samsung Galaxy Note 10+ 5G American device', 
3,1,3,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Taylor GS Mini', 10,1, 'Because I dont have time to play, I need to pass the Taylor Gs Mini, which has a pickup available for you to perform, and gives you an extra strap for you to wear to perform.',
4,5,3,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Metal Brass Chinese Chess Set', 2, 5, 'Solid brass chess set',
2,5,4,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Winner 150Fi 2017', 22, 1, 'My bike Winner 150Fi V1 beautiful model of current winner line The bike is original and has not been replaced with any parts. Quiet, powerful, and especially more fuel-efficient than other models .The bike has just peeled off the glue, and the zin stamp is still very beautiful. My bike is wearing Michelin tires. The bike is in perfect condition',
4,3,4,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Wave Hyosung Korea 50cc Motorcycle', 11, 2, 'Wave registration 06/2022. Just ran 1459km',
1,3,1,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Old light novels rarely read', 1, 15, 'Paper quality like new, all wrapped in plastic',
3,4,1,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Cheap old books', 4,20,'I have some old books, beautiful or a bit torn and yellowed, all priced from 20k-60k depending on the book',
4,4,3,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Seiko 5 Made in Japan', 80, 1, 'Before going on a business trip to Japan, I bought a 2.2man Seiko 5 watch for my father to use. Now he does not use, I to pass it on to anyone who needs it.',
5,2,1,1);
INSERT INTO Product(ProductName,ProductPrice,ProductQuantity,ProductDesc,Rating,CategoryID,UserID,status)
VALUES('Converse Chuck Taylor II Engineered Canvas 80%', 40, 3, 'Color: blue lagoon/red block/white.',
4,2,4,1);
---Hùng
INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES ( N'Kawasaki Z1000 2015', CAST(6000 AS Numeric(12, 0)), 1, N'Guaranteed original car, owner, have a job so need to sell', 4, 3, 2, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N' IPAD MINI 3', CAST(149 AS Numeric(12, 0)), 5, N'Only selling genuine original APPLE machines, suitable for parents who can see the content more clearly', 4, 1, 3, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N' LG VELVET', CAST(210 AS Numeric(12, 0)), 2, N'Original product, main zin, screen zin, not repaired', 5, 1, 4, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES ( N'MACBOOK PRO 2015', CAST(399 AS Numeric(12, 0)), 1, N'Overall the machine is very nice & modern.', 4, 1, 2, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES ( N'Raider Fi', CAST(1499 AS Numeric(12, 0)), 2, N'Wave registration 10/2020. Just ran 7.500km', 4, 3, 2, 1)

INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N'Air Jordan 1 Low ‘White Wolf Grey’', CAST(500 AS Numeric(12, 0)), 2, N'Color: Grey/White.', 5, 2, 2, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N'Polo MLB', CAST(200 AS Numeric(12, 0)), 1, N'Color: blue| Size: XL', 5, 2, 3, 1)

INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N'Elon Musk', CAST(5 AS Numeric(12, 0)), 10, N'How the Billionaire CEO of SpaceX and Tesla is Shaping our Future', 4, 4, 1, 1)

INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N'Why We Sleep', CAST(15 AS Numeric(12, 0)), 3, N'A New York Times bestseller and international sensation, this “stimulating and important book” (Financial Times)"', 4, 4, 2, 1)

INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES (N'Nonprofit Management: Principles And Practice', CAST(49 AS Numeric(12, 0)), 3, N'In his student-friendly bestseller, Michael J. Worth covers the scope and structure of the non-profit sector from leadership of non-profits to social entrepreneurship.', 5, 4, 1, 1)

INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES ( N'Dior 30 Montain Micha Twilly Silk 15 Mon', CAST(450 AS Numeric(12, 0)), 1, N'Color: Black/White.', 5, 2, 3, 1)
---Long

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
(N'Hot Wheels: Shark Attack paperback book', CAST(5 AS Numeric(12, 0)), 1, N'Team Hot Wheels is trying out a brand-new stunt. They will speed down a pier and through three loops over the ocean. But watch out! These waters are shark infested. Can Team Hot Wheels survive this challenge?', 4, 4, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
( N'Seeds and Trees - Picture Book', CAST(10 AS Numeric(12, 0)), 1, N'Its time to tell a special tale that will warm the hearts of readers of all ages. Seeds and Trees revels in the power of words. It explores their effects on feelings and emotions. And it does so through the journey of two different seeds.', 4, 4, 5, 1)

INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
(N'Portable Refractor Telescope', CAST(100 AS Numeric(12, 0)), 1, N'Superior optics: The Celestron 70mm Travel Scope features high-quality, fully-coated glass optics, a potent 70mm objective lens, a lightweight frame, and a custom backpack to carry it all. Its quality is unmatched in its class and against competitors.', 4, 1, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
(N'Nintendo Switch', CAST(289 AS Numeric(12, 0)), 1, N'3 Play Styles: TV Mode, Tabletop Mode, Handheld Mode, 6.2-inch, multi-touch capacitive touch screen, 4.5-9 plus Hours of Battery Life will vary depending on software usage conditions, Connects over Wi-Fi for multiplayer gaming; Up to 8 consoles can be connected for local wireless multiplayer, Model number: HAC-001(-01)', 5, 1, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
( N'Shoes Women Madison Sneaker', CAST(49 AS Numeric(12, 0)), 1, N'SUSTAINABLY CRAFTED: Soft linings and microfiber made from recycled bottles, MATERIALS: Faux leather, fabric, or microfiber made from recycled plastic bottles, FIT: Slip-on fit with padded collar and twin stretch gore panels, SUSTAINABLE COMFORT: Insole Technology with anatomical cushioning, comfort & support, MOVEMENT: Lightweight, flexible construction moves with you', 5, 2, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
( N'Boys Fleece Hoodie', CAST(30 AS Numeric(12, 0)), 1, N'Armour Fleece is light, breathable & stretches for superior mobility, Soft inner layer traps heat to keep you warm & comfortable, Front kangaroo pocket, Color pop binding details on cuffs & pocket', 4, 2, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
(N'Mountain Bike', CAST(500 AS Numeric(12, 0)), 1, N'Assembly tutorial video located beside the images; with a Denim Blue hardtail frame and 21 speeds to conquer the trails, the Huffy Stone Mountain is ready for outdoor adventures; just follow the steps in our product manual', 3, 3, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
(N'Full Face Motorcycle Street Bike Helmet', CAST(58 AS Numeric(12, 0)), 1, N'Boasting a compact, aerodynamic DOT shell design with sharp and aggressive styling for impeccable impact protection to excel whether short-distance street performance or long-distance touring comfort.', 5, 3, 1, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
( N'4 Wheel Drive Stunt Car Toy for Kids', CAST(36 AS Numeric(12, 0)), 1, N'4 Wheel Stunt Toy Car: Enjoy endless fun, 360° Rotating Remote Controlled Toy Car: Double-sided Car move fearlessly and freely.', 4, 5, 5, 1)

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) 
VALUES 
( N'Walthers Cornerstone HO Scale Model Kit o', CAST(27 AS Numeric(12, 0)), 1, N'Easy PA alongside any older home from the 1900S to the present, Build with overhead door open or closed, Parts for two complete garages, Molded in two colors, Detailed interior framing - add a scene master garage detail Set (949-4167 available separately) for more realism!', 4, 5, 1, 1)
---Trung

INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'Old Ram Samsung 4GB DDR3', CAST(100 AS Numeric(12, 0)), 5, N'Loại: RAM Desktop Dung lượng: 8GBBus: 2133Điện Áp: 1.2V Bảo hành 36 tháng', 5, 1, 4, 1)
INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'LEGO THREE KINGDOMs', CAST(60 AS Numeric(12, 0)), 3, N'Lego three kingdoms in the Romance of Three kingdoms with 3 character: Lubu, Doug zhou, Diao Chan', 5, 3, 4, 1)
INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'TAD COAT', CAST(300 AS Numeric(12, 0)), 1, N'Built to navigate diverse customs and environments, the TAD Protocol Jacket brings modern performance and casual elegance to a classic silhouette.', 3, 2, 4, 1)
INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'Numerology book', CAST(50 AS Numeric(12, 0)), 1, N'Numerology is an ancient study that draws meaning from different numbers, number combinations, letters, and symbols in your life. This art can help us tap into the underlying patterns of the universe and reveal new truths about who we are.', 5, 4, 4, 1)
INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'DualShock 4', CAST(500 AS Numeric(12, 0)), 2, N'The old Dualshock 4, sell for dualsense ', 4, 1, 4, 1)
INSERT [dbo].[Product] ([ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'guitar taylo', CAST(3000 AS Numeric(12, 0)), 2, N'guitar taylor, use under 3 month, have leather bag for guitar', 2, 5, 4, 1)
INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'Plastic Chair', CAST(25 AS Numeric(12, 0)), 15, N'Chairs are like new, all wrapped in plastic', 5, 5, 4, 1)
INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'Kamen rider belt', CAST(1000 AS Numeric(12, 0)), 3, N'CSM_Colletion belt like movie, kamen rider decade, faiz and kabuto ', 5, 5, 4, 1)
INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'fin coffe viet nam', CAST(2 AS Numeric(12, 0)), 100, N'fin vietNam, make your coffe more quality ', 5, 5, 4, 1)
INSERT [dbo].[Product] ( [ProductName], [ProductPrice], [ProductQuantity], [ProductDesc], [Rating], [CategoryID], [UserID], [status]) VALUES ( N'Multitool Letherman', CAST(60 AS Numeric(12, 0)), 3, N'Multitool lether man rep 1:1 have 25 function. weight: 335g, length: 11.5cm', 4, 5, 4, 1)

---PROATTR 5
INSERT INTO ProductAttribute(AttributeID,ProductID,Value)
VALUES(5,1,'Surface Laptop Studio Intel i5');
INSERT INTO ProductAttribute(AttributeID,ProductID,Value)
VALUES(1,5,'Red');
INSERT INTO ProductAttribute(AttributeID,ProductID,Value)
VALUES(3,4,'Brass');
INSERT INTO ProductAttribute(AttributeID,ProductID,Value)
VALUES(2,10,'9US');
INSERT INTO ProductAttribute(AttributeID,ProductID,Value)
VALUES(4,8,'Self-help');
---IMAGE 5 FOR 3 PRODUCT
INSERT INTO [Image](ImageLink,ProductID)
VALUES('surface.jpg',1);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('samsung.jpg',2);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('taylor.jpg',3);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('chess.jpg',4);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('winner.jpg',5);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('wave.jpg',6);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('novel.jpg',7);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('book.jpg',8);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('seiko.jpg',9);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('converse.jpg',10);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (2).jpg',11);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (5).jpg',12);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (7).jpg',13);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (8).jpg',14);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (11).jpg',15);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (6).jpg',16);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (10).jpg',17);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (4).jpg',18);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (1).jpg',19);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (9).jpg',20);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('h (3).jpg',21);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (1).jpeg',22);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (6).jpg',23);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (7).jpg',24);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (8).jpg',25);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (9).jpg',26);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (1).jpg',27);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (2).jpg',28);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (3).jpg',29);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (4).jpg',30);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('l (5).jpg',31);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (1).jpg',32);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (8).jpg',33);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (4).jpg',34);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (3).jpg',35);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (6).jpg',36);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('guitar.png',37);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (2).jpg',38);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (5).jpg',39);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (7).jpg',40);
INSERT INTO [Image](ImageLink,ProductID)
VALUES('t (9).jpg',41);


